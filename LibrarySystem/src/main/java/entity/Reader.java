package entity;

public class Reader {
    private int id;
    private String username;
    private String password;
    private String name;
    private String tel;
    private String cardid;
    private String gender;

    public Reader() {
    }

    public Reader(int id, String name, String tel, String cardid) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.cardid = cardid;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", cardid='" + cardid + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}
