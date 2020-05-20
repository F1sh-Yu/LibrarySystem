package ChatRoom;

public class UserInfo {
    private String Name;
    private String password;

    public String getName(){
        return Name;
    }

    public String getPassword(){
        return password;
    }

    public void setName(String name){
        this.Name = name;
    }

    public void setPassword(String pwd){
        this.password = pwd;
    }
}
