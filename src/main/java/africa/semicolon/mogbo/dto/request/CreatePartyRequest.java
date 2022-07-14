package africa.semicolon.mogbo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePartyRequest {
    private String email;
    private String partyName;
    private String partyLocation;
}
