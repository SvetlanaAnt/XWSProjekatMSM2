package services.app.carrequestservice.dto;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AgentFirmIdentificationDTO {
    private String email;
    private String identifier;
}
