package entity;

public class Student {
    private String name;
    private int id;
    private double score;

    public Student() {
    }

    public Student(String name, int id, double score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", score=" + score +
                '}';
    }
}
