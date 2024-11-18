package itsyuryupa.userinfo;

import controller.UserController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import repository.UserRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetAllUsers() throws Exception {
        // Тестирование получения списка пользователей
    }

    @Test
    public void testCreateUser() throws Exception {
        // Тестирование создания пользователя
    }
}

