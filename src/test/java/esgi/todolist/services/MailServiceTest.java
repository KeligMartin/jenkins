package esgi.todolist.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class MailServiceTest {
    @Mock
    MailService mailService;

    @Before
    public void beforeTest() {}

    @Test
    public void testEmailSent(){
        assertDoesNotThrow(() -> {
            String validEmail = "test.unitaire.tp@gmail.com";
            mailService.sendMail(validEmail, "Object", "Content");
        });
    }

    @Test
    public void testTooManyItemsException(){
        assertThrows(RuntimeException.class, () -> {
            String invalidEmail = "badEmail.fr";
            mailService.sendMail(invalidEmail, "Object", "Content");
        });
    }
}
