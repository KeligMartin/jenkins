package esgi.todolist.services;

import esgi.todolist.components.HelperComponent;
import esgi.todolist.models.ItemList;
import esgi.todolist.models.ToDoList;
import esgi.todolist.models.User;
import esgi.todolist.models.exceptions.CreationDateException;
import esgi.todolist.models.exceptions.FieldIsNotUniqueException;
import esgi.todolist.models.exceptions.TooManyItemsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class ToDoListServiceTest {

    private HelperComponent helperComponent;

    @Mock
    User user;

    @Mock
    ItemList itemList;

    @Mock
    ToDoList toDoList;

    @Before
    public void beforeTest(){
        this.user = new User("kelig77176@gmail.com", "Martin", "Kelig", "password", LocalDate.now().minusYears(23));
        this.itemList = new ItemList("Name of my item", "Content of my item");
        this.toDoList = new ToDoList();
        this.helperComponent = Mockito.mock(HelperComponent.class);
        when(this.helperComponent.checkEmail(Mockito.anyString())).thenReturn(true);

        this.user.setHelperComponent(helperComponent);
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
