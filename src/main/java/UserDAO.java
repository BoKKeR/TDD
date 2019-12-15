
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    ArrayList<User> UserList;

    public UserDAO(ArrayList<User> userList) {
        UserList = userList;
    }


    public  List<User> registerUser(User user) {
         this.UserList.add(user);
         return this.UserList;
    }

    public  void deleteUser(User user) {
        this.UserList.remove(user);
    }

    public User findUserByUsername (String loginUsername) throws Exception{
        for (User user: UserList) {
            if (user.getUsername().equals(loginUsername))
                return user;
        }
        throw new Exception("User not found in list");
    }
}
