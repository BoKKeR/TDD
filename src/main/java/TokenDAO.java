import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class TokenDAO {

    ArrayList<Token> TokenList;

    public TokenDAO(ArrayList<Token> tokenList) {
        TokenList = tokenList;
    }

    public String addToken(String username) throws NoSuchAlgorithmException {
        Token token = new Token(username);
        this.TokenList.add(token);
        return token.getToken();
    }

    public String getTokenByUsername(String username) throws Exception {

        for (Token token: TokenList) {
            if (token.getUsername().equals(username)) {
                return token.getToken();
            }

        }
        return addToken(username);
    }

    public Boolean verifyToken(String requestToken) throws Exception {

        for (Token token: TokenList) {
            if (token.getToken().equals(requestToken)) {
                return true;
            }
        }
        return false;
    }
}
