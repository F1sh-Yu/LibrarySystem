package entity;

public class Reader {
    private String username;
    private String password;
    private String name;
    private String tel;
    private String cardid;
    private String gender;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getCardid() {
        return cardid;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", cardid='" + cardid + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}
