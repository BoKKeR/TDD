import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TokenTest {
    Token testTokenObject1;
    Token testTokenObject2;
    Token testTokenObject3;
    Token testTokenObject4;
    Token testTokenObject5;

    @BeforeEach
    void setUp() throws Exception {
        testTokenObject1 = new Token("u53465");
        testTokenObject2 = new Token("use¤%&¤");
        testTokenObject3 = new Token("user!#¤¤¤%/(%&))");
        testTokenObject4 = new Token("user1&%¤_&%:4AΩ");
        testTokenObject5 = new Token("user1Ñ⌡");
    }

    @Test
    public void getMultipleUsernameByToken()  {
        testTokenObject1.getUsername();
        Assertions.assertEquals(testTokenObject1.getToken(), "8080E85B02F8ECA7AE49B4E6FBE7D0D1");
        Assertions.assertEquals(testTokenObject2.getToken(), "9311ECD07738209A0813888EEA33DF66");
        Assertions.assertEquals(testTokenObject3.getToken(), "6B959ED6E28F7564D0273CB349C49160");
        Assertions.assertEquals(testTokenObject4.getToken(), "C36F699E412B2063CBDBD072FB89781D");
        Assertions.assertEquals(testTokenObject5.getToken(), "D064D544BDE8C0BFE522C23266482C80");
    }

    @Test
    public void getSameUsernameByToken()  {
        testTokenObject1.getUsername();
        Assertions.assertEquals(testTokenObject1.getToken(), "8080E85B02F8ECA7AE49B4E6FBE7D0D1");
        Assertions.assertEquals(testTokenObject1.getToken(), "8080E85B02F8ECA7AE49B4E6FBE7D0D1");
        Assertions.assertEquals(testTokenObject1.getToken(), "8080E85B02F8ECA7AE49B4E6FBE7D0D1");
        Assertions.assertEquals(testTokenObject1.getToken(), "8080E85B02F8ECA7AE49B4E6FBE7D0D1");
    }
}
