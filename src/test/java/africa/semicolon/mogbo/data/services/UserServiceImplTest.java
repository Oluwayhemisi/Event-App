package africa.semicolon.mogbo.data.services;

import africa.semicolon.mogbo.data.repositories.UserRepository;
import africa.semicolon.mogbo.dto.request.RegisterUserRequest;
import africa.semicolon.mogbo.exceptions.DuplicateEmailException;
import africa.semicolon.mogbo.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void registerUserTest(){

        registerUser();

        assertEquals(1,userRepository.count());
    }

    private void registerUser() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("simi@gmail.com");
        registerUserRequest.setFirstName("simi");
        registerUserRequest.setLastName("ismail");
        registerUserRequest.setPassword("1234");

        userServiceImpl.registerUser(registerUserRequest);
    }

    @Test
    public void duplicateEmailThrowsExceptionTest(){
        registerUser();
        assertThrows(DuplicateEmailException.class, this::registerUser);
        try{
            registerUser();
        }catch (DuplicateEmailException ex){
            assertEquals("simi@gmail.com exist!!!", ex.getMessage());
        }
    }
}
