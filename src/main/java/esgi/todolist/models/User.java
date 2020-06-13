package esgi.todolist.models;

import esgi.todolist.components.HelperComponent;
import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class User {

    public String email;
    private String name;
    private String firstName;
    private String password;
    private LocalDate birthDate;

    private ToDoList userToDoList;

    @Autowired
    private HelperComponent helperComponent;


    public User(String email, String name, String firstName, String password, LocalDate birthDate){
        this.userToDoList = new ToDoList();

        this.email = email;
        this.name = name;
        this.firstName = firstName;
        this.password = password;
        this.birthDate = birthDate;
    }

    public boolean isValid(){
        return EmailValidator.getInstance().isValid(this.email)
                && StringUtils.isNotBlank(this.name)
                && StringUtils.isNotBlank(this.firstName)
                && StringUtils.length(this.password) >= 8
                && StringUtils.length(this.password) <= 40
                && LocalDate.now().minusYears(13).isAfter(birthDate);
    }

    public void addItem(Item item, ToDoList toDoList) throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
        toDoList.addItem(item);
    }

    public boolean isAdult(){
        return LocalDate.now().minusYears(18).isAfter(birthDate) || LocalDate.now().minusYears(18).isEqual(birthDate);
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

    public HelperComponent getHelperComponent() {
        return helperComponent;
    }

    public void setHelperComponent(HelperComponent helperComponent) {
        this.helperComponent = helperComponent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
