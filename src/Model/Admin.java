package Model;

public class Admin extends User{
    public void disableUser(User user){
        user.setEnabled(false);
    }
}
