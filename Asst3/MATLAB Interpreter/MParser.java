// $ANTLR 3.2 Sep 23, 2009 12:02:23 M.g 2015-11-30 01:17:08

	import java.*;
	import java.util.HashMap;
	import java.util.Vector;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class MParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEWLINE", "ID", "INT", "WS", "';'", "'='", "'['", "']'", "':'", "'+'", "'-'", "'*'", "'('", "')'", "','"
    };
    public static final int WS=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int NEWLINE=4;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int INT=6;
    public static final int ID=5;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;

    // delegates
    // delegators


        public MParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return MParser.tokenNames; }
    public String getGrammarFileName() { return "M.g"; }



    HashMap variables = new HashMap();
    Vector<MathObject> param = new Vector<MathObject>();


    MathObject getVariable(String name) {
    	if (variables.containsKey(name))
    		return ((MathObject) variables.get(name));
    	else 
    		return null;								//RETURN NULL
    }

    void setVariable(String name, MathObject val) {
    	variables.put(name,val);
    }







    // $ANTLR start "prog"
    // M.g:37:1: prog : ( stat )+ EOF ;
    public final void prog() throws RecognitionException {
        try {
            // M.g:38:2: ( ( stat )+ EOF )
            // M.g:38:5: ( stat )+ EOF
            {
            // M.g:38:5: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=ID && LA1_0<=INT)||LA1_0==14||LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // M.g:0:0: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog39);
            	    stat();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_prog46); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "prog"


    // $ANTLR start "stat"
    // M.g:43:1: stat : ( assignment ( ';' ( NEWLINE )? | NEWLINE ) | function ( ';' ( NEWLINE )? | NEWLINE ) | expression ( ';' ( NEWLINE )? | NEWLINE ) ) ;
    public final void stat() throws RecognitionException {
        MParser.assignment_return assignment1 = null;

        MathObject function2 = null;

        MathObject expression3 = null;


        try {
            // M.g:44:2: ( ( assignment ( ';' ( NEWLINE )? | NEWLINE ) | function ( ';' ( NEWLINE )? | NEWLINE ) | expression ( ';' ( NEWLINE )? | NEWLINE ) ) )
            // M.g:46:3: ( assignment ( ';' ( NEWLINE )? | NEWLINE ) | function ( ';' ( NEWLINE )? | NEWLINE ) | expression ( ';' ( NEWLINE )? | NEWLINE ) )
            {
            // M.g:46:3: ( assignment ( ';' ( NEWLINE )? | NEWLINE ) | function ( ';' ( NEWLINE )? | NEWLINE ) | expression ( ';' ( NEWLINE )? | NEWLINE ) )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID) ) {
                switch ( input.LA(2) ) {
                case 16:
                    {
                    alt8=2;
                    }
                    break;
                case 9:
                    {
                    alt8=1;
                    }
                    break;
                case NEWLINE:
                case 8:
                case 13:
                case 14:
                case 15:
                    {
                    alt8=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA8_0==INT||LA8_0==14||LA8_0==16) ) {
                alt8=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // M.g:46:4: assignment ( ';' ( NEWLINE )? | NEWLINE )
                    {
                    pushFollow(FOLLOW_assignment_in_stat80);
                    assignment1=assignment();

                    state._fsp--;
                    if (state.failed) return ;
                    // M.g:47:4: ( ';' ( NEWLINE )? | NEWLINE )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==8) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==NEWLINE) ) {
                        alt3=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // M.g:47:5: ';' ( NEWLINE )?
                            {
                            match(input,8,FOLLOW_8_in_stat95); if (state.failed) return ;
                            // M.g:47:9: ( NEWLINE )?
                            int alt2=2;
                            int LA2_0 = input.LA(1);

                            if ( (LA2_0==NEWLINE) ) {
                                alt2=1;
                            }
                            switch (alt2) {
                                case 1 :
                                    // M.g:0:0: NEWLINE
                                    {
                                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat97); if (state.failed) return ;

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // M.g:48:5: NEWLINE
                            {
                            match(input,NEWLINE,FOLLOW_NEWLINE_in_stat104); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              System.out.println((assignment1!=null?assignment1.iden:null) + " =\n" + (assignment1!=null?assignment1.value:null));
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // M.g:50:5: function ( ';' ( NEWLINE )? | NEWLINE )
                    {
                    pushFollow(FOLLOW_function_in_stat127);
                    function2=function();

                    state._fsp--;
                    if (state.failed) return ;
                    // M.g:51:4: ( ';' ( NEWLINE )? | NEWLINE )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==8) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==NEWLINE) ) {
                        alt5=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // M.g:51:5: ';' ( NEWLINE )?
                            {
                            match(input,8,FOLLOW_8_in_stat134); if (state.failed) return ;
                            // M.g:51:9: ( NEWLINE )?
                            int alt4=2;
                            int LA4_0 = input.LA(1);

                            if ( (LA4_0==NEWLINE) ) {
                                alt4=1;
                            }
                            switch (alt4) {
                                case 1 :
                                    // M.g:0:0: NEWLINE
                                    {
                                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat136); if (state.failed) return ;

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // M.g:52:5: NEWLINE
                            {
                            match(input,NEWLINE,FOLLOW_NEWLINE_in_stat143); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              System.out.println("Ans =\n" + function2);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // M.g:54:5: expression ( ';' ( NEWLINE )? | NEWLINE )
                    {
                    pushFollow(FOLLOW_expression_in_stat160);
                    expression3=expression();

                    state._fsp--;
                    if (state.failed) return ;
                    // M.g:55:4: ( ';' ( NEWLINE )? | NEWLINE )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==8) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==NEWLINE) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // M.g:55:5: ';' ( NEWLINE )?
                            {
                            match(input,8,FOLLOW_8_in_stat174); if (state.failed) return ;
                            // M.g:55:9: ( NEWLINE )?
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( (LA6_0==NEWLINE) ) {
                                alt6=1;
                            }
                            switch (alt6) {
                                case 1 :
                                    // M.g:0:0: NEWLINE
                                    {
                                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat176); if (state.failed) return ;

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // M.g:56:5: NEWLINE
                            {
                            match(input,NEWLINE,FOLLOW_NEWLINE_in_stat183); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              System.out.println("Ans =\n" + expression3);
                            }

                            }
                            break;

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "stat"

    public static class assignment_return extends ParserRuleReturnScope {
        public MathObject value;
        public String iden;
    };

    // $ANTLR start "assignment"
    // M.g:62:1: assignment returns [MathObject value, String iden] : ID '=' ( seq | matrix | expression ) ;
    public final MParser.assignment_return assignment() throws RecognitionException {
        MParser.assignment_return retval = new MParser.assignment_return();
        retval.start = input.LT(1);

        Token ID4=null;
        MathObject seq5 = null;

        MathObject matrix6 = null;

        MathObject expression7 = null;


        try {
            // M.g:63:2: ( ID '=' ( seq | matrix | expression ) )
            // M.g:64:3: ID '=' ( seq | matrix | expression )
            {
            ID4=(Token)match(input,ID,FOLLOW_ID_in_assignment220); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              retval.iden = (ID4!=null?ID4.getText():null);
            }
            match(input,9,FOLLOW_9_in_assignment233); if (state.failed) return retval;
            // M.g:66:3: ( seq | matrix | expression )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                int LA9_1 = input.LA(2);

                if ( (synpred10_M()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case INT:
                {
                int LA9_2 = input.LA(2);

                if ( (synpred10_M()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
                }
                break;
            case ID:
                {
                int LA9_3 = input.LA(2);

                if ( (synpred10_M()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 3, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA9_4 = input.LA(2);

                if ( (synpred10_M()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 4, input);

                    throw nvae;
                }
                }
                break;
            case 10:
                {
                alt9=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // M.g:66:4: seq
                    {
                    pushFollow(FOLLOW_seq_in_assignment245);
                    seq5=seq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      setVariable((ID4!=null?ID4.getText():null), seq5); retval.value = seq5;
                    }

                    }
                    break;
                case 2 :
                    // M.g:67:5: matrix
                    {
                    pushFollow(FOLLOW_matrix_in_assignment259);
                    matrix6=matrix();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      setVariable((ID4!=null?ID4.getText():null), matrix6); retval.value = matrix6;
                    }

                    }
                    break;
                case 3 :
                    // M.g:68:5: expression
                    {
                    pushFollow(FOLLOW_expression_in_assignment271);
                    expression7=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      setVariable((ID4!=null?ID4.getText():null), expression7); retval.value = expression7;
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment"


    // $ANTLR start "matrix"
    // M.g:73:1: matrix returns [MathObject value] : '[' i0= INT i1= INT ';' i2= INT i3= INT ']' ;
    public final MathObject matrix() throws RecognitionException {
        MathObject value = null;

        Token i0=null;
        Token i1=null;
        Token i2=null;
        Token i3=null;

        try {
            // M.g:74:2: ( '[' i0= INT i1= INT ';' i2= INT i3= INT ']' )
            // M.g:75:3: '[' i0= INT i1= INT ';' i2= INT i3= INT ']'
            {
            match(input,10,FOLLOW_10_in_matrix303); if (state.failed) return value;
            i0=(Token)match(input,INT,FOLLOW_INT_in_matrix307); if (state.failed) return value;
            i1=(Token)match(input,INT,FOLLOW_INT_in_matrix311); if (state.failed) return value;
            match(input,8,FOLLOW_8_in_matrix313); if (state.failed) return value;
            i2=(Token)match(input,INT,FOLLOW_INT_in_matrix320); if (state.failed) return value;
            i3=(Token)match(input,INT,FOLLOW_INT_in_matrix324); if (state.failed) return value;
            match(input,11,FOLLOW_11_in_matrix326); if (state.failed) return value;
            if ( state.backtracking==0 ) {
              int a0 = Integer.parseInt((i0!=null?i0.getText():null));
              									 int a1 = Integer.parseInt((i1!=null?i1.getText():null));
              									 int a2 = Integer.parseInt((i2!=null?i2.getText():null));
              									 int a3 = Integer.parseInt((i3!=null?i3.getText():null));
              									 double [][] m = new double[2][2];
              									 m[0][0]=a0;m[0][1]=a1;m[1][0]=a2;m[1][1]=a3;
              									 value = new MathMatrix(m);
              									
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "matrix"


    // $ANTLR start "seq"
    // M.g:100:1: seq returns [MathObject value] : f1= fact ':' f2= fact ;
    public final MathObject seq() throws RecognitionException {
        MathObject value = null;

        MParser.fact_return f1 = null;

        MParser.fact_return f2 = null;


        try {
            // M.g:101:2: (f1= fact ':' f2= fact )
            // M.g:102:3: f1= fact ':' f2= fact
            {
            pushFollow(FOLLOW_fact_in_seq354);
            f1=fact();

            state._fsp--;
            if (state.failed) return value;
            match(input,12,FOLLOW_12_in_seq356); if (state.failed) return value;
            pushFollow(FOLLOW_fact_in_seq360);
            f2=fact();

            state._fsp--;
            if (state.failed) return value;
            if ( state.backtracking==0 ) {
              value =  MathOp.createSequence((f1!=null?f1.value:null), (f2!=null?f2.value:null));
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "seq"


    // $ANTLR start "expression"
    // M.g:107:1: expression returns [MathObject value] : t= term ( '+' t1= term | '-' t1= term )* ;
    public final MathObject expression() throws RecognitionException {
        MathObject value = null;

        MathObject t = null;

        MathObject t1 = null;


        try {
            // M.g:108:2: (t= term ( '+' t1= term | '-' t1= term )* )
            // M.g:109:3: t= term ( '+' t1= term | '-' t1= term )*
            {
            pushFollow(FOLLOW_term_in_expression397);
            t=term();

            state._fsp--;
            if (state.failed) return value;
            if ( state.backtracking==0 ) {
              value = t;
            }
            // M.g:110:3: ( '+' t1= term | '-' t1= term )*
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==13) ) {
                    alt10=1;
                }
                else if ( (LA10_0==14) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // M.g:110:4: '+' t1= term
            	    {
            	    match(input,13,FOLLOW_13_in_expression410); if (state.failed) return value;
            	    pushFollow(FOLLOW_term_in_expression414);
            	    t1=term();

            	    state._fsp--;
            	    if (state.failed) return value;
            	    if ( state.backtracking==0 ) {
            	      	try {
            	      											value = MathOp.add(value, t1);
            	      										}catch (MathException e) {
            	      											System.out.println("Wrong dimensions");
            	      										} catch (Exception e) {
            	      											System.out.println("Wrong parameters");
            	      										}
            	      									
            	    }

            	    }
            	    break;
            	case 2 :
            	    // M.g:118:4: '-' t1= term
            	    {
            	    match(input,14,FOLLOW_14_in_expression425); if (state.failed) return value;
            	    pushFollow(FOLLOW_term_in_expression429);
            	    t1=term();

            	    state._fsp--;
            	    if (state.failed) return value;
            	    if ( state.backtracking==0 ) {
            	      	try {
            	      											value = MathOp.add(value, MathOp.u_minus(t1));
            	      										}catch (MathException e) {
            	      											System.out.println("Wrong dimensions");
            	      										} catch (Exception e) {
            	      											System.out.println("Wrong parameters");
            	      										}
            	      									
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "expression"


    // $ANTLR start "term"
    // M.g:130:1: term returns [MathObject value] : f= fact ( '*' f1= fact )* ;
    public final MathObject term() throws RecognitionException {
        MathObject value = null;

        MParser.fact_return f = null;

        MParser.fact_return f1 = null;


        try {
            // M.g:131:2: (f= fact ( '*' f1= fact )* )
            // M.g:132:3: f= fact ( '*' f1= fact )*
            {
            pushFollow(FOLLOW_fact_in_term465);
            f=fact();

            state._fsp--;
            if (state.failed) return value;
            if ( state.backtracking==0 ) {
              value = (f!=null?f.value:null);
            }
            // M.g:133:3: ( '*' f1= fact )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==15) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // M.g:133:4: '*' f1= fact
            	    {
            	    match(input,15,FOLLOW_15_in_term478); if (state.failed) return value;
            	    pushFollow(FOLLOW_fact_in_term482);
            	    f1=fact();

            	    state._fsp--;
            	    if (state.failed) return value;
            	    if ( state.backtracking==0 ) {
            	      	try {
            	      											value = MathOp.multiply(value, (f1!=null?f1.value:null));
            	      										}catch (MathException e) {
            	      											System.out.println("Wrong dimensions");
            	      										} catch (Exception e) {
            	      											System.out.println("Wrong parameters");
            	      										}
            	      									
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "term"

    public static class fact_return extends ParserRuleReturnScope {
        public MathObject value;
    };

    // $ANTLR start "fact"
    // M.g:146:1: fact returns [MathObject value] : ( ( (minus= '-' )? ) INT | ( (minus= '-' )? ) ID | '(' expression ')' );
    public final MParser.fact_return fact() throws RecognitionException {
        MParser.fact_return retval = new MParser.fact_return();
        retval.start = input.LT(1);

        Token minus=null;
        Token INT8=null;
        Token ID9=null;
        MathObject expression10 = null;


        try {
            // M.g:147:2: ( ( (minus= '-' )? ) INT | ( (minus= '-' )? ) ID | '(' expression ')' )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==ID) ) {
                    alt14=2;
                }
                else if ( (LA14_1==INT) ) {
                    alt14=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
                }
                break;
            case INT:
                {
                alt14=1;
                }
                break;
            case ID:
                {
                alt14=2;
                }
                break;
            case 16:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // M.g:148:3: ( (minus= '-' )? ) INT
                    {
                    // M.g:148:3: ( (minus= '-' )? )
                    // M.g:148:4: (minus= '-' )?
                    {
                    // M.g:148:9: (minus= '-' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==14) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // M.g:0:0: minus= '-'
                            {
                            minus=(Token)match(input,14,FOLLOW_14_in_fact520); if (state.failed) return retval;

                            }
                            break;

                    }


                    }

                    INT8=(Token)match(input,INT,FOLLOW_INT_in_fact524); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      if (minus == null)
                      									retval.value = new MathScalar(Double.parseDouble((INT8!=null?INT8.getText():null)));
                      								 else
                      									retval.value = new MathScalar(-1*Double.parseDouble((INT8!=null?INT8.getText():null)));
                      								
                    }

                    }
                    break;
                case 2 :
                    // M.g:153:5: ( (minus= '-' )? ) ID
                    {
                    // M.g:153:5: ( (minus= '-' )? )
                    // M.g:153:6: (minus= '-' )?
                    {
                    // M.g:153:11: (minus= '-' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==14) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // M.g:0:0: minus= '-'
                            {
                            minus=(Token)match(input,14,FOLLOW_14_in_fact536); if (state.failed) return retval;

                            }
                            break;

                    }


                    }

                    ID9=(Token)match(input,ID,FOLLOW_ID_in_fact540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      if (minus == null)
                      									retval.value = getVariable((ID9!=null?ID9.getText():null));
                      								 else
                      									retval.value = MathOp.u_minus(getVariable((ID9!=null?ID9.getText():null)));
                      								
                    }

                    }
                    break;
                case 3 :
                    // M.g:158:5: '(' expression ')'
                    {
                    match(input,16,FOLLOW_16_in_fact550); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_fact552);
                    expression10=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,17,FOLLOW_17_in_fact554); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      retval.value = expression10;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fact"


    // $ANTLR start "function"
    // M.g:162:1: function returns [MathObject value] : ID '(' f1= fact ( ',' f2= fact )? ')' ;
    public final MathObject function() throws RecognitionException {
        MathObject value = null;

        Token ID11=null;
        MParser.fact_return f1 = null;

        MParser.fact_return f2 = null;


        try {
            // M.g:163:2: ( ID '(' f1= fact ( ',' f2= fact )? ')' )
            // M.g:165:4: ID '(' f1= fact ( ',' f2= fact )? ')'
            {
            ID11=(Token)match(input,ID,FOLLOW_ID_in_function586); if (state.failed) return value;
            match(input,16,FOLLOW_16_in_function588); if (state.failed) return value;
            pushFollow(FOLLOW_fact_in_function599);
            f1=fact();

            state._fsp--;
            if (state.failed) return value;
            if ( state.backtracking==0 ) {
              param.add((f1!=null?f1.value:null));
            }
            // M.g:167:3: ( ',' f2= fact )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // M.g:167:4: ',' f2= fact
                    {
                    match(input,18,FOLLOW_18_in_function609); if (state.failed) return value;
                    pushFollow(FOLLOW_fact_in_function613);
                    f2=fact();

                    state._fsp--;
                    if (state.failed) return value;
                    if ( state.backtracking==0 ) {
                      param.add((f2!=null?f2.value:null));
                      							 if (getVariable((ID11!=null?ID11.getText():null))!=null) {
                      								MathMatrix m = (MathMatrix) getVariable((ID11!=null?ID11.getText():null));
                      								value = new MathScalar(m.returnIndex( Integer.parseInt((f1!=null?input.toString(f1.start,f1.stop):null)), Integer.parseInt((f2!=null?input.toString(f2.start,f2.stop):null)) ));
                      							 }
                      							
                    }

                    }
                    break;

            }

            match(input,17,FOLLOW_17_in_function623); if (state.failed) return value;
            if ( state.backtracking==0 ) {
              if (getVariable((ID11!=null?ID11.getText():null))==null)
              								value = MathOp.call((ID11!=null?ID11.getText():null), param);
              								
              								
              							 param.clear();	
              							
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "function"

    // $ANTLR start synpred10_M
    public final void synpred10_M_fragment() throws RecognitionException {   
        // M.g:66:4: ( seq )
        // M.g:66:4: seq
        {
        pushFollow(FOLLOW_seq_in_synpred10_M245);
        seq();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_M

    // Delegated rules

    public final boolean synpred10_M() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_M_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_stat_in_prog39 = new BitSet(new long[]{0x0000000000014060L});
    public static final BitSet FOLLOW_EOF_in_prog46 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_stat80 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_8_in_stat95 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NEWLINE_in_stat97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_stat104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_stat127 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_8_in_stat134 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NEWLINE_in_stat136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_stat143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_stat160 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_8_in_stat174 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NEWLINE_in_stat176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_stat183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assignment220 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_assignment233 = new BitSet(new long[]{0x0000000000014460L});
    public static final BitSet FOLLOW_seq_in_assignment245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_matrix_in_assignment259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_assignment271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_matrix303 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_matrix307 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_matrix311 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_matrix313 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_matrix320 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_matrix324 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_matrix326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fact_in_seq354 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_seq356 = new BitSet(new long[]{0x0000000000014060L});
    public static final BitSet FOLLOW_fact_in_seq360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_expression397 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_13_in_expression410 = new BitSet(new long[]{0x0000000000014060L});
    public static final BitSet FOLLOW_term_in_expression414 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_14_in_expression425 = new BitSet(new long[]{0x0000000000014060L});
    public static final BitSet FOLLOW_term_in_expression429 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_fact_in_term465 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_term478 = new BitSet(new long[]{0x0000000000014060L});
    public static final BitSet FOLLOW_fact_in_term482 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_14_in_fact520 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_fact524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_fact536 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_fact540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_fact550 = new BitSet(new long[]{0x0000000000014060L});
    public static final BitSet FOLLOW_expression_in_fact552 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_fact554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_function586 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_function588 = new BitSet(new long[]{0x0000000000014060L});
    public static final BitSet FOLLOW_fact_in_function599 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_function609 = new BitSet(new long[]{0x0000000000014060L});
    public static final BitSet FOLLOW_fact_in_function613 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_function623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_seq_in_synpred10_M245 = new BitSet(new long[]{0x0000000000000002L});

}