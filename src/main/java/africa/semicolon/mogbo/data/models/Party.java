package africa.semicolon.mogbo.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Party {
    @Id
    private String id;
    private String name;
    private String location;
}
