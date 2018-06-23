package eu.jankowskirobert.cargosystem.infrastructure.configuration;


import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.net.InetAddress;

@Slf4j

public class ESConfig {
    @Bean
    public Client client() throws Exception {
try {
    Settings esSettings = Settings.builder()
            .put("client.transport.nodes_sampler_interval", "5s")
            .put("client.transport.sniff", false)
            .build();

    TransportClient client = new PreBuiltTransportClient(esSettings);


    return client.addTransportAddress(
            new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
}catch (Exception ex){
    log.error("EEEEEEEEEEEEEEEEE",ex);
    return null;
}
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        try {
            return new ElasticsearchTemplate(client());
        }catch (Exception ex) {
            log.error("EEEEEEEEEEEEEEEEE",ex);
            return null;
        }
    }
}