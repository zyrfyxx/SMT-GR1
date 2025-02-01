package SMT_GR1;
import SMT_GR1.Parser2GR1_Kernal;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParserMain {
    public static void main(String[] args) throws Exception {

        String DataSetDir = "/app/SMT_GR1_DataSet/";
        Set<String> dataNameSet = new HashSet<String>();
        File file = new File(DataSetDir);
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory()) {
                dataNameSet.add(f.getName());
            }
        }
        for (String dataName : dataNameSet) {
            String dataPath = DataSetDir + dataName + "/";
            System.out.println(dataPath);
            String inputSpecPath = dataPath + "InputSpec.txt";
            String abstractSpecPath = dataPath + "AbstractSpec.txt";
            String variable2KindPath = dataPath + "Variable2Kind.txt";
            String variable2TypePath = dataPath + "Variable2Type.txt";
            String formula2BooleanPath = dataPath + "Formula2Boolean.txt";
            String iniExprPath = dataPath + "IniExpr.txt";
            String newBooleanKindPath = dataPath + "NewBooleanKind.txt";
            String nextVariablePath = dataPath + "NextVariable.txt";
            String next2PrimePath = dataPath + "Next2Prime.txt";
//            System.out.println(inputSpecPath);

            InputStream is = new FileInputStream(inputSpecPath);
            ANTLRInputStream input = new ANTLRInputStream(is);
            SMT_GR1Lexer lexer = new SMT_GR1Lexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SMT_GR1Parser parser = new SMT_GR1Parser(tokens);
            ParseTree tree = parser.spec();
            ParseTreeWalker walker = new ParseTreeWalker();
            Parser2GR1_Kernal parser2 = new Parser2GR1_Kernal(tokens);
            walker.walk(parser2, tree);

//            System.out.println(parser2.rewriter.getText());

            String rewriterText = parser2.rewriter.getText();
            writeToFile(abstractSpecPath, rewriterText);

            Map<String, String> variable2Kind = parser2.variable2Kind;
            Map<String, String> variable2Type = parser2.variable2Type;
            Map<String, String> formula2Bool = parser2.formula2BoolMap;
            Set<String> iniExpSet = parser2.iniExpSet;
            Map<String, String> newBooleanKind = parser2.newBooleanKind;
            Set<String> nextVariables = parser2.nextVariables;
            Map<String, String> next2Prime = parser2.next2Prime;

//            System.out.println(nextVariables);

//            System.out.println(formula2Bool);

            String variable2KindString = "";
            String variable2TypeString = "";
            String formula2BoolString = "";
            String iniExprString = "";
            String newBooleanKindString = "";
            String nextVariableString = "";
            String next2PrimeString = "";

            for (String variable: variable2Kind.keySet()) {
                String kind = variable2Kind.get(variable);
                variable2KindString += variable + ":" + kind + "\n";
            }
            writeToFile(variable2KindPath, variable2KindString);
            for (String variable: variable2Type.keySet()) {
                String type = variable2Type.get(variable);
                variable2TypeString += variable + ":" + type + "\n";
            }


            writeToFile(variable2TypePath, variable2TypeString);
            for (String formula: formula2Bool.keySet()) {
                if ( iniExpSet.contains(formula)){}
                else {
                    String bool = formula2Bool.get(formula);
                    formula2BoolString += formula + ":" + bool + "\n";
                }
            }
            writeToFile(formula2BooleanPath, formula2BoolString);

            for (String iniExp: iniExpSet){
                iniExprString += iniExp + "\n";
            }
            writeToFile(iniExprPath, iniExprString);

            for (String newBoolean: newBooleanKind.keySet()){
                String newKind = newBooleanKind.get(newBoolean);
                newBooleanKindString += newBoolean + ":" + newKind + "\n";
            }
            writeToFile(newBooleanKindPath, newBooleanKindString);

            for (String nextVariable: nextVariables){
//                System.out.println(nextVariable);
                nextVariableString += nextVariable + "\n";
            }
//            System.out.println(nextVariableString);
            writeToFile(nextVariablePath, nextVariableString);

            for (String nextPrime: next2Prime.keySet()){
                next2PrimeString += nextPrime + ":" + next2Prime.get(nextPrime) + "\n";
            }
//            System.out.println(next2PrimeString);
            writeToFile(next2PrimePath, next2PrimeString);
//            break;

        }
    }

    private static void writeToFile(String filePath, String content) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }


}
