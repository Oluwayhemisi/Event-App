package africa.semicolon.mogbo.dto.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePartyResponse {
    private String PartyName;
    private String location;
    private String createdBy;
}
