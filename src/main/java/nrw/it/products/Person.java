package nrw.it.products;

import javax.json.bind.annotation.JsonbProperty;

public class Person {

    Long id;

    @JsonbProperty("vorname")
    private String firstName;

    @JsonbProperty("nachname")
    private String lastName;

    @JsonbProperty("alter")
    private int age;


    public Person() {}

    public Person(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
