package esgi.todolist.models;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    User user;

    @Before
    public void beforeTest() {
        this.user = new User("test@test.fr", "Martin", "Kelig", LocalDate.now().minusYears(20));
    }

    @Test
    public void testIsValidNominal(){
        assertTrue(this.user.isValid());
    }

    @Test
    public void testIsNotValidEmailFormat(){
        this.user.setEmail("emailnonvalide");
        assertFalse(this.user.isValid());
    }

    @Test
    public void testIsNotValidFirstName(){
        this.user.setFirstName(null);
        assertFalse(this.user.isValid());
    }

    @Test
    public void testIsNotValidName(){
        this.user.setName(null);
        assertFalse(this.user.isValid());
    }

}
