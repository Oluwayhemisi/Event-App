package africa.semicolon.mogbo.dto.request;

import lombok.Data;
@Data

public class LoginUserRequest {
    private String email;
    private String password;
}
