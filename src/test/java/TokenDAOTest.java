import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenDAOTest {
    TokenDAO tokenDAO;

    Token token1;
    Token token2;
    Token token3;
    Token token4;
    Token token5;

    ArrayList baseTokenList;

    @BeforeEach
    void setUp() throws Exception {
        token1 = new Token("test1)");
        token2 = new Token("test2/");
        token3 = new Token("tes-3&");
        token4 = new Token("test4#");
        token5 = new Token("test5>");

        tokenDAO = new TokenDAO(baseTokenList);
        baseTokenList = new ArrayList<>(Arrays.asList(token1, token2, token3, token4, token5));
    }

    @Test
    public void generateToken() throws Exception {
        assertEquals(token1.getToken(), "D6F556EB77C60D657883F160B70E2AFF");
        assertEquals(token2.getToken(), "165D86860AC47E817D278522CDFAE0C4");
        assertEquals(token3.getToken(), "B57D538F0BAE0A325835C6AA5341EFC6");
        assertEquals(token4.getToken(), "B418652309FAEFF651161B63C552CA9B");
        assertEquals(token5.getToken(), "1ACA376EEF0D87827C92F095C15B2A7D");

    }

    @Test
    public void getUserByToken() {
        assertEquals(token1.getUsername(), "test1)");
        assertEquals(token2.getUsername(), "test2/");
        assertEquals(token3.getUsername(), "tes-3&");
        assertEquals(token4.getUsername(), "test4#");
        assertEquals(token5.getUsername(), "test5>");
    }
}

