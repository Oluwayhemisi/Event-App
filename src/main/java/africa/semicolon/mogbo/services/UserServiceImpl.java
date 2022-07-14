package africa.semicolon.mogbo.services;


import africa.semicolon.mogbo.data.models.Party;
import africa.semicolon.mogbo.data.models.User;
import africa.semicolon.mogbo.data.repositories.UserRepository;
import africa.semicolon.mogbo.dto.request.CreatePartyRequest;
import africa.semicolon.mogbo.dto.request.LoginUserRequest;
import africa.semicolon.mogbo.dto.request.RegisterUserRequest;
import africa.semicolon.mogbo.dto.responses.CreatePartyResponse;
import africa.semicolon.mogbo.dto.responses.LoginUserResponse;
import africa.semicolon.mogbo.dto.responses.RegisterUserResponse;
import africa.semicolon.mogbo.exceptions.DuplicateEmailException;
import africa.semicolon.mogbo.exceptions.LogInException;
import africa.semicolon.mogbo.exceptions.UserDoesNotExistException;
import africa.semicolon.mogbo.utils.Mapper;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PartyService partyService;

    @Override
    public RegisterUserResponse registerUser (RegisterUserRequest request){
       if(userRepository.existsByEmail(request.getEmail())) throw new DuplicateEmailException(request.getEmail()+"already exist");
        User user = new User();
        Mapper.map(request,user);
        User savedUser = userRepository.save(user);
        RegisterUserResponse response  = new RegisterUserResponse();
        Mapper.map(savedUser,response);
        return response;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest request) {
        LoginUserResponse response = new LoginUserResponse();
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()-> new LogInException("User "+request.getEmail()+ "not found"));
       if(Objects.equals(request.getPassword(),user.getPassword())){
           response.setFirstName(user.getFirstName());
           response.setMessage("Welcome back "+response.getFirstName());
           response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm,a").format(user.getDateRegistered()));}
       else{
           response.setMessage("Incorrect password");
       }
       return response;
    }
    @Override
    public CreatePartyResponse addParty(CreatePartyRequest request){
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());
        if(optionalUser.isEmpty()) throw new UserDoesNotExistException(request.getEmail()+" does not exist");
        User foundUser = optionalUser.get();
        Party party = new Party();
        party.setLocation(request.getPartyLocation());
        party.setName(request.getPartyName());
        Party savedParty = partyService.saveParty(party);

        foundUser.getParties().add(savedParty);
        userRepository.save(foundUser);



        CreatePartyResponse response = new CreatePartyResponse();
        response.setLocation(savedParty.getLocation());
        response.setCreatedBy(foundUser.getFirstName());
        response.setPartyName(savedParty.getName());

        return response;
    }
}
