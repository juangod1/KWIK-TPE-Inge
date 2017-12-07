package Model;

import java.util.ArrayList;

public class Admin extends User{

    public void disableUser(User user){
        user.setEnabled(false);
    }

    public ArrayList<User> getUserList(){
        return null; // LUCAS BD
    }
}
