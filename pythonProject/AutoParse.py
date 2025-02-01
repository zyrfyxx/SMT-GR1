
from z3 import *
import Execute
import basicGR1parser

class Parser:
    def __init__(self):
        self.stateBoolDict = {}
        self.allExpr2Bool = None
        self.state_bool_value_dict = {}
        self.state_var_value_dict={}
        self.outputValue = None
        self.outBoolValue = None
        self.outDigitalValue = None
        self.sysExpr2Bool = {}
        self.outExprValue = None
        self.outputSys = None
        self.digitalKindPath = None
        self.digitalTypePath = None
        self.newBoolKind = None
        self.boolKindPath = None
        self.expr2Bool = None
        self.expr2BoolPath = None
        self.envInputDict = None
        self.envExpr = None
        self.expression_list = None
        self.var_value_dict = {}
        self.bool_value_dict = {}
        self.envBoolDict = {}
        self.envDigitalType = {}
        self.sysDigitalType = {}

    # def getCurrentState(self):
    #
    #     return {}

    def InitAutomation(self):
        pass

    def RunningAutomation(self, currentState, input):
        outputSys = basicGR1parser.parser(currentState, input)
        self.outputSys = outputSys

        return outputSys
    
    def getOutExprValue(self):
        outExprValue = {}
        # print(self.expr2Bool.values())
        outBooleanValue = {}
        for outBoolName, outBoolValue in self.outputSys.items():
            if outBoolName not in self.newBoolKind.keys():
                # print(outBoolName, outBoolValue)
                outBooleanValue[outBoolName] = outBoolValue
            for exprName, boolName in self.sysExpr2Bool.items():
                # print("outBoolName: ", outBoolName)
                # print("boolName", boolName)
                if outBoolName == boolName:
                    outExprValue[exprName] = outBoolValue
        self.outExprValue = outExprValue
        self.outBoolValue = outBooleanValue
        return self.outExprValue

    def getOutDigitalValue(self):
        # outDigitalValue = {}
        # print(self.sysDigitalType)
        # print("sysDigitalType: ", self.sysDigitalType, "outExprValue: ", self.outExprValue)
        results = Execute.solve_variables(self.outExprValue, self.sysDigitalType)
        self.outDigitalValue = results

    def getOutputValue(self):
        outputValue = {}
        for i,j in self.outBoolValue.items():
            outputValue[i] = j
        for i,j in self.outDigitalValue.items():
            outputValue[i] = j
        self.outputValue = outputValue
                

    def getDigitalType(self, digitalTypePath):
        self.digitalTypePath = digitalTypePath
        digital2Type = {}
        with open(self.digitalTypePath, 'r') as f:
            digitalTypes = f.readlines()
            for digitalType in digitalTypes:
                digitalName = digitalType.split(':')[0].strip()
                digitalType = digitalType.split(':')[1].strip()
                digital2Type[digitalName] = digitalType
        # print(digital2Type)
        return digital2Type

    def getDigitalKind(self, digitalTypePath, digitalKindPath):
        digital2Type = self.getDigitalType(digitalTypePath)
        self.digitalKindPath = digitalKindPath
        with open(self.digitalKindPath, 'r') as f:
            digitalKinds = f.readlines()
            for digitalKind in digitalKinds:
                digitalName = digitalKind.split(':')[0].strip()
                digitalKind = digitalKind.split(':')[1].strip()
                digitalType = digital2Type[digitalName]
                if digitalKind == 'env':
                    self.envDigitalType[digitalName] = digitalType
                elif digitalKind == 'sys':
                    self.sysDigitalType[digitalName] = digitalType

    def getEnvValue(self, envInputDict):
        self.envInputDict = envInputDict
        for name, value in self.envInputDict.items():
            # print(name, value, type(value))
            if type(value) is float: # isinstance(value, float):
                # print("Float: ", name, value)
                self.var_value_dict[name] = value
            elif type(value) is int:
                # print("Int: ", name, value)
                self.var_value_dict[name] = value
            else:
                self.bool_value_dict[name] = value
            # else:
            #     pass
        # print("Boolean Input Value: ", self.bool_value_dict)
        # print("Digital Input Value: ", self.var_value_dict)

    def getCurrentStateValue(self, stateValue):
        self.stateValue = stateValue
        for name, value in self.stateValue.items():
            # print(name, value, type(value))
            if type(value) is float: # isinstance(value, float):
                # print("Float: ", name, value)
                self.state_var_value_dict[name] = value
            elif type(value) is int:
                # print("Int: ", name, value)
                self.state_var_value_dict[name] = value
            else:
                self.state_bool_value_dict[name] = value


    def getnewBoolKind(self, boolKindPath):
        self.boolKindPath = boolKindPath
        newBoolKind = {}
        with open(self.boolKindPath, 'r') as f:
            boolKinds = f.readlines()
            for boolKind in boolKinds:
                boolName = boolKind.split(':')[0].strip()
                kind = boolKind.split(':')[1].strip()
                newBoolKind[boolName] = kind
            self.newBoolKind = newBoolKind

    def getExpr2Bool(self, expr2BoolPath):
        self.expr2BoolPath = expr2BoolPath
        expr2Bool = {}
        sysExpr2Bool = {}
        allExpr2Bool = {}
        with open(expr2BoolPath, 'r') as f:
            expr2Bools = f.readlines()
            for line in expr2Bools:
                expr = line.split(':')[0].strip()
                expr = expr.replace('>=', '_LGE_')
                expr = expr.replace('<=', '_SME_')
                expr = expr.replace('=', '==')
                expr = expr.replace('_LGE_', '>=')
                expr = expr.replace('_SME_', '<=')
                boolName = line.split(':')[1].strip()
                allExpr2Bool[expr] = boolName
                if self.newBoolKind[boolName] == 'env':
                    expr2Bool[expr] = boolName
                elif self.newBoolKind[boolName] == 'sys':
                    sysExpr2Bool[expr] = boolName
            self.expr2Bool = expr2Bool
            self.sysExpr2Bool = sysExpr2Bool
            self.allExpr2Bool = allExpr2Bool

    

    


    def calculateState(self):
        value_dict = self.state_var_value_dict
        # print(value_dict)
        expression_list = self.allExpr2Bool.keys()
        # print(expression_list)
        z3_vars = {name: Real(name) if isinstance(value, float) else Int(name)
                   for name, value in value_dict.items()}
   
        solver = Solver()
    
        for name, value in value_dict.items():
            solver.add(z3_vars[name] == value)
        results = {}
        for expr in expression_list:
    
            z3_expr = eval(expr, {}, z3_vars)
            results[expr] = solver.check(z3_expr) == sat
        
        print("State Expression Value: ", results)
        for name, value in self.state_bool_value_dict.items():
            self.stateBoolDict[name] = value
        for name, value in results.items():
            boolName = self.allExpr2Bool[name]
            self.stateBoolDict[boolName] = value
        return self.stateBoolDict
        
        
    def getBoolInput(self):
        # print(self.bool_value_dict)
        for name, value in self.bool_value_dict.items():
            self.envBoolDict[name] = value
        # print(self.envBoolDict)
        for name, value in self.envExpr.items():
            boolName = self.expr2Bool[name]
            self.envBoolDict[boolName] = value
        return self.envBoolDict

    def evaluate_z3_expressions(self):
        value_dict = self.var_value_dict
  
        expression_list = self.expr2Bool.keys()
        z3_vars = {name: Real(name) if isinstance(value, float) else Int(name)
                   for name, value in value_dict.items()}
      
        solver = Solver()
    
        for name, value in value_dict.items():
            solver.add(z3_vars[name] == value)
        results = {}
        for expr in expression_list:
    
            z3_expr = eval(expr, {}, z3_vars)
            results[expr] = solver.check(z3_expr) == sat
        self.envExpr = results
        print("Input Expression Value: ", results)

def getEnvValue():
    value = {'carsMain': 1, 'carsSide': 3}
    return value

def getCurrentValue():
    value = {'carsMain': 1, 'carsSide': 1, 'go':0}
    return value


if __name__ == '__main__':
    DataSetDir = "/app/SMT_GR1_DataSet"
    dataName = 'Data10'
    dataPath = os.path.join(DataSetDir, dataName)
    expr2BoolPath = os.path.join(dataPath, "Formula2Boolean.txt")
    newBoolKindPath = os.path.join(dataPath, "NewBooleanKind.txt")
    digitalKindPath = os.path.join(dataPath, "Variable2Kind.txt")
    digitalTypePath = os.path.join(dataPath, "Variable2Type.txt")



    currentStateValue = getCurrentValue()
    print("Current state: ", currentStateValue)



    parser = Parser()

    # parser.InitAutomation()


    parser.getDigitalKind(digitalTypePath, digitalKindPath)
    # print("Env Digital Type: ", parser.envDigitalType)
    # print("Sys Digital Type: ", parser.sysDigitalType)
    parser.getnewBoolKind(newBoolKindPath)
    parser.getExpr2Bool(expr2BoolPath)

    parser.getCurrentStateValue(currentStateValue)
    parser.calculateState()
    print("Bool Current State: ", parser.stateBoolDict)
    print()



    envValue = getEnvValue()
    print("Input variable: ", envValue)

    parser.getEnvValue(envValue)

    parser.evaluate_z3_expressions()
    boolInput = parser.getBoolInput()
    print("Bool Input Value: ", boolInput)


    print()


    # parser

    parser.RunningAutomation(parser.stateBoolDict, boolInput)

    print()



    print("Bool Output Value: ", parser.outputSys)

    exprValue = parser.getOutExprValue()
    print("Output Expression Value: ", exprValue)

    parser.getOutDigitalValue()
    print("Output Digital Value:", parser.outDigitalValue)

    parser.getOutputValue()
    print("Output value: ", parser.outputValue)

