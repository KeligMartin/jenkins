package esgi.todolist.models;

import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class ToDoListTest {

    @Mock
    ToDoList toDoList;

    @BeforeEach
    public void beforeTest() {
        this.toDoList = new ToDoList();
    }

    @Test
    public void testIsValidNominal(){
        assertTrue(this.toDoList.isValid());
    }

    @Test
    public void testIsNotValid() throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
        ItemList itemList = new ItemList("Name1", "Content1");
        this.toDoList.addItem(itemList);

        this.toDoList.getByName("Name1").setName("");
        assertFalse(this.toDoList.isValid());
    }

    @Test
    public void testCreationDateException(){
        ItemList itemList1 = new ItemList("Name1", "Content1");
        ItemList itemList2 = new ItemList("Name2", "Content2");

        assertThrows(CreationDateException.class, () -> {
            this.toDoList.addItem(itemList1);
            this.toDoList.addItem(itemList2);
        });
    }

    @Test
    public void testFieldIsNotUniqueException(){
        LocalDateTime ldt = LocalDateTime.now().plusMinutes(30);

        ItemList itemList1 = new ItemList("Name1", "Content1");
        ItemList itemList2 = new ItemList("Name1", "Content2", ldt);

        System.out.println(itemList1.toString());
        System.out.println(itemList2.toString());

        assertThrows(FieldIsNotUniqueException.class, () -> {
            this.toDoList.addItem(itemList1);
            this.toDoList.addItem(itemList2);
        });
    }

    @Test
    public void testNoException() throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
        assertDoesNotThrow(() -> {
            LocalDateTime ldt = LocalDateTime.now();
            ItemList itemList;

            for(int i = 0; i < 10; i++){
                itemList = new ItemList(("Name" + i) , "Content1", ldt);
                this.toDoList.addItem(itemList);
                ldt = ldt.plusMinutes(30);
            }
        });
    }

    @Test
    public void testTooManyItemsException() throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
        assertThrows(TooManyItemsException.class, () -> {
            LocalDateTime ldt = LocalDateTime.now();
            ItemList itemList;

            for(int i = 0; i < 11; i++){
                itemList = new ItemList(("Name" + i) , "Content1", ldt);
                this.toDoList.addItem(itemList);
                ldt = ldt.plusMinutes(30);
            }
        });
    }
}
