package services.app.adservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class AppConfig {

    @Value("${directory.prop}")
    private String photoDir;
}
