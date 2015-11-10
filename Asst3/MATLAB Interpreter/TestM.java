import org.antlr.runtime.*;

public class TestM {
    public static void main(String[] args) throws Exception {

        // Create an TLexer that feeds from that stream
        //TLexer lexer = new TLexer(new ANTLRInputStream(System.in));
        MLexer lexer = new MLexer(new ANTLRFileStream("input.txt"));

        // Create a stream of tokens fed by the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser that feeds off the token stream
        MParser parser = new MParser(tokens);

        // Begin parsing at rule prog
        parser.prog();
    }
}

