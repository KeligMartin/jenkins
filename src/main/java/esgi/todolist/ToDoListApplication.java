package esgi.todolist;

import esgi.todolist.models.ItemList;
import esgi.todolist.models.ToDoList;
import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;
import esgi.todolist.models.User;
import esgi.todolist.services.ToDoListService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
		User user = new User("kelig77176@gmail.com", "Martin", "Kelig", "password", LocalDate.now().minusYears(18));
		ItemList itemList = new ItemList("nom de l'item", "Contenu de l'item");
		ToDoList toDoList = new ToDoList();
		SpringApplication.run(ToDoListApplication.class, args);
		ToDoListService.addItem(user, itemList, toDoList);
	}

}
