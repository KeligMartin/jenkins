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
public class UserTest {

    private HelperComponent helperComponent;

    @Mock
    User user;

    @Before
    public void beforeTest() {
        this.user = new User("test@test.fr", "Martin", "Kelig", "zougatazblex", LocalDate.now().minusYears(20));

        this.helperComponent = Mockito.mock(HelperComponent.class);
        when(this.helperComponent.checkEmail(Mockito.anyString())).thenReturn(true);

        this.user.setHelperComponent(this.helperComponent);
    }

    @Test
    public void testIsValidNominal(){
        assertTrue(this.user.isValid());
    }

    @Test
    public void testIsNotValidEmailFormat(){
        this.user.setEmail("emailnonvalide");
        when(this.helperComponent.checkEmail(Mockito.anyString())).thenReturn(false);
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

}
