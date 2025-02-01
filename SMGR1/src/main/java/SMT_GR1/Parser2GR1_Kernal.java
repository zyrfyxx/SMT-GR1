package SMT_GR1;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Parser2GR1_Kernal extends SMT_GR1BaseListener {

    Map<String, String> variable2Type = new HashMap<>();
    Map<String, String> variable2Kind = new HashMap<>();
    Map<String, String> formula2BoolMap = new HashMap<>();
    Set<String> newDec = new HashSet<>();
    Set<String> iniExpSet = new HashSet<>();
    Map<String, String> newBooleanKind = new HashMap<>();
    Set<String> nextVariables = new HashSet<>();
    Map<String, String> next2Prime = new HashMap<>();
    Set<String> enumNames = new HashSet<>();

    TokenStreamRewriter rewriter;
    Integer SpecNameStopIndex = 0;

    public Parser2GR1_Kernal(TokenStream tokens) {
        rewriter = new TokenStreamRewriter(tokens);
    }

    @Override
    public void enterTempConstraint(SMT_GR1Parser.TempConstraintContext ctx) {
        if (ctx.getText().startsWith("ini")){
            for (String enumName: enumNames){
                if (ctx.getText().contains(enumName)){
                    return;
                }
            }
            SMT_GR1Parser.ExpContext expCtx = ctx.exp();
            if (expCtx != null && expCtx.arithmeticComparison() != null) {
                String iniExp = expCtx.arithmeticComparison().getText();
                iniExpSet.add(iniExp);
                int startIndex = ctx.getStart().getTokenIndex();  
                int stopIndex = ctx.getStop().getTokenIndex();    

                rewriter.delete(startIndex-2, stopIndex+2);
            }
        }
    }


    @Override
    public void exitSpecName(SMT_GR1Parser.SpecNameContext ctx) {
        SpecNameStopIndex = ctx.getStop().getTokenIndex();
    }

    @Override
    public void exitSpec(SMT_GR1Parser.SpecContext ctx) {
        for (String dec: newDec){
            rewriter.insertAfter(SpecNameStopIndex+1, dec+'\n');
        }

//        for (String variable: variable2Type.keySet()){
//            System.out.print(variable+' ');
//            System.out.print(variable2Type.get(variable)+' ');
//            System.out.println(variable2Kind.get(variable));
//        }
//
//        for (String formula: formula2BoolMap.keySet()){
//            System.out.print(formula+' ');
//            System.out.println(formula2BoolMap.get(formula));
//        }
    }

    @Override
    public void exitEnumDec(SMT_GR1Parser.EnumDecContext ctx) {
        String enumName = ctx.enumName.getText();
        enumNames.add(enumName);

    }


    @Override
    public void exitDecWithoutEnum(SMT_GR1Parser.DecWithoutEnumContext ctx) {
        if (ctx.TYPE() != null) {
            String varName = ctx.NAME().getText();
            String varType = ctx.TYPE().getText();
            String varKind = ctx.KIND().getText();

            if(!variable2Type.containsKey(varName)){
                variable2Type.put(varName, varType);
            }

            if(!variable2Kind.containsKey(varName)){
                variable2Kind.put(varName, varKind);
            }

            if (varType.equals("int") || varType.equals("float")){

                rewriter.delete(ctx.getStart().getTokenIndex(), ctx.getStop().getTokenIndex()+1);
            }
        }



    }

    private boolean checkParentForIni(ParserRuleContext ctx){
        while (ctx != null){
            if (ctx instanceof SMT_GR1Parser.TempConstraintContext){
                SMT_GR1Parser.TempConstraintContext tempCtx = (SMT_GR1Parser.TempConstraintContext) ctx;
                String tempCtxText = tempCtx.getText();
                if (tempCtxText.contains("ini")){
                    System.out.println("Init Constraint: "+tempCtxText);
                    return true;
                }
            }
            ctx = ctx.getParent();
        }
        return false;
    }

    @Override
    public void exitArithmeticComparison(SMT_GR1Parser.ArithmeticComparisonContext ctx) {
        if (checkParentForIni(ctx)){
            return;
        }
        String formula = ctx.getText();
        System.out.println(formula);
        for (String enumName: enumNames){
            if (formula.contains(enumName)){
                return;
            }
        }
        String boolVarName = generateBoolVarName(formula);
        if (!formula2BoolMap.containsKey(formula)) {
                formula2BoolMap.put(formula, boolVarName);

        }else {
            boolVarName = formula2BoolMap.get(formula);
        }


        boolean containsNext = false;

        Set<String> variables = new HashSet<>();
        for (SMT_GR1Parser.SubexpContext subexp : ctx.subexp()) {
            extractVariablesFromSubexp(subexp, variables);
            if (subexpContainsNext(subexp)) {
                containsNext = true;
            }
        }


        boolean allFromEnv = true;
        boolean allFromSys = true;
        for (String varName : variables) {
            if (variable2Kind.containsKey(varName)) {
                String category = variable2Kind.get(varName);
                if (category.equals("sys")){
                    allFromEnv = false;
                }else if (category.equals("env")){
                    allFromSys = false;
                }
            }
        }


            if (allFromEnv) {
                String envBoolDec = "env boolean " + boolVarName + ";";
                newDec.add(envBoolDec);
                newBooleanKind.put(boolVarName, "env");
            } else if (allFromSys) {
                String sysBoolDec = "sys boolean " + boolVarName + ";";
                newDec.add(sysBoolDec);
                newBooleanKind.put(boolVarName, "sys");
            }else {
                String sysBoolDec = "sys boolean " + boolVarName + ";";
                newDec.add(sysBoolDec);
                newBooleanKind.put(boolVarName, "sys");
            }

            if (containsNext) {
                for (SMT_GR1Parser.SubexpContext subexp : ctx.subexp()) {
                    extractVariablesFromSubexp(subexp, nextVariables);
                    String next2PrimeStr = removeNextAndAddPrime(ctx);
                    if (next2Prime.containsKey(next2PrimeStr)) {

                    }else {
                        next2Prime.put(next2PrimeStr, boolVarName);
                    }
//                    next2Prime.add(next2PrimeStr);
//                    System.out.println(next2PrimeStr);
                }
                boolVarName = "next(" + boolVarName + ')';
            }
            int startIndex = ctx.getStart().getTokenIndex();  
            int stopIndex = ctx.getStop().getTokenIndex();    


            rewriter.replace(startIndex, stopIndex, boolVarName);



    }

    private String removeNextAndAddPrime(SMT_GR1Parser.ArithmeticComparisonContext ctx) {
     
        StringBuilder modifiedExpression = new StringBuilder();

     
        SMT_GR1Parser.SubexpContext leftSubexp = ctx.subexp(0);
        SMT_GR1Parser.SubexpContext rightSubexp = ctx.subexp(1);

      
        if (leftSubexp != null) {
            modifiedExpression.append(processSubexpForNext(leftSubexp));
        }

   
        String operator = "";
        for (int i = 0; i < ctx.getChildCount(); i++) {
            String childText = ctx.getChild(i).getText();
//            System.out.println("ChildText: "+ childText);
            if (childText.equals("=") || childText.equals("<") || childText.equals(">") || childText.equals("!=")) {
                operator = childText;
//                System.out.println("Operator: "+ operator);
                break;
            }
        }

        modifiedExpression.append("").append(operator).append("");

      
        if (rightSubexp != null) {
            modifiedExpression.append(processSubexpForNext(rightSubexp));
        }

        return modifiedExpression.toString();
    }



    private String processSubexpForNext(SMT_GR1Parser.SubexpContext subexp) {
        if (subexp.NEXT() != null) {
            
            SMT_GR1Parser.SubexpContext nextSubexp = subexp.subexp(0);
            return processSubexpForNextWithPrime(nextSubexp);  
        } else if (subexp.NAME() != null) {
            
            return subexp.NAME().getText();
        } else if (subexp.INT() != null || subexp.FLOAT() != null) {
            
            return subexp.getText();
        } else {
            
            String left = subexp.subexp(0) != null ? processSubexpForNext(subexp.subexp(0)) : "";
            String right = subexp.subexp(1) != null ? processSubexpForNext(subexp.subexp(1)) : "";
            String operator = subexp.PLUS() != null ? "+" :
                    subexp.MINUS() != null ? "-" :
                            subexp.MUL() != null ? "*" :
                                    subexp.DIV() != null ? "/" : "";

            return left + "" + operator + "" + right;
        }
    }

    private String processSubexpForNextWithPrime(SMT_GR1Parser.SubexpContext subexp) {
        
        if (subexp.NAME() != null) {
            
            return subexp.NAME().getText() + "_prime";
        } else if (subexp.INT() != null || subexp.FLOAT() != null) {
            
            return subexp.getText();
        } else {
            
            String left = subexp.subexp(0) != null ? processSubexpForNextWithPrime(subexp.subexp(0)) : "";
            String right = subexp.subexp(1) != null ? processSubexpForNextWithPrime(subexp.subexp(1)) : "";
            String operator = subexp.PLUS() != null ? "+" :
                    subexp.MINUS() != null ? "-" :
                            subexp.MUL() != null ? "*" :
                                    subexp.DIV() != null ? "/" : "";

            return left + "" + operator + "" + right;
        }
    }








    private boolean subexpContainsNext(SMT_GR1Parser.SubexpContext subexp) {
        if (subexp.NEXT() != null) {
            return true;  
        } else {
            
            for (SMT_GR1Parser.SubexpContext child : subexp.subexp()) {
                if (subexpContainsNext(child)) {
                    return true;
                }
            }
        }
        return false;
    }





    private void extractVariablesFromSubexp(SMT_GR1Parser.SubexpContext subexp, Set<String> variables) {
        if (subexp.NAME() != null) {
            
            variables.add(subexp.NAME().getText());
        } else {
            
            if (subexp.subexp(0) != null) {
                extractVariablesFromSubexp(subexp.subexp(0), variables);
            }
            if (subexp.subexp(1) != null) {
                extractVariablesFromSubexp(subexp.subexp(1), variables);
            }
        }
    }



    private String generateBoolVarName(String formula) {
        
        return "boolVar_" + Math.abs(formula.hashCode());  
    }
}
