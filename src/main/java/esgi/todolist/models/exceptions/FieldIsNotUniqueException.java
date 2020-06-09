package esgi.todolist.models.exceptions;

public class FieldIsNotUniqueException extends Exception{
    public FieldIsNotUniqueException(){
        super("Name already exist");
    }
}
