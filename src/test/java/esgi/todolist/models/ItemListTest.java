package esgi.todolist.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class ItemListTest {

    @Mock
    ItemList itemList;

    @BeforeEach
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
