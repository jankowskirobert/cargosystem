package eu.jankowskirobert.cargosystem.infrastructure.configuration;


import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.net.InetAddress;

@Slf4j

public class ESConfig {

    @Value("elasticsearch.host:127.0.0.1")
    private String host;

    @Bean
    public Client client() throws Exception {
        Settings esSettings = Settings.builder()
                .put("client.transport.nodes_sampler_interval", "5s")
                .put("client.transport.sniff", false)
                .build();
        try (TransportClient client = new PreBuiltTransportClient(esSettings)) {
            return client.addTransportAddress(
                    new InetSocketTransportAddress(InetAddress.getByName(host), 9300));
        }
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());

    }
}