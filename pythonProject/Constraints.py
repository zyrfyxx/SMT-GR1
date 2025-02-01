from math import trunc
import time

import numba
from z3 import *
import Spec
import itertools
import copy



class Constraints:
    def __init__(self):
        self.nextCombinationsList = None
        self.next_partitioned_constraints = None
        self.nextConstraintList = []
        self.nextConstraintDict = {}
        self.booleanKind = None
        self.combinationsList = None
        self.partitioned_constraints = None
        self.variableDict = {}
        self.solver = Solver()
        self.constraintDict = {}
        self.constraintList = []
        self.iniConstraintList = []
    
    def getBooleanKind(self, booleanKind):
        self.booleanKind = booleanKind

    def getIniBooleanState(self):
        iniExprState = self.getExprValue(self.iniConstraintList, self.constraintList)
        # print(self.constraintDict)
        # print(iniExprState)
        result = {}
        for i in iniExprState:
            key = self.constraintDict[i]
            value = iniExprState[i]
            result[key] = value

        return result

    def addIniConstraint(self, constraint):
        print("CONSTRAINT:")
        print(constraint)
        exp = eval(constraint, {}, self.variableDict)
        self.iniConstraintList.append(exp)

    def getExprValue(self, expr_list1, expr_list2):


        solver = Solver()
        for expr in expr_list1:
            print(expr)
            solver.add(expr)
        result = {}
        for expr in expr_list2:
            solver.push()
            solver.add(expr)
            # print(solver)
            result_expr = solver.check()
            solver.pop()

            solver.push()
            solver.add(Not(expr))
            result_not_expr = solver.check()
            solver.pop()

            # print(expr)
            # print(result_expr)
            # print(result_not_expr)

            if result_expr == sat and result_not_expr == unsat:
                result[expr] = True
            elif result_expr == unsat and result_not_expr == sat:
                result[expr] = False
            elif result_expr == sat and result_not_expr == sat:
                result[expr] = "Undetermined"
            else:
                print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        return result


    def getConstraintStrValue(self):
        allCores, coreTime = self.calculateAllCores_Punch()
        allCores += self.calculateAllNextCores_Punch()
        constraintStrValue = []
        print("NUM OF ALL CORES:", len(allCores))
        print("======================================")
        # print("All cores: ", allCores)
        # print(self.constraintDict)
        for core in allCores:
            value = {}
            for exp2 in self.constraintDict.keys():
                if exp2 in core:
                    constraintStr = self.constraintDict[exp2]
                    value[constraintStr] = True
                if Not(exp2) in core:
                    constraintStr = self.constraintDict[exp2]
                    value[constraintStr] = False
            for exp2 in self.nextConstraintDict.keys():
                if exp2 in core:
                    constraintStr = self.nextConstraintDict[exp2]
                    value[constraintStr] = True
                if Not(exp2) in core:
                    constraintStr = self.nextConstraintDict[exp2]
                    value[constraintStr] = False
            constraintStrValue.append(value)
        # print(constraintStrValue)
        return constraintStrValue, coreTime


    def addConstraint(self, constraint):
        # print("=====")
        # print(self.variableDict)
        exp = eval(constraint, {}, self.variableDict)
        self.constraintDict[exp] = constraint
        self.constraintList.append(exp)
    def addConstraints(self, constraints):
        for constraint in constraints:
            exp = eval(constraint, {}, self.variableDict)
            self.constraintDict[exp] = constraint
            self.constraintList.append(exp)
    
    def addNextConstraint(self, constraint):
        exp = eval(constraint, {}, self.variableDict)
        self.nextConstraintDict[exp] = constraint
        self.nextConstraintList.append(exp)

    def addVariable(self, variable, type):
        if type == "int":
            self.variableDict[variable] = Int(variable)
        elif type == "float":
            self.variableDict[variable] = Real(variable)

    def addvarInNext(self, variable, type):
        pass

    def nextDecompose(self):
        graph = build_constraint_graph(self.nextConstraintList)
        connected_components = find_connected_components(graph)
        partitioned_constraints = [[self.nextConstraintList[i] for i in component] for component in connected_components]
        # print("Partitioned Constraints: ", partitioned_constraints)
        self.next_partitioned_constraints = partitioned_constraints


    def decompose(self):
        graph = build_constraint_graph(self.constraintList)
        connected_components = find_connected_components(graph)
        partitioned_constraints = [[self.constraintList[i] for i in component] for component in connected_components]
        print("Partitioned Constraints: ", partitioned_constraints)
        self.partitioned_constraints = partitioned_constraints

    def getAllNextCombinations(self):
        combinationsList = []
        for constraints in self.next_partitioned_constraints:
            combinations = all_combinations(constraints)
            combinationsList.append(combinations)
        self.nextCombinationsList = combinationsList
        return combinationsList

    def getAllCombinations(self):
        combinationsList = []
        for constraints in self.partitioned_constraints:
            combinations = all_combinations(constraints)
            combinationsList.append(combinations)
        self.combinationsList = combinationsList
        return combinationsList

    def check(self, constraints):
        # return example.check(list(constraints))

        self.solver.push()
        checkResult = True
        for constraint in constraints:
            self.solver.add(constraint)
        if self.solver.check() == z3.unsat:
            checkResult = True
        else:
            checkResult = False
        self.solver.pop()
        # print("Checking constraints: ", constraints, "   Check Result: ", checkResult)
        return checkResult

    def ddmin(self, clauses, n=2):
        if len(clauses) == 1:
            return []

        parts = partition(clauses, n)
        for part in parts:
            if check(part):
                return self.ddmin(part, 2)
        for part in parts:
            ramaining = [cl for cl in clauses if cl not in part]
            if check(ramaining):
                return self.ddmin(ramaining, max(n-1, 2))
        if n>=len(clauses):
            return clauses

        return self.ddmin(clauses, min(len(clauses), 2 * n))

    # @numba.jit(nopython=True)
    def computeCore(self, constraints, computedSet):
        if not self.check(constraints):
            return []
        for r in range(2, len(constraints)+1):
            for subset in itertools.combinations(constraints, r):
                # if not self.check(subset):
                #     continue
                if set(subset) in computedSet:
                    # print("Computed: ", subset)
                    continue
                # print("Subset: ", subset)
                # print(computedSet)
                computedSet.append(set(subset))
                # print(len(computedSet))
                if self.check(subset):
                    is_minimal = True
                    for sub_subset in itertools.combinations(subset, r - 1):
                        if self.check(sub_subset):
                            is_minimal = False
                            break
                    if is_minimal:
                        # print("MINIMAL: ", subset)
                    # print("Core: ", list(subset))
                        return list(subset)
        return []


    def findAllCoresFromCombination(self, constraints, searched_combinations, current_cores):
        core_sets = []
        for r in range(2, len(constraints)+1):
            for subset in itertools.combinations(constraints, r):
                # print(subset)
                if set(subset) in searched_combinations:
                    continue
                if set(subset) in current_cores:
                    continue
                if self.check(subset):
                    is_minimal = True
                    for sub_subset in itertools.combinations(subset, r-1):
                        if self.check(sub_subset):
                            is_minimal = False
                            break
                    if is_minimal:
                        # print("MINIMAL: ", subset)
                        core_sets.append(subset)
                searched_combinations.append(set(subset))
        return [set(core) for core in core_sets]


    def Punch(self, clauses, searchedSet, computedSet):
        # print(searchedSet)
        # print("Punching: ", clauses)
        if len(clauses) <= 1:
            return []
        core = self.computeCore(clauses, computedSet)
        # core = self.ddmin(clauses)
        if core == []:
            # print("No core found")
            return []
        AllCores = [core]
        Cont = []

        for x in core:
            tempClauses = []
            for i in clauses:
                tempClauses.append(i)
            # tempClauses = copy.deepcopy(clauses)
            # print("Remove: " , x)
            # print("Remove Result: ", tempClauses)
            if self.check(tempClauses):
                Cont.append(x)
        # print("Cont", Cont)

        for x in Cont:
            tempClauses = []
            for i in clauses:
                tempClauses.append(i)
            # print("Punching from: ", tempClauses)
            # print("Exclude: ", x)
            # tempClauses = copy.deepcopy(clauses)
            tempClauses.remove(x)
            # print("Exclude Result: " , tempClauses)

            # print("+++++++++++++++++++")
            if set(tempClauses) in searchedSet:
                # print("Passed: ", tempClauses)
                continue
            cores = self.Punch(tempClauses, searchedSet, computedSet)
            # cores = self.ddmin(tempClauses)
            searchedSet.append(set(tempClauses))
            if cores != []:
                AllCores += cores
        # print("AllCores: ", AllCores)
        return AllCores



    def calculateAllCores(self):
        self.decompose()
        core_result = []
        allCombinations = self.getAllCombinations()
        # print("All Combinations: ", len(allCombinations))
        for combinations in allCombinations:
            curremt_core = []
            searched_combinations = []
            for combination in combinations:
                all_cores = self.findAllCoresFromCombination(combination, searched_combinations, curremt_core)
                for core in all_cores:
                    if core not in curremt_core:
                        curremt_core.append(core)
                        core_result.append(core)
                if combination not in searched_combinations:
                    searched_combinations.append(combination)
        # if len(core_result) >0:
        #     print("All COres:")
        #     for i in core_result:
        #         print(i)

    def calculateAllNextCores_Punch(self):
        AllCores = []
        searchedSet = []
        computedSet = []
        self.nextDecompose()
        allCombinations = self.getAllNextCombinations()
        # print("All Combinations: ", len(allCombinations))
        for combinations in allCombinations:
            # print("Combinations: ", combinations)
            for combination in combinations:
                cores = self.Punch(list(combination), searchedSet, computedSet)
                AllCores.extend(cores)
        # print("Cores: ")
        # for i in AllCores:
        #     print(i)
        # print("All Cores: ", AllCores)
        return AllCores

    def calculateAllCores_Punch(self):
        t1 = time.time()
        self.decompose()
        allCombinations = self.getAllCombinations()
        # AllCores = example.calAllCore(allCombinations)
        AllCores = []
        searchedSet = []
        computedSet = []
        #
        # # print("All Combinations: ", allCombinat0ions)
        # print("All Combinations: ", len(allCombinations[0]))
        for combinations in allCombinations:
        #     # print("Combinations: ", combinations)
            for combination in combinations:
                cores = self.Punch(list(combination), searchedSet, computedSet)
                AllCores.extend(cores)
        # print("Cores: ")
        # for i in AllCores:
        #     print(i)
        # print("All Cores: ", AllCores)
        t2 = time.time()
        print("==========Time==========")
        coreTime = t2 - t1
        print(1000*(t2-t1), "ms")

        return AllCores, coreTime

def partition(clauses, n):
    part_size = max(1, len(clauses) // n)
    return [clauses[i:i + part_size] for i in range(0, len(clauses), part_size)]

def all_combinations(atomic_constraints):
    
    pairs = [(constraint, Not(constraint)) for constraint in atomic_constraints]

    
    combinations = list(itertools.product(*pairs))

    return combinations

def build_constraint_graph(constraints):

    graph = {}
    var_to_constraints = {}

    
    for i, constraint in enumerate(constraints):
        # print(i, constraint)
        vars_in_constraint = extract_vars_from_constraint(constraint)
        for var in vars_in_constraint:
            if var not in var_to_constraints.keys():
                var_to_constraints[var] = set()
                var_to_constraints[var].add(i)
            else:
                var_to_constraints[var].add(i)

    # print("var_to_constraints", var_to_constraints)

    
    for indices in var_to_constraints.values():
        for i in indices:
            for j in indices:
                if i not in graph.keys():
                    graph[i] = set()
                if j not in graph.keys():
                    graph[j] = set()
                if i != j:
                    graph[i].add(j)
                    graph[j].add(i)
    # print("GRAPH ", graph)
    return graph

def find_connected_components(graph):

    visited = set()
    components = []

    def dfs(node, component):
        visited.add(node)
        component.append(node)
        for neighbor in graph[node]:
            if neighbor not in visited:
                dfs(neighbor, component)

    for node in graph:
        if node not in visited:
            component = []
            dfs(node, component)
            components.append(component)
    # print("COMPONENTS ", components)

    return components

def extract_vars_from_constraint(constraint):

    vars_set = set()

    def collect_vars(expr):
        if is_const(expr) and expr.decl().kind() == Z3_OP_UNINTERPRETED:
            vars_set.add(expr)
        for child in expr.children():
            collect_vars(child)

    collect_vars(constraint)
    return vars_set

def calculateBooleanValue():
    specList = Spec.SpecInit()
    for spec in specList:
        print("-------------------------------------------------------------------")
        print(spec.finalSpecPath)
        constraints = Constraints()
        v2tDict = spec.variable2TypeDict
        f2bDict = spec.formula2Boolean
        print("CONSTRAINT NUMbER: ", len(f2bDict))
        iniList = spec.iniConstraintList
        next2Prime = spec.nextFormula2Boolean
        # print(iniList)
        for var in v2tDict.keys():
            constraints.addVariable(var, v2tDict[var])
        # print(v2tDict)
        for f in f2bDict.keys():
            f = f.replace('>=', '_LGE_')
            f = f.replace('<=', '_SME_')
            f = f.replace('=', '==')
            f = f.replace('_LGE_', '>=')
            f = f.replace('_SME_', '<=')
            if 'next' not in f:
                constraints.addConstraint(f)
        for f in next2Prime.keys():
            f2bDict[f] = next2Prime[f]
            f = f.replace('>=', '_LGE_')
            f = f.replace('<=', '_SME_')
            f = f.replace('=', '==')
            f = f.replace('_LGE_', '>=')
            f = f.replace('_SME_', '<=')
            constraints.addNextConstraint(f)
        for i in iniList:
            constraints.addIniConstraint(i.replace('=', '=='))
        fStrValue, coreTime = constraints.getConstraintStrValue()
        # print("Formula value: ", fStrValue)
        # f2bDict += next2Prime
        # print("Formula 2 boolean mapping: ", f2bDict)
        booleanValueList = []
        for fStr2b in fStrValue:
            b2b = {}
            for f in fStr2b.keys():
                booleanName = f2bDict[f.replace('==', '=')]
                b2b[booleanName] = fStr2b[f]
            booleanValueList.append(b2b)
        print("Core in boolean: ", booleanValueList)

        exp2value = constraints.getIniBooleanState()
        iniBooleanState = {}
        # print(exp2value)
        for exp in exp2value:
            key = f2bDict[exp.replace('==', '=')]
            value = exp2value[exp]
            iniBooleanState[key] = value
        # print("Init boolean state: ", iniBooleanState)
        # print(spec.booleanKindDict)
        spec.iniStateGen(iniBooleanState)
        spec.coreConstraintGen(booleanValueList)
        spec.finalSpecGen()
        # break


if __name__ == "__main__":
    calculateBooleanValue()
