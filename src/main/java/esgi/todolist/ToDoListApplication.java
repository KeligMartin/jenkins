package esgi.todolist;

import esgi.todolist.models.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);

		LocalDateTime ldt = LocalDateTime.now();
		List l = new List();

		try{
			l.addItem("item1", "content");
		}
		catch (Exception e){
			System.err.println(e);
		}
	}

}
