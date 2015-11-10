// $ANTLR 3.2 Sep 23, 2009 12:02:23 T.g 2015-11-17 17:44:29

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TLexer extends Lexer {
    public static final int WS=7;
    public static final int ID=4;
    public static final int Digit=6;
    public static final int EOF=-1;
    public static final int Letter=5;

    // delegates
    // delegators

    public TLexer() {;} 
    public TLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "T.g"; }

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            int _type = Letter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // T.g:11:7: ( 'a' .. 'z' )
            // T.g:11:9: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            int _type = Digit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // T.g:12:6: ( '0' .. '9' )
            // T.g:12:8: '0' .. '9'
            {
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // T.g:15:5: ( Letter ( Digit )* )
            // T.g:15:9: Letter ( Digit )*
            {
            mLetter(); 
            // T.g:15:15: ( Digit )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // T.g:15:16: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // T.g:16:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // T.g:16:9: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // T.g:16:9: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\t' && LA2_0<='\n')||LA2_0=='\r'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // T.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // T.g:1:8: ( Letter | Digit | ID | WS )
        int alt3=4;
        switch ( input.LA(1) ) {
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            int LA3_1 = input.LA(2);

            if ( ((LA3_1>='0' && LA3_1<='9')) ) {
                alt3=3;
            }
            else {
                alt3=1;}
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt3=2;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt3=4;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // T.g:1:10: Letter
                {
                mLetter(); 

                }
                break;
            case 2 :
                // T.g:1:17: Digit
                {
                mDigit(); 

                }
                break;
            case 3 :
                // T.g:1:23: ID
                {
                mID(); 

                }
                break;
            case 4 :
                // T.g:1:26: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}