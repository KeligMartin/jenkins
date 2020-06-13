package esgi.todolist.models;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class ItemListTest {

    @Mock
    ItemList itemList;

    @Before
    public void beforeTest() {
        this.itemList = new ItemList("item", "i am the content");
    }

    @Test
    public void testIsValidNominal(){
        assertTrue(this.itemList.isValid());
    }

    @Test
    public void testIsNotValidName(){
        this.itemList.setName(null);

        assertFalse(this.itemList.isValid());
    }

    @Test
    public void testIsNotValidContentTooLong(){
        this.itemList.setContent("bistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflex");

        assertFalse(this.itemList.isValid());
    }

    @Test
    public void testIsNotValidDate(){
        this.itemList.setDateCreation(null);

        assertFalse(this.itemList.isValid());
    }
}
