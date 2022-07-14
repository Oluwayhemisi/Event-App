package africa.semicolon.mogbo.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document("Users")


public class User {
    @Id
    private String id;
    @NonNull
    private String email;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String password;
    private LocalDateTime dateRegistered = LocalDateTime.now();
    @DBRef
    private List<Party>parties = new ArrayList<>();
}
