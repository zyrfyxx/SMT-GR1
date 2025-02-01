// Generated from C:/Users/kokaze/IdeaProjects/SMGR1/src/main/resources/SMT_GR1.g4 by ANTLR 4.13.1
package SMT_GR1;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SMT_GR1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SMT_GR1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpec(SMT_GR1Parser.SpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#importState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportState(SMT_GR1Parser.ImportStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#specName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecName(SMT_GR1Parser.SpecNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#specElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecElem(SMT_GR1Parser.SpecElemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decWithoutEnum}
	 * labeled alternative in {@link SMT_GR1Parser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecWithoutEnum(SMT_GR1Parser.DecWithoutEnumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enumDec}
	 * labeled alternative in {@link SMT_GR1Parser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDec(SMT_GR1Parser.EnumDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asmTempConstraint}
	 * labeled alternative in {@link SMT_GR1Parser#assumption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsmTempConstraint(SMT_GR1Parser.AsmTempConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asmPattern}
	 * labeled alternative in {@link SMT_GR1Parser#assumption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsmPattern(SMT_GR1Parser.AsmPatternContext ctx);
	/**
	 * Visit a parse tree produced by the {@code garTempConstraint}
	 * labeled alternative in {@link SMT_GR1Parser#guarantee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGarTempConstraint(SMT_GR1Parser.GarTempConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gatPattern}
	 * labeled alternative in {@link SMT_GR1Parser#guarantee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGatPattern(SMT_GR1Parser.GatPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(SMT_GR1Parser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#tempConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTempConstraint(SMT_GR1Parser.TempConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(SMT_GR1Parser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(SMT_GR1Parser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#binaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(SMT_GR1Parser.BinaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#primExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimExp(SMT_GR1Parser.PrimExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#arithmeticComparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticComparison(SMT_GR1Parser.ArithmeticComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#subexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubexp(SMT_GR1Parser.SubexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(SMT_GR1Parser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMT_GR1Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SMT_GR1Parser.ValueContext ctx);
}