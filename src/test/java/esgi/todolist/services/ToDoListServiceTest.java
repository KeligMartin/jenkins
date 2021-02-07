package esgi.todolist.services;

import esgi.todolist.models.ItemList;
import esgi.todolist.models.ToDoList;
import esgi.todolist.models.User;
import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class ToDoListServiceTest {

    @Mock
    User user;

    @Mock
    ItemList itemList;

    @Mock
    ToDoList toDoList;

    @BeforeEach
    public void beforeTest(){
        this.user = new User("kelig77176@gmail.com", "Martin", "Kelig", "password", LocalDate.now().minusYears(23));
        this.itemList = new ItemList("Name of my item", "Content of my item");
        this.toDoList = new ToDoList();
    }

    @Test
    public void testIsValidAddItemNominal() throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
        assertTrue(ToDoListService.addItem(this.user, this.itemList, this.toDoList));
    }

    @Test
    public void testIsValidCanAddItemNominal(){
        Assert.assertNotNull(ToDoListService.canAddItem(this.itemList));
    }

    @Test
    public void testIsNotValidItemName(){
        this.itemList.setName(null);
        Assert.assertNull(ToDoListService.canAddItem(this.itemList));
    }

    @Test
    public void testIsNotValidItemContent(){
        this.itemList.setContent(null);
        Assert.assertNull(ToDoListService.canAddItem(this.itemList));
    }

    @Test
    public void testIsNotAdultUser() throws CreationDateException, TooManyItemsException, FieldIsNotUniqueException {
        this.user.setBirthDate(LocalDate.now().minusYears(17));
        Assert.assertFalse(ToDoListService.addItem(this.user, this.itemList, this.toDoList));
    }


}
