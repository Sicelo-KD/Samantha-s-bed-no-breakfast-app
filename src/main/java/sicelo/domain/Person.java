package sicelo.domain;

/**
 * A person that uses The Bed No Breakfast App
 *
 * */
public class Person {
    private String first_name;
    private String last_name;
    private final String id_number;
    private String email;
    private String phone_number;


    public Person(String first_name, String last_name, String id_number, String email, String phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id_number = id_number;
        this.email = email;
        this.phone_number = phone_number;
    }

    public String getIdNumber(){
        return id_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getId_number() {
        return id_number;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    @Override
    public String toString() {
        return "sicelo.domain.Person{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", id_number='" + id_number + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
