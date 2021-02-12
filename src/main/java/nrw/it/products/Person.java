package nrw.it.products;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ValidPerson(checkAge = false)
public class Person {

    Long id;

    @JsonbProperty("vorname")
    @NotNull
    @Size(min = 2)
    private String firstName;

    @JsonbProperty("nachname")
    @NotNull
    @Size(min = 2, max = 40)
    private String lastName;

    @JsonbProperty("alter")
    @Min(0)
    @Max(value=120, message="Das Alter '${validatedValue}' ist zu hoch. Das Maximalalter ist: {value}")
    private int age;

    @JsonbProperty("beruf")
    private String beruf;


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

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }
}
