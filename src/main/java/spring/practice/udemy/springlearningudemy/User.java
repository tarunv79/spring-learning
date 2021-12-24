package spring.practice.udemy.springlearningudemy;


import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String dateOfBirth;

    public User() {
    }

    public User(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,this.name,this.dateOfBirth);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(!(obj instanceof User))
            return false;
        User user = (User) obj;

        return Objects.equals(this.id,user.id) &&
                Objects.equals(this.name,user.name) &&
                Objects.equals(this.dateOfBirth,user.dateOfBirth);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
