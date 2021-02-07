package esgi.todolist.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class UserTest {


    @Mock
    User user;

    @BeforeEach
    public void beforeTest() {
        this.user = new User("test@test.fr", "Martin", "Kelig", "zougatazblex", LocalDate.now().minusYears(20));
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
    public void testIsNotValidPasswordTooShort(){
        this.user.setPassword("oui");
        assertFalse(this.user.isValid());
    }

    @Test
    public void testIsNotValidPasswordTooLong(){
        this.user.setPassword("zougatazblexzougatazblexzougatazblexzougatazblexzougatazblexzougatazblex");
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

    @Test
    public void testIsNotAdult(){
        this.user.setBirthDate(LocalDate.now().minusYears(17));
        assertFalse(this.user.isAdult());
    }

}
