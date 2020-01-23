import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class TokenDAO {

    ArrayList<Token> TokenList;

    public TokenDAO(ArrayList<Token> tokenList) {
        TokenList = tokenList;
    }

    public List<Token> addToken(String username) throws NoSuchAlgorithmException {
        Token token = new Token(username);
        this.TokenList.add(token);
        return this.TokenList;
    }

    public String getTokenByUsername(String username) throws Exception {
        for (Token token: TokenList) {
            if (token.getUsername().equals(username)) {
                return token.getToken();
            }
        }
        return null;
    }
}
