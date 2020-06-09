package esgi.todolist.models.exceptions;

public class CreationDateException extends Exception{
    public CreationDateException(){
        super("You have to wait 30 min before create a new Item");
    }
}
