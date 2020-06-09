package esgi.todolist.models;

import esgi.todolist.components.HelperComponent;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class ItemTest {

    @Mock
    Item item;

    @Before
    public void beforeTest() {
        this.item = new Item("item", "i am the content");
    }

    @Test
    public void testIsValidNominal(){
        assertTrue(this.item.isValid());
    }

    @Test
    public void testIsNotValidName(){
        this.item.setName(null);

        assertFalse(this.item.isValid());
    }

    @Test
    public void testIsNotValidContentTooLong(){
        this.item.setContent("bistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflexbistouflex");

        assertFalse(this.item.isValid());
    }

    @Test
    public void testIsNotValidDate(){
        this.item.setDateCreation(null);

        assertFalse(this.item.isValid());
    }
}
