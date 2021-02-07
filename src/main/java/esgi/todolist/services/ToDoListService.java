package esgi.todolist.services;

import esgi.todolist.models.ItemList;
import esgi.todolist.models.ToDoList;
import esgi.todolist.models.User;
import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

    public static ItemList canAddItem(ItemList itemList){
        if(itemList.isValid()){
            return itemList;
        }
        else{
            return null;
        }
    }

    public static boolean addItem(User user, ItemList itemList, ToDoList toDoList) throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
        if (user.isValid() && canAddItem(itemList) != null){
            user.addItem(itemList, toDoList);
            return user.isAdult();
        }
        return false;
    }
}
