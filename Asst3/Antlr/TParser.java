// $ANTLR 3.2 Sep 23, 2009 12:02:23 T.g 2015-11-17 17:44:29

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "Letter", "Digit", "WS"
    };
    public static final int WS=7;
    public static final int Digit=6;
    public static final int ID=4;
    public static final int EOF=-1;
    public static final int Letter=5;

    // delegates
    // delegators


        public TParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return TParser.tokenNames; }
    public String getGrammarFileName() { return "T.g"; }



    // $ANTLR start "prog"
    // T.g:3:1: prog : ( expr )+ EOF ;
    public final void prog() throws RecognitionException {
        try {
            // T.g:3:6: ( ( expr )+ EOF )
            // T.g:3:9: ( expr )+ EOF
            {
            // T.g:3:9: ( expr )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // T.g:3:9: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_prog11);
            	    expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_prog14); 

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


    // $ANTLR start "expr"
    // T.g:6:1: expr : ID ;
    public final void expr() throws RecognitionException {
        try {
            // T.g:6:6: ( ID )
            // T.g:6:8: ID
            {
            match(input,ID,FOLLOW_ID_in_expr25); 

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
    // $ANTLR end "expr"

    // Delegated rules


 

    public static final BitSet FOLLOW_expr_in_prog11 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_EOF_in_prog14 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr25 = new BitSet(new long[]{0x0000000000000002L});

}