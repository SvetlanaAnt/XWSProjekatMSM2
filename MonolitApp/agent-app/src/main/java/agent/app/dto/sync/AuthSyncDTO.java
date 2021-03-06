package agent.app.dto.sync;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthSyncDTO {
    private String email;
    private String identifier;
}
