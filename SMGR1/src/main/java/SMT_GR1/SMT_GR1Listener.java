// Generated from C:/Users/kokaze/IdeaProjects/SMGR1/src/main/resources/SMT_GR1.g4 by ANTLR 4.13.1
package SMT_GR1;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SMT_GR1Parser}.
 */
public interface SMT_GR1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#spec}.
	 * @param ctx the parse tree
	 */
	void enterSpec(SMT_GR1Parser.SpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#spec}.
	 * @param ctx the parse tree
	 */
	void exitSpec(SMT_GR1Parser.SpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#importState}.
	 * @param ctx the parse tree
	 */
	void enterImportState(SMT_GR1Parser.ImportStateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#importState}.
	 * @param ctx the parse tree
	 */
	void exitImportState(SMT_GR1Parser.ImportStateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#specName}.
	 * @param ctx the parse tree
	 */
	void enterSpecName(SMT_GR1Parser.SpecNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#specName}.
	 * @param ctx the parse tree
	 */
	void exitSpecName(SMT_GR1Parser.SpecNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#specElem}.
	 * @param ctx the parse tree
	 */
	void enterSpecElem(SMT_GR1Parser.SpecElemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#specElem}.
	 * @param ctx the parse tree
	 */
	void exitSpecElem(SMT_GR1Parser.SpecElemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decWithoutEnum}
	 * labeled alternative in {@link SMT_GR1Parser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterDecWithoutEnum(SMT_GR1Parser.DecWithoutEnumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decWithoutEnum}
	 * labeled alternative in {@link SMT_GR1Parser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitDecWithoutEnum(SMT_GR1Parser.DecWithoutEnumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code enumDec}
	 * labeled alternative in {@link SMT_GR1Parser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterEnumDec(SMT_GR1Parser.EnumDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enumDec}
	 * labeled alternative in {@link SMT_GR1Parser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitEnumDec(SMT_GR1Parser.EnumDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asmTempConstraint}
	 * labeled alternative in {@link SMT_GR1Parser#assumption}.
	 * @param ctx the parse tree
	 */
	void enterAsmTempConstraint(SMT_GR1Parser.AsmTempConstraintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asmTempConstraint}
	 * labeled alternative in {@link SMT_GR1Parser#assumption}.
	 * @param ctx the parse tree
	 */
	void exitAsmTempConstraint(SMT_GR1Parser.AsmTempConstraintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asmPattern}
	 * labeled alternative in {@link SMT_GR1Parser#assumption}.
	 * @param ctx the parse tree
	 */
	void enterAsmPattern(SMT_GR1Parser.AsmPatternContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asmPattern}
	 * labeled alternative in {@link SMT_GR1Parser#assumption}.
	 * @param ctx the parse tree
	 */
	void exitAsmPattern(SMT_GR1Parser.AsmPatternContext ctx);
	/**
	 * Enter a parse tree produced by the {@code garTempConstraint}
	 * labeled alternative in {@link SMT_GR1Parser#guarantee}.
	 * @param ctx the parse tree
	 */
	void enterGarTempConstraint(SMT_GR1Parser.GarTempConstraintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code garTempConstraint}
	 * labeled alternative in {@link SMT_GR1Parser#guarantee}.
	 * @param ctx the parse tree
	 */
	void exitGarTempConstraint(SMT_GR1Parser.GarTempConstraintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gatPattern}
	 * labeled alternative in {@link SMT_GR1Parser#guarantee}.
	 * @param ctx the parse tree
	 */
	void enterGatPattern(SMT_GR1Parser.GatPatternContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gatPattern}
	 * labeled alternative in {@link SMT_GR1Parser#guarantee}.
	 * @param ctx the parse tree
	 */
	void exitGatPattern(SMT_GR1Parser.GatPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(SMT_GR1Parser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(SMT_GR1Parser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#tempConstraint}.
	 * @param ctx the parse tree
	 */
	void enterTempConstraint(SMT_GR1Parser.TempConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#tempConstraint}.
	 * @param ctx the parse tree
	 */
	void exitTempConstraint(SMT_GR1Parser.TempConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(SMT_GR1Parser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(SMT_GR1Parser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(SMT_GR1Parser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(SMT_GR1Parser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(SMT_GR1Parser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(SMT_GR1Parser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#primExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimExp(SMT_GR1Parser.PrimExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#primExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimExp(SMT_GR1Parser.PrimExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#arithmeticComparison}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticComparison(SMT_GR1Parser.ArithmeticComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#arithmeticComparison}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticComparison(SMT_GR1Parser.ArithmeticComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#subexp}.
	 * @param ctx the parse tree
	 */
	void enterSubexp(SMT_GR1Parser.SubexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#subexp}.
	 * @param ctx the parse tree
	 */
	void exitSubexp(SMT_GR1Parser.SubexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(SMT_GR1Parser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(SMT_GR1Parser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMT_GR1Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SMT_GR1Parser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMT_GR1Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SMT_GR1Parser.ValueContext ctx);
}