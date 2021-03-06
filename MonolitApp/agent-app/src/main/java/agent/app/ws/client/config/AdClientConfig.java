package agent.app.ws.client.config;

import agent.app.config.AppConfig;
import agent.app.ws.client.AdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class AdClientConfig {

    @Autowired
    private AppConfig appConfig;

    @Bean
    public Jaxb2Marshaller marshallerAd() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("services.app.adservice.model");
        return marshaller;
    }

    @Bean
    public AdClient adClient(@Qualifier("marshallerAd") Jaxb2Marshaller marshallerAd) {
        AdClient client = new AdClient();
        client.setDefaultUri("http://" + appConfig.getZuul() + ":8082/ad/ws");
        client.setMarshaller(marshallerAd);
        client.setUnmarshaller(marshallerAd);
        return client;
    }
}
