// Generated from C:/Users/kokaze/IdeaProjects/SMGR1/src/main/resources/SMT_GR1.g4 by ANTLR 4.13.1
package SMT_GR1;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SMT_GR1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, TYPE=14, KIND=15, INT=16, FLOAT=17, 
		PLUS=18, MINUS=19, MUL=20, DIV=21, SQUARE=22, LT=23, GT=24, LTE=25, GTE=26, 
		EQ=27, NEQ=28, AND=29, OR=30, IMPL=31, EQUIV=32, NOT=33, NEXT=34, TRUE=35, 
		FALSE=36, LPAREN=37, RPAREN=38, NAME=39, ID=40, WS=41;
	public static final int
		RULE_spec = 0, RULE_importState = 1, RULE_specName = 2, RULE_specElem = 3, 
		RULE_varDec = 4, RULE_assumption = 5, RULE_guarantee = 6, RULE_pattern = 7, 
		RULE_tempConstraint = 8, RULE_exp = 9, RULE_unaryOp = 10, RULE_binaryOp = 11, 
		RULE_primExp = 12, RULE_arithmeticComparison = 13, RULE_subexp = 14, RULE_predicate = 15, 
		RULE_value = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"spec", "importState", "specName", "specElem", "varDec", "assumption", 
			"guarantee", "pattern", "tempConstraint", "exp", "unaryOp", "binaryOp", 
			"primExp", "arithmeticComparison", "subexp", "predicate", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "'\"'", "'.'", "'spec'", "';'", "'{'", "','", "'}'", 
			"'asm'", "'gar'", "'ini'", "'alw'", "'alwEv'", null, null, null, null, 
			"'+'", "'-'", "'*'", "'/'", "'**'", "'<'", "'>'", "'<='", "'>='", "'='", 
			"'!='", "'&'", "'|'", "'->'", "'<->'", "'!'", "'next'", "'true'", "'false'", 
			"'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "TYPE", "KIND", "INT", "FLOAT", "PLUS", "MINUS", "MUL", "DIV", 
			"SQUARE", "LT", "GT", "LTE", "GTE", "EQ", "NEQ", "AND", "OR", "IMPL", 
			"EQUIV", "NOT", "NEXT", "TRUE", "FALSE", "LPAREN", "RPAREN", "NAME", 
			"ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SMT_GR1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SMT_GR1Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecContext extends ParserRuleContext {
		public SpecNameContext specName() {
			return getRuleContext(SpecNameContext.class,0);
		}
		public List<ImportStateContext> importState() {
			return getRuleContexts(ImportStateContext.class);
		}
		public ImportStateContext importState(int i) {
			return getRuleContext(ImportStateContext.class,i);
		}
		public List<SpecElemContext> specElem() {
			return getRuleContexts(SpecElemContext.class);
		}
		public SpecElemContext specElem(int i) {
			return getRuleContext(SpecElemContext.class,i);
		}
		public SpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecContext spec() throws RecognitionException {
		SpecContext _localctx = new SpecContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(34);
				importState();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			specName();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34304L) != 0)) {
				{
				{
				setState(41);
				specElem();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStateContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(SMT_GR1Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(SMT_GR1Parser.NAME, i);
		}
		public ImportStateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importState; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterImportState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitImportState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitImportState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStateContext importState() throws RecognitionException {
		ImportStateContext _localctx = new ImportStateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importState);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(T__0);
			setState(48);
			match(T__1);
			setState(49);
			match(NAME);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(50);
				match(T__2);
				setState(51);
				match(NAME);
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SMT_GR1Parser.NAME, 0); }
		public SpecNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterSpecName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitSpecName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitSpecName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecNameContext specName() throws RecognitionException {
		SpecNameContext _localctx = new SpecNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_specName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__3);
			setState(60);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecElemContext extends ParserRuleContext {
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public AssumptionContext assumption() {
			return getRuleContext(AssumptionContext.class,0);
		}
		public GuaranteeContext guarantee() {
			return getRuleContext(GuaranteeContext.class,0);
		}
		public SpecElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specElem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterSpecElem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitSpecElem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitSpecElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecElemContext specElem() throws RecognitionException {
		SpecElemContext _localctx = new SpecElemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_specElem);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KIND:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				varDec();
				setState(63);
				match(T__4);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				assumption();
				setState(66);
				match(T__4);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				guarantee();
				setState(69);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDecContext extends ParserRuleContext {
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
	 
		public VarDecContext() { }
		public void copyFrom(VarDecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EnumDecContext extends VarDecContext {
		public Token enumName;
		public TerminalNode KIND() { return getToken(SMT_GR1Parser.KIND, 0); }
		public List<TerminalNode> NAME() { return getTokens(SMT_GR1Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(SMT_GR1Parser.NAME, i);
		}
		public EnumDecContext(VarDecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterEnumDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitEnumDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitEnumDec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecWithoutEnumContext extends VarDecContext {
		public TerminalNode KIND() { return getToken(SMT_GR1Parser.KIND, 0); }
		public TerminalNode TYPE() { return getToken(SMT_GR1Parser.TYPE, 0); }
		public TerminalNode NAME() { return getToken(SMT_GR1Parser.NAME, 0); }
		public DecWithoutEnumContext(VarDecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterDecWithoutEnum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitDecWithoutEnum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitDecWithoutEnum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDec);
		try {
			int _alt;
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new DecWithoutEnumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(KIND);
				setState(74);
				match(TYPE);
				setState(75);
				match(NAME);
				}
				break;
			case 2:
				_localctx = new EnumDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(KIND);
				setState(77);
				match(T__5);
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(78);
						match(NAME);
						setState(79);
						match(T__6);
						}
						} 
					}
					setState(84);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(85);
				match(NAME);
				setState(86);
				match(T__7);
				setState(87);
				((EnumDecContext)_localctx).enumName = match(NAME);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssumptionContext extends ParserRuleContext {
		public AssumptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assumption; }
	 
		public AssumptionContext() { }
		public void copyFrom(AssumptionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsmPatternContext extends AssumptionContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public AsmPatternContext(AssumptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterAsmPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitAsmPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitAsmPattern(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsmTempConstraintContext extends AssumptionContext {
		public TempConstraintContext tempConstraint() {
			return getRuleContext(TempConstraintContext.class,0);
		}
		public AsmTempConstraintContext(AssumptionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterAsmTempConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitAsmTempConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitAsmTempConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssumptionContext assumption() throws RecognitionException {
		AssumptionContext _localctx = new AssumptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assumption);
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new AsmTempConstraintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(T__8);
				setState(91);
				tempConstraint();
				}
				break;
			case 2:
				_localctx = new AsmPatternContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(T__8);
				setState(93);
				pattern();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GuaranteeContext extends ParserRuleContext {
		public GuaranteeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guarantee; }
	 
		public GuaranteeContext() { }
		public void copyFrom(GuaranteeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GatPatternContext extends GuaranteeContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public GatPatternContext(GuaranteeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterGatPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitGatPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitGatPattern(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GarTempConstraintContext extends GuaranteeContext {
		public TempConstraintContext tempConstraint() {
			return getRuleContext(TempConstraintContext.class,0);
		}
		public GarTempConstraintContext(GuaranteeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterGarTempConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitGarTempConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitGarTempConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuaranteeContext guarantee() throws RecognitionException {
		GuaranteeContext _localctx = new GuaranteeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_guarantee);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new GarTempConstraintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(T__9);
				setState(97);
				tempConstraint();
				}
				break;
			case 2:
				_localctx = new GatPatternContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(T__9);
				setState(99);
				pattern();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(SMT_GR1Parser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(SMT_GR1Parser.NAME, i);
		}
		public TerminalNode LPAREN() { return getToken(SMT_GR1Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SMT_GR1Parser.RPAREN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pattern);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(NAME);
			setState(103);
			match(LPAREN);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(106);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						setState(104);
						match(NAME);
						}
						break;
					case 2:
						{
						setState(105);
						exp(0);
						}
						break;
					}
					setState(108);
					match(T__6);
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(114);
				match(NAME);
				}
				break;
			case 2:
				{
				setState(115);
				exp(0);
				}
				break;
			}
			setState(118);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TempConstraintContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TempConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tempConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterTempConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitTempConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitTempConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TempConstraintContext tempConstraint() throws RecognitionException {
		TempConstraintContext _localctx = new TempConstraintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tempConstraint);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(T__10);
				setState(121);
				exp(0);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(T__11);
				setState(123);
				exp(0);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				match(T__12);
				setState(125);
				exp(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ArithmeticComparisonContext arithmeticComparison() {
			return getRuleContext(ArithmeticComparisonContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SMT_GR1Parser.LPAREN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(SMT_GR1Parser.RPAREN, 0); }
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public PrimExpContext primExp() {
			return getRuleContext(PrimExpContext.class,0);
		}
		public BinaryOpContext binaryOp() {
			return getRuleContext(BinaryOpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(129);
				arithmeticComparison();
				}
				break;
			case 2:
				{
				setState(130);
				match(LPAREN);
				setState(131);
				exp(0);
				setState(132);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(134);
				unaryOp();
				setState(135);
				exp(3);
				}
				break;
			case 4:
				{
				setState(137);
				primExp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(140);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(141);
					binaryOp();
					setState(142);
					exp(3);
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOpContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SMT_GR1Parser.NOT, 0); }
		public TerminalNode NEXT() { return getToken(SMT_GR1Parser.NEXT, 0); }
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitUnaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !(_la==NOT || _la==NEXT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOpContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SMT_GR1Parser.EQ, 0); }
		public TerminalNode AND() { return getToken(SMT_GR1Parser.AND, 0); }
		public TerminalNode OR() { return getToken(SMT_GR1Parser.OR, 0); }
		public TerminalNode IMPL() { return getToken(SMT_GR1Parser.IMPL, 0); }
		public TerminalNode EQUIV() { return getToken(SMT_GR1Parser.EQUIV, 0); }
		public BinaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitBinaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitBinaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOpContext binaryOp() throws RecognitionException {
		BinaryOpContext _localctx = new BinaryOpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_binaryOp);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case NOT:
			case NEXT:
			case TRUE:
			case FALSE:
			case LPAREN:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(EQ);
				}
				break;
			case AND:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				match(AND);
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				match(OR);
				}
				break;
			case IMPL:
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
				match(IMPL);
				}
				break;
			case EQUIV:
				enterOuterAlt(_localctx, 6);
				{
				setState(156);
				match(EQUIV);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimExpContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SMT_GR1Parser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SMT_GR1Parser.FALSE, 0); }
		public TerminalNode NAME() { return getToken(SMT_GR1Parser.NAME, 0); }
		public PrimExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterPrimExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitPrimExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitPrimExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimExpContext primExp() throws RecognitionException {
		PrimExpContext _localctx = new PrimExpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_primExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 652835028992L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticComparisonContext extends ParserRuleContext {
		public List<SubexpContext> subexp() {
			return getRuleContexts(SubexpContext.class);
		}
		public SubexpContext subexp(int i) {
			return getRuleContext(SubexpContext.class,i);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public ArithmeticComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticComparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterArithmeticComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitArithmeticComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitArithmeticComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticComparisonContext arithmeticComparison() throws RecognitionException {
		ArithmeticComparisonContext _localctx = new ArithmeticComparisonContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arithmeticComparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			subexp(0);
			setState(162);
			predicate();
			setState(163);
			subexp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubexpContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SMT_GR1Parser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(SMT_GR1Parser.FLOAT, 0); }
		public TerminalNode NAME() { return getToken(SMT_GR1Parser.NAME, 0); }
		public TerminalNode NEXT() { return getToken(SMT_GR1Parser.NEXT, 0); }
		public List<SubexpContext> subexp() {
			return getRuleContexts(SubexpContext.class);
		}
		public SubexpContext subexp(int i) {
			return getRuleContext(SubexpContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(SMT_GR1Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SMT_GR1Parser.RPAREN, 0); }
		public TerminalNode MUL() { return getToken(SMT_GR1Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(SMT_GR1Parser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(SMT_GR1Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SMT_GR1Parser.MINUS, 0); }
		public TerminalNode SQUARE() { return getToken(SMT_GR1Parser.SQUARE, 0); }
		public SubexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterSubexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitSubexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitSubexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubexpContext subexp() throws RecognitionException {
		return subexp(0);
	}

	private SubexpContext subexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SubexpContext _localctx = new SubexpContext(_ctx, _parentState);
		SubexpContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_subexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(166);
				match(INT);
				}
				break;
			case FLOAT:
				{
				setState(167);
				match(FLOAT);
				}
				break;
			case NAME:
				{
				setState(168);
				match(NAME);
				}
				break;
			case NEXT:
				{
				setState(169);
				match(NEXT);
				setState(170);
				subexp(7);
				}
				break;
			case LPAREN:
				{
				setState(171);
				match(LPAREN);
				setState(172);
				subexp(0);
				setState(173);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(192);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new SubexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_subexp);
						setState(177);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(178);
						match(MUL);
						setState(179);
						subexp(6);
						}
						break;
					case 2:
						{
						_localctx = new SubexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_subexp);
						setState(180);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(181);
						match(DIV);
						setState(182);
						subexp(5);
						}
						break;
					case 3:
						{
						_localctx = new SubexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_subexp);
						setState(183);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(184);
						match(PLUS);
						setState(185);
						subexp(4);
						}
						break;
					case 4:
						{
						_localctx = new SubexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_subexp);
						setState(186);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(187);
						match(MINUS);
						setState(188);
						subexp(3);
						}
						break;
					case 5:
						{
						_localctx = new SubexpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_subexp);
						setState(189);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(190);
						match(SQUARE);
						setState(191);
						subexp(2);
						}
						break;
					}
					} 
				}
				setState(196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(SMT_GR1Parser.LT, 0); }
		public TerminalNode GT() { return getToken(SMT_GR1Parser.GT, 0); }
		public TerminalNode EQ() { return getToken(SMT_GR1Parser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(SMT_GR1Parser.NEQ, 0); }
		public TerminalNode LTE() { return getToken(SMT_GR1Parser.LTE, 0); }
		public TerminalNode GTE() { return getToken(SMT_GR1Parser.GTE, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 528482304L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SMT_GR1Parser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(SMT_GR1Parser.FLOAT, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMT_GR1Listener ) ((SMT_GR1Listener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMT_GR1Visitor ) return ((SMT_GR1Visitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 14:
			return subexp_sempred((SubexpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean subexp_sempred(SubexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u00ca\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0000\u0001\u0000\u0005\u0000+\b\u0000\n\u0000\f\u0000"+
		".\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00015\b\u0001\n\u0001\f\u00018\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003H\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004Q\b\u0004\n\u0004\f\u0004"+
		"T\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004Y\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005_\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006e\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007k\b\u0007\u0001"+
		"\u0007\u0005\u0007n\b\u0007\n\u0007\f\u0007q\t\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007u\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u007f\b\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u008b\b\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0005\t\u0091\b\t\n\t\f\t\u0094\t\t\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u009e\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00b0\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00c1\b\u000e"+
		"\n\u000e\f\u000e\u00c4\t\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0000\u0002\u0012\u001c\u0011\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0004"+
		"\u0001\u0000!\"\u0002\u0000#$\'\'\u0001\u0000\u0017\u001c\u0001\u0000"+
		"\u0010\u0011\u00d8\u0000%\u0001\u0000\u0000\u0000\u0002/\u0001\u0000\u0000"+
		"\u0000\u0004;\u0001\u0000\u0000\u0000\u0006G\u0001\u0000\u0000\u0000\b"+
		"X\u0001\u0000\u0000\u0000\n^\u0001\u0000\u0000\u0000\fd\u0001\u0000\u0000"+
		"\u0000\u000ef\u0001\u0000\u0000\u0000\u0010~\u0001\u0000\u0000\u0000\u0012"+
		"\u008a\u0001\u0000\u0000\u0000\u0014\u0095\u0001\u0000\u0000\u0000\u0016"+
		"\u009d\u0001\u0000\u0000\u0000\u0018\u009f\u0001\u0000\u0000\u0000\u001a"+
		"\u00a1\u0001\u0000\u0000\u0000\u001c\u00af\u0001\u0000\u0000\u0000\u001e"+
		"\u00c5\u0001\u0000\u0000\u0000 \u00c7\u0001\u0000\u0000\u0000\"$\u0003"+
		"\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001\u0000\u0000\u0000"+
		"%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&(\u0001\u0000\u0000"+
		"\u0000\'%\u0001\u0000\u0000\u0000(,\u0003\u0004\u0002\u0000)+\u0003\u0006"+
		"\u0003\u0000*)\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000,*\u0001"+
		"\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-\u0001\u0001\u0000\u0000"+
		"\u0000.,\u0001\u0000\u0000\u0000/0\u0005\u0001\u0000\u000001\u0005\u0002"+
		"\u0000\u000016\u0005\'\u0000\u000023\u0005\u0003\u0000\u000035\u0005\'"+
		"\u0000\u000042\u0001\u0000\u0000\u000058\u0001\u0000\u0000\u000064\u0001"+
		"\u0000\u0000\u000067\u0001\u0000\u0000\u000079\u0001\u0000\u0000\u0000"+
		"86\u0001\u0000\u0000\u00009:\u0005\u0002\u0000\u0000:\u0003\u0001\u0000"+
		"\u0000\u0000;<\u0005\u0004\u0000\u0000<=\u0005\'\u0000\u0000=\u0005\u0001"+
		"\u0000\u0000\u0000>?\u0003\b\u0004\u0000?@\u0005\u0005\u0000\u0000@H\u0001"+
		"\u0000\u0000\u0000AB\u0003\n\u0005\u0000BC\u0005\u0005\u0000\u0000CH\u0001"+
		"\u0000\u0000\u0000DE\u0003\f\u0006\u0000EF\u0005\u0005\u0000\u0000FH\u0001"+
		"\u0000\u0000\u0000G>\u0001\u0000\u0000\u0000GA\u0001\u0000\u0000\u0000"+
		"GD\u0001\u0000\u0000\u0000H\u0007\u0001\u0000\u0000\u0000IJ\u0005\u000f"+
		"\u0000\u0000JK\u0005\u000e\u0000\u0000KY\u0005\'\u0000\u0000LM\u0005\u000f"+
		"\u0000\u0000MR\u0005\u0006\u0000\u0000NO\u0005\'\u0000\u0000OQ\u0005\u0007"+
		"\u0000\u0000PN\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001"+
		"\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000"+
		"TR\u0001\u0000\u0000\u0000UV\u0005\'\u0000\u0000VW\u0005\b\u0000\u0000"+
		"WY\u0005\'\u0000\u0000XI\u0001\u0000\u0000\u0000XL\u0001\u0000\u0000\u0000"+
		"Y\t\u0001\u0000\u0000\u0000Z[\u0005\t\u0000\u0000[_\u0003\u0010\b\u0000"+
		"\\]\u0005\t\u0000\u0000]_\u0003\u000e\u0007\u0000^Z\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000_\u000b\u0001\u0000\u0000\u0000`a\u0005"+
		"\n\u0000\u0000ae\u0003\u0010\b\u0000bc\u0005\n\u0000\u0000ce\u0003\u000e"+
		"\u0007\u0000d`\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000e\r\u0001"+
		"\u0000\u0000\u0000fg\u0005\'\u0000\u0000go\u0005%\u0000\u0000hk\u0005"+
		"\'\u0000\u0000ik\u0003\u0012\t\u0000jh\u0001\u0000\u0000\u0000ji\u0001"+
		"\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000ln\u0005\u0007\u0000\u0000"+
		"mj\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000"+
		"\u0000op\u0001\u0000\u0000\u0000pt\u0001\u0000\u0000\u0000qo\u0001\u0000"+
		"\u0000\u0000ru\u0005\'\u0000\u0000su\u0003\u0012\t\u0000tr\u0001\u0000"+
		"\u0000\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0005"+
		"&\u0000\u0000w\u000f\u0001\u0000\u0000\u0000xy\u0005\u000b\u0000\u0000"+
		"y\u007f\u0003\u0012\t\u0000z{\u0005\f\u0000\u0000{\u007f\u0003\u0012\t"+
		"\u0000|}\u0005\r\u0000\u0000}\u007f\u0003\u0012\t\u0000~x\u0001\u0000"+
		"\u0000\u0000~z\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f"+
		"\u0011\u0001\u0000\u0000\u0000\u0080\u0081\u0006\t\uffff\uffff\u0000\u0081"+
		"\u008b\u0003\u001a\r\u0000\u0082\u0083\u0005%\u0000\u0000\u0083\u0084"+
		"\u0003\u0012\t\u0000\u0084\u0085\u0005&\u0000\u0000\u0085\u008b\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0003\u0014\n\u0000\u0087\u0088\u0003\u0012"+
		"\t\u0003\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u008b\u0003\u0018\f"+
		"\u0000\u008a\u0080\u0001\u0000\u0000\u0000\u008a\u0082\u0001\u0000\u0000"+
		"\u0000\u008a\u0086\u0001\u0000\u0000\u0000\u008a\u0089\u0001\u0000\u0000"+
		"\u0000\u008b\u0092\u0001\u0000\u0000\u0000\u008c\u008d\n\u0002\u0000\u0000"+
		"\u008d\u008e\u0003\u0016\u000b\u0000\u008e\u008f\u0003\u0012\t\u0003\u008f"+
		"\u0091\u0001\u0000\u0000\u0000\u0090\u008c\u0001\u0000\u0000\u0000\u0091"+
		"\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0001\u0000\u0000\u0000\u0093\u0013\u0001\u0000\u0000\u0000\u0094"+
		"\u0092\u0001\u0000\u0000\u0000\u0095\u0096\u0007\u0000\u0000\u0000\u0096"+
		"\u0015\u0001\u0000\u0000\u0000\u0097\u009e\u0001\u0000\u0000\u0000\u0098"+
		"\u009e\u0005\u001b\u0000\u0000\u0099\u009e\u0005\u001d\u0000\u0000\u009a"+
		"\u009e\u0005\u001e\u0000\u0000\u009b\u009e\u0005\u001f\u0000\u0000\u009c"+
		"\u009e\u0005 \u0000\u0000\u009d\u0097\u0001\u0000\u0000\u0000\u009d\u0098"+
		"\u0001\u0000\u0000\u0000\u009d\u0099\u0001\u0000\u0000\u0000\u009d\u009a"+
		"\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009c"+
		"\u0001\u0000\u0000\u0000\u009e\u0017\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0007\u0001\u0000\u0000\u00a0\u0019\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0003\u001c\u000e\u0000\u00a2\u00a3\u0003\u001e\u000f\u0000\u00a3\u00a4"+
		"\u0003\u001c\u000e\u0000\u00a4\u001b\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0006\u000e\uffff\uffff\u0000\u00a6\u00b0\u0005\u0010\u0000\u0000\u00a7"+
		"\u00b0\u0005\u0011\u0000\u0000\u00a8\u00b0\u0005\'\u0000\u0000\u00a9\u00aa"+
		"\u0005\"\u0000\u0000\u00aa\u00b0\u0003\u001c\u000e\u0007\u00ab\u00ac\u0005"+
		"%\u0000\u0000\u00ac\u00ad\u0003\u001c\u000e\u0000\u00ad\u00ae\u0005&\u0000"+
		"\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u00a5\u0001\u0000\u0000"+
		"\u0000\u00af\u00a7\u0001\u0000\u0000\u0000\u00af\u00a8\u0001\u0000\u0000"+
		"\u0000\u00af\u00a9\u0001\u0000\u0000\u0000\u00af\u00ab\u0001\u0000\u0000"+
		"\u0000\u00b0\u00c2\u0001\u0000\u0000\u0000\u00b1\u00b2\n\u0005\u0000\u0000"+
		"\u00b2\u00b3\u0005\u0014\u0000\u0000\u00b3\u00c1\u0003\u001c\u000e\u0006"+
		"\u00b4\u00b5\n\u0004\u0000\u0000\u00b5\u00b6\u0005\u0015\u0000\u0000\u00b6"+
		"\u00c1\u0003\u001c\u000e\u0005\u00b7\u00b8\n\u0003\u0000\u0000\u00b8\u00b9"+
		"\u0005\u0012\u0000\u0000\u00b9\u00c1\u0003\u001c\u000e\u0004\u00ba\u00bb"+
		"\n\u0002\u0000\u0000\u00bb\u00bc\u0005\u0013\u0000\u0000\u00bc\u00c1\u0003"+
		"\u001c\u000e\u0003\u00bd\u00be\n\u0001\u0000\u0000\u00be\u00bf\u0005\u0016"+
		"\u0000\u0000\u00bf\u00c1\u0003\u001c\u000e\u0002\u00c0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00c0\u00b4\u0001\u0000\u0000\u0000\u00c0\u00b7\u0001\u0000"+
		"\u0000\u0000\u00c0\u00ba\u0001\u0000\u0000\u0000\u00c0\u00bd\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u001d\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c6\u0007\u0002"+
		"\u0000\u0000\u00c6\u001f\u0001\u0000\u0000\u0000\u00c7\u00c8\u0007\u0003"+
		"\u0000\u0000\u00c8!\u0001\u0000\u0000\u0000\u0012%,6GRX^djot~\u008a\u0092"+
		"\u009d\u00af\u00c0\u00c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}