package com.trpo.lectureRepo.core.config;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.trpo.lectureRepo.core.models.entity")
public class ElasticsearchConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticsearchConfiguration.class);

    @Value("${spring.elastic.elasticsearch.host}")
    private String  hostname;

    @Value("${spring.elastic.elasticsearch.port}")
    private Integer port;

    @Value("${spring.elastic.elasticsearch.clustername}")
    private String  clusterName;

    @Bean
    public ElasticsearchOperations elasticsearchTemplate(Client client) {
        LOGGER.info("ElasticsearchConfiguration::elasticsearchTemplate({}) called", client);
        return new ElasticsearchTemplate(client);
    }

    @Bean
    public Client client(){
        LOGGER.info("ElasticsearchConfiguration::client called");

        //Settings settings = ImmutableSettings.builder()     // for 1.x
        Settings settings = Settings.settingsBuilder()    // for 2.x
                .put("cluster.name", clusterName)
                .put("cluster.transport.sniff", true)
                .put("cluster.transport.nodes_sampler_interval", "15s")
                .put("cluster.transport.ping_timeout", "25s").build();

        Client client = null;
        try {
            client = TransportClient.builder().settings(settings).build()   // for 2.x
                    //client = new TransportClient(settings)      // for 1.x
                    //.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(hostname), 9300))
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(hostname), port));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return client;
    }
}
