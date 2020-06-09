package esgi.todolist;

import esgi.todolist.models.Item;
import esgi.todolist.models.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);

		LocalDateTime ldt = LocalDateTime.now();
		List l = new List();

		Item item2 = new Item("item2", "content");


		try{
			l.addItem("item1", "content");
			System.out.println(l.getItems());
		}
		catch (Exception e){
			System.err.println(e);
		}
	}

}
