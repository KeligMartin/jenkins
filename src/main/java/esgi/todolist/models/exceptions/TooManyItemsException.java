package esgi.todolist.models.exceptions;

public class TooManyItemsException extends Exception{
    public TooManyItemsException(){
        super("This list has too many item !");
    }
}
