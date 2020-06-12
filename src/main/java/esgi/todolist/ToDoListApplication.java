package esgi.todolist;

import esgi.todolist.models.Item;
import esgi.todolist.models.List;
import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;
import esgi.todolist.services.MailService;
import esgi.todolist.models.User;
import esgi.todolist.services.ToDoListService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
		User user = new User("kelig77176@gmail.com", "Martin", "Kelig", "password", LocalDate.now().minusYears(18));
		Item item = new Item("nom de l'item", "Contenu de l'item");
		List list = new List();
		SpringApplication.run(ToDoListApplication.class, args);
		ToDoListService.addItem(user, item, list);
	}

}
