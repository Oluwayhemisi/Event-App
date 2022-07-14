package africa.semicolon.mogbo.controllers;


import africa.semicolon.mogbo.dto.request.CreatePartyRequest;
import africa.semicolon.mogbo.dto.request.LoginUserRequest;
import africa.semicolon.mogbo.dto.request.RegisterUserRequest;
import africa.semicolon.mogbo.dto.responses.ApiResponse;
import africa.semicolon.mogbo.dto.responses.LoginUserResponse;
import africa.semicolon.mogbo.dto.responses.RegisterUserResponse;
import africa.semicolon.mogbo.exceptions.DuplicateEmailException;
import africa.semicolon.mogbo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest){
        try{
            var serviceResponse =userService.registerUser(registerUserRequest);
            ApiResponse response = new ApiResponse(true,serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (DuplicateEmailException ex){
            ApiResponse response = new ApiResponse(false,ex.getMessage());
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/login")
    public LoginUserResponse login(@RequestBody LoginUserRequest request){
        return userService.loginUser(request);
    }

    @PostMapping("/party")
    public ResponseEntity<?> createParty(@RequestBody CreatePartyRequest createPartyRequest){
        try{
           var serviceResponse = userService.addParty(createPartyRequest);
           ApiResponse response = new ApiResponse(true,serviceResponse);
           return new ResponseEntity<>(response,HttpStatus.CREATED);
        }catch (DuplicateEmailException ex){
            ApiResponse response = new ApiResponse(false,ex.getMessage());
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
}
