package esgi.todolist.services;

import esgi.todolist.models.Item;
import esgi.todolist.models.ToDoList;
import esgi.todolist.models.User;
import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

    public static Item canAddItem(Item item){
        if(item.isValid()){
            return item;
        }
        else{
            return null;
        }
    }

    public static boolean addItem(User user, Item item, ToDoList toDoList) throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
        if (user.isValid() && canAddItem(item) != null){
            user.addItem(item, toDoList);
            if(user.isAdult()){
                MailService.sendMail(user.getEmail(), "Added " + item.getName() + " item", item.getContent());
                return true;
            }
        }
        return false;
    }
}
