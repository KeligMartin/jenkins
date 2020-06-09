package esgi.todolist.models;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

public class User {

    public String email;
    private String name;
    private String firstName;
    private LocalDate birthDate;


    public User(String email, String name, String firstName, LocalDate birthDate){
        this.email = email;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public boolean isValid(){
        return EmailValidator.getInstance().isValid(this.email)
                && StringUtils.isNotBlank(this.name)
                && StringUtils.isNotBlank(this.firstName)
                && LocalDate.now().minusYears(10).isAfter(birthDate);
    }

    public boolean isAdult(){
        return LocalDate.now().minusYears(18).isAfter(birthDate);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
