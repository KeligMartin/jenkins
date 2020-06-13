package esgi.todolist.models;

import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class ToDoListTest {

    @Mock
    ToDoList toDoList;

    @Before
    public void beforeTest() {
        this.toDoList = new ToDoList();
    }

    @Test
    public void testIsValidNominal(){
        assertTrue(this.toDoList.isValid());
    }

    @Test
    public void testIsNotValid() throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
        Item item = new Item("Name1", "Content1");
        this.toDoList.addItem(item);

        this.toDoList.getByName("Name1").setName("");
        assertFalse(this.toDoList.isValid());
    }

    @Test
    public void testCreationDateException(){
        Item item1 = new Item("Name1", "Content1");
        Item item2 = new Item("Name2", "Content2");

        assertThrows(CreationDateException.class, () -> {
            this.toDoList.addItem(item1);
            this.toDoList.addItem(item2);
        });
    }

    @Test
    public void testFieldIsNotUniqueException(){
        LocalDateTime ldt = LocalDateTime.now().plusMinutes(30);

        Item item1 = new Item("Name1", "Content1");
        Item item2 = new Item("Name1", "Content2", ldt);

        System.out.println(item1.toString());
        System.out.println(item2.toString());

        assertThrows(FieldIsNotUniqueException.class, () -> {
            this.toDoList.addItem(item1);
            this.toDoList.addItem(item2);
        });
    }

    @Test
    public void testTooManyItemsException() throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
        assertThrows(TooManyItemsException.class, () -> {
            LocalDateTime ldt = LocalDateTime.now();
            Item item;

            for(int i = 0; i < 11; i++){
                item = new Item(("Name" + i) , "Content1", ldt);
                this.toDoList.addItem(item);
                ldt = ldt.plusMinutes(30);
            }
        });
    }
}
