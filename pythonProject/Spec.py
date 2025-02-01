import os

import z3


class Spec:
    def __init__(self):
        self.nextFormula2Boolean = None
        self.nextFormula2BooleanPath = None
        self.nextVarsPath = None
        self.alwCoreList = None
        self.iniCoreList = None
        self.iniStateList = None
        self.iniBooleanState = None
        self.booleanKindDict = None
        self.iniConstraintList = None
        self.iniConstraintPath = None
        self.formula2Boolean = None
        self.formula2BooleanPath = None
        self.variable2TypeDict = None
        self.variable2TypePath = None
        self.variable2KindDict = None
        self.variable2KindPath = None
        self.abstractSpec = None
        self.abstractSpecPath = None

    def setFinalSpecPath(self, finalSpecPath):
        self.finalSpecPath = finalSpecPath

    def finalSpecGen(self):
        insertIndex = -1
        for i in self.abstractSpec:
            if ('asm ' in i) or ('gar 'in i):
                insertIndex = self.abstractSpec.index(i)
                break

        self.abstractSpec.insert(insertIndex, '\n// Init expressions Generated by ......\n')
        insertIndex += 1

        for i in self.iniStateList:
            print("Add to spec: ", i.strip())
            self.abstractSpec.insert(insertIndex, i)
            insertIndex += 1

        self.abstractSpec.insert(insertIndex, '\n')
        insertIndex += 1

        self.abstractSpec.insert(insertIndex, '\n// Cores Generated by ......\n')
        insertIndex += 1
        for i in self.iniCoreList:
            # print("Add to spec: ", i.strip())
            self.abstractSpec.insert(insertIndex, i)
            insertIndex += 1



        for i in self.alwCoreList:
            # print("Add to spec: ", i.strip())
            self.abstractSpec.insert(insertIndex, i)
            insertIndex += 1


        self.abstractSpec.insert(insertIndex, '\n')
        insertIndex += 1

        with open(self.finalSpecPath, 'w') as f:
            for i in self.abstractSpec:
                f.write(i)


    def coreConstraintGen(self, coreInBoolean):
        iniStrList = []
        alwStrList = []
        for core in coreInBoolean:
            allFromEnv = True
            for booleanName in core.keys():
                if self.booleanKindDict[booleanName] == 'sys':
                    allFromEnv = False
            if allFromEnv:
                iniStr = 'asm ini !( '
                alwStr = 'asm alw !( '
            else:
                iniStr = 'gar ini !( '
                alwStr = 'gar alw !( '
            for booleanName in core.keys():
                if core[booleanName] == True:
                    iniStr += booleanName + ' & '
                    alwStr += booleanName + ' & '
                else:
                    iniStr += '!' + booleanName + ' & '
                    alwStr += '!' + booleanName + ' & '
            iniStr = iniStr[:len(iniStr) - 2]
            alwStr = alwStr[:len(alwStr) - 2]
            iniStr += ');\n'
            alwStr += ');\n'
            iniStrList.append(iniStr)
            alwStrList.append(alwStr)
        self.iniCoreList = iniStrList
        self.alwCoreList = alwStrList
        # print("Initial constraint: ", iniStrList)
        # print("Always initial constraint", alwStrList)



    def iniStateGen(self, bool2State):
        iniStateList = []
        # print(self.booleanKindDict)
        for i in bool2State.keys():
            if bool2State[i] == True:
                if self.booleanKindDict[i] == 'env':
                    iniStr = 'asm ini ' + i + ' = true;\n'
                    iniStateList.append(iniStr)
                else:
                    iniStr = 'gar ini ' + i + ' = true;\n'
                    iniStateList.append(iniStr)
            elif bool2State[i] == False:
                if self.booleanKindDict[i] == 'env':
                    iniStr = 'asm ini ' + i + ' = false;\n'
                    iniStateList.append(iniStr)
                else:
                    iniStr = 'gar ini ' + i + ' = false;\n'
                    iniStateList.append(iniStr)
            else:
                pass
        self.iniStateList = iniStateList
        # print(self.iniStateList)


    def setNewBooleanKind(self, newBooleanKindPath):
        self.newBooleanKindPath = newBooleanKindPath
        booleanKind = {}
        with open(newBooleanKindPath, 'r') as f:
            bool2kindLines = f.readlines()
            for line in bool2kindLines:
                booleanName = line.split(':')[0]
                kind = line.split(':')[1].strip()
                booleanKind[booleanName] = kind
            self.booleanKindDict = booleanKind

    def setIniConstraint(self, iniConstraintPath):
        self.iniConstraintPath = iniConstraintPath
        iniConstraintList = []
        with open(self.iniConstraintPath, 'r') as f:
            iniLines = f.readlines()
        for line in iniLines:
            iniConstraintList.append(line.strip())
        self.iniConstraintList = iniConstraintList

    def setAbstractSpec(self, abstractSpecPath):
        self.abstractSpecPath = abstractSpecPath
        with open(self.abstractSpecPath, 'r') as f:
            self.abstractSpec = f.readlines()
        # print("Abstract Spec: ", self.abstractSpec)
    def setVariable2Kind(self, variable2KindPath):
        self.variable2KindPath = variable2KindPath
        variable2KindDict = {}
        with open(self.variable2KindPath, 'r') as f:
            variable2KindLines = f.readlines()
            for variable2Kind in variable2KindLines:
                variable = variable2Kind.split(':')[0]
                kind = variable2Kind.split(':')[1].strip()
                variable2KindDict[variable] = kind
            self.variable2KindDict = variable2KindDict
        # print("Variable & Kind: ", self.variable2KindDict)

    def setVariable2Type(self, variable2TypePath):
        self.variable2TypePath = variable2TypePath
        variable2TypeDict = {}
        with open(self.variable2TypePath, 'r') as f:
            variable2TypeLines = f.readlines()
            for variable2TypeLine in variable2TypeLines:
                variable = variable2TypeLine.split(':')[0]
                kind = variable2TypeLine.split(':')[1].strip()
                variable2TypeDict[variable] = kind
            self.variable2TypeDict = variable2TypeDict
        # print("Variable & Type: ", self.variable2TypeDict)


    def setNextVars(self, nextVarsPath):
        self.nextVarsPath = nextVarsPath
        with open(nextVarsPath, 'r') as f:
            nextVarsLines = f.readlines()
            for nextVarsLine in nextVarsLines:
                variable = nextVarsLine.strip()
                varType = self.variable2TypeDict[variable]
                varName = variable+"_prime"
                self.variable2TypeDict[varName] = varType
        # print("Variable & Type: ", self.variable2TypeDict)

    def setFormula2Boolean(self, formula2BooleanPath):
        self.formula2BooleanPath = formula2BooleanPath
        formula2Boolean = {}
        with open(self.formula2BooleanPath, 'r') as f:
            formula2BooleanLines = f.readlines()
            for formula2BooleanLine in formula2BooleanLines:
                formula = formula2BooleanLine.split(':')[0]
                boolName = formula2BooleanLine.split(':')[1].strip()
                formula2Boolean[formula] = boolName
            self.formula2Boolean = formula2Boolean
        # print("Formula & Boolean: ", self.formula2Boolean)
        
    def setNextFormula2Boolean(self, nextFormula2BooleanPath):
        self.nextFormula2BooleanPath = nextFormula2BooleanPath
        nextFormula2Boolean = {}
        with open(self.nextFormula2BooleanPath, 'r') as f:
            nextFormula2BooleanLines = f.readlines()
            for nextFormula2BooleanLine in nextFormula2BooleanLines:
                formula = nextFormula2BooleanLine.split(':')[0]
                boolName = nextFormula2BooleanLine.split(':')[1].strip()
                nextFormula2Boolean[formula] = boolName
            self.nextFormula2Boolean = nextFormula2Boolean
        # print(self.nextFormula2Boolean)

    





def SpecInit():
    specList = []
    DataSetDir = "/app/SMT_GR1_DataSet"
    dataNameList = os.listdir(DataSetDir)
    for dataName in dataNameList:
        if dataName.startswith("Data"):
            dataPath = os.path.join(DataSetDir, dataName)
            # print(dataPath)
            abstractSpecPath = os.path.join(dataPath, "AbstractSpec.txt")
            # variable2KindPath = os.path.join(dataPath, "Variable2Kind.txt")
            variable2TypePath = os.path.join(dataPath, "Variable2Type.txt")
            formula2BooleanPath = os.path.join(dataPath, "Formula2Boolean.txt")
            iniConstraintPath = os.path.join(dataPath, "IniExpr.txt")
            newBooleanNamePath = os.path.join(dataPath, "NewBooleanKind.txt")
            finalSpecPath = os.path.join(dataPath, "FinalSpec.txt")
            nextVarPath = os.path.join(dataPath, "NextVariable.txt")
            next2Prime = os.path.join(dataPath, "Next2Prime.txt")

            spec = Spec()
            spec.setAbstractSpec(abstractSpecPath)
            # spec.setVariable2Kind(variable2KindPath)
            spec.setVariable2Type(variable2TypePath)
            spec.setFormula2Boolean(formula2BooleanPath)
            spec.setIniConstraint(iniConstraintPath)
            spec.setNewBooleanKind(newBooleanNamePath)
            spec.setFinalSpecPath(finalSpecPath)
            spec.setNextVars(nextVarPath)
            spec.setNextFormula2Boolean(next2Prime)


            specList.append(spec)
        # break

    return specList

# C:\Users\kokaze\Desktop\smt-0B39\SMT_GR1_DataSet\Date_Core_10
def CoreTestInit():
    specList = []
    # Run on which data set
    DataSetDir = "/app/SMT_GR1_DataSet/Date_Core_"

    # dataNameList = os.listdir(DataSetDir)
    # for dataName in dataNameList:
    i = 1
    while i <=58: #Data_core_: 1-59
        dataName = DataSetDir + str(i)
        dataPath = os.path.join(DataSetDir, dataName)
        # print(dataPath)
        abstractSpecPath = os.path.join(dataPath, "AbstractSpec.txt")
        # variable2KindPath = os.path.join(dataPath, "Variable2Kind.txt")
        variable2TypePath = os.path.join(dataPath, "Variable2Type.txt")
        formula2BooleanPath = os.path.join(dataPath, "Formula2Boolean.txt")
        iniConstraintPath = os.path.join(dataPath, "IniExpr.txt")
        newBooleanNamePath = os.path.join(dataPath, "NewBooleanKind.txt")
        finalSpecPath = os.path.join(dataPath, "FinalSpec.txt")
        nextVarPath = os.path.join(dataPath, "NextVariable.txt")
        next2Prime = os.path.join(dataPath, "Next2Prime.txt")

        spec = Spec()
        spec.setAbstractSpec(abstractSpecPath)
        # spec.setVariable2Kind(variable2KindPath)
        spec.setVariable2Type(variable2TypePath)
        spec.setFormula2Boolean(formula2BooleanPath)
        spec.setIniConstraint(iniConstraintPath)
        spec.setNewBooleanKind(newBooleanNamePath)
        spec.setFinalSpecPath(finalSpecPath)
        spec.setNextVars(nextVarPath)
        spec.setNextFormula2Boolean(next2Prime)


        specList.append(spec)
        i+=1
        # break

    return specList