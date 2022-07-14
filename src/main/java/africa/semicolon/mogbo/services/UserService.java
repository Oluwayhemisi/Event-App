package africa.semicolon.mogbo.services;

import africa.semicolon.mogbo.dto.request.CreatePartyRequest;
import africa.semicolon.mogbo.dto.request.LoginUserRequest;
import africa.semicolon.mogbo.dto.request.RegisterUserRequest;
import africa.semicolon.mogbo.dto.responses.CreatePartyResponse;
import africa.semicolon.mogbo.dto.responses.LoginUserResponse;
import africa.semicolon.mogbo.dto.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);

    LoginUserResponse loginUser(LoginUserRequest request);

    CreatePartyResponse addParty(CreatePartyRequest request);
}
