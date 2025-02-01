import Constraints
import Spec

def calculateBooleanValue():
    specList = Spec.CoreTestInit()
    # result file

    DataSetDir = "/app/SMT_GR1_DataSet"
    resultFile = "/app/SMT_GR1_DataSet/CoreCalTime.txt"
    for spec in specList:
        print("==============Test==============")
        print("==============Core==============")
        print(spec.finalSpecPath)
        constraints = Constraints.Constraints()
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
        fStrValue, coreTime = constraints.getConstraintStrValue()


        # for i in iniList:
        #     constraints.addIniConstraint(i.replace('=', '=='))

        booleanValueList = []
        for fStr2b in fStrValue:
            b2b = {}
            for f in fStr2b.keys():
                booleanName = f2bDict[f.replace('==', '=')]
                b2b[booleanName] = fStr2b[f]
            booleanValueList.append(b2b)
        print("Core in boolean: ", booleanValueList)
        with open(resultFile, 'a') as f:
            f.write(spec.finalSpecPath + "\n")
            f.write("Constraint Number = ")
            f.write(str(len(f2bDict)))
            f.write("\n")
            f.write("Core Calculate Time = ")
            f.write(str(coreTime))
            f.write("\n")
            f.write("Core Number = ")
            f.write(str(len(booleanValueList)))
            f.write("\n")
            f.write("\n")

        # exp2value = constraints.getIniBooleanState()
        # iniBooleanState = {}
        # print(exp2value)
        # for exp in exp2value:
        #     key = f2bDict[exp.replace('==', '=')]
        #     value = exp2value[exp]
        #     iniBooleanState[key] = value
        # print("Init boolean state: ", iniBooleanState)
        # print(spec.booleanKindDict)
        # spec.iniStateGen(iniBooleanState)
        # spec.coreConstraintGen(booleanValueList)
        # spec.finalSpecGen()

if __name__ == "__main__":
    i=1
    while i <= 6:          # Repeat times
        calculateBooleanValue()
        i = i + 1
# calculateBooleanValue()