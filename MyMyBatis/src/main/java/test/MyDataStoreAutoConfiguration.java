package test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyDataStoreAutoConfiguration {

    @Value("${datastore.endpoint:defaultEndpoint}")
    private String endpoint;

    @Bean
    @ConditionalOnMissingBean
    public MyDataStore myDataStore() {
        return new MyDataStore(endpoint);
    }

}
