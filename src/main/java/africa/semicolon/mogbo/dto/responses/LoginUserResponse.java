package africa.semicolon.mogbo.dto.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserResponse {
        private String firstName;
        private String message;
        private String dateCreated;
}
