package com.example.aerospikespringboot.configuration;

import com.aerospike.client.Host;
import com.example.aerospikespringboot.repositories.AerospikeUserRepository;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

import java.util.Collection;
import java.util.Collections;


@Configuration
@EnableConfigurationProperties(AerospikeConfigurationProperties.class)
@EnableAerospikeRepositories(basePackageClasses = { AerospikeUserRepository.class })
public class AerospikeConfiguration extends AbstractAerospikeDataConfiguration {

    private final AerospikeConfigurationProperties configurationProperties;

    public AerospikeConfiguration(AerospikeConfigurationProperties configurationProperties) {
        this.configurationProperties = configurationProperties;
    }

    @Override
    protected Collection<Host> getHosts() {
        return Collections.singleton(new Host(configurationProperties.getHost(), configurationProperties.getPort()));
    }

    @Override
    protected String nameSpace() {
        return configurationProperties.getNamespace();
    }
}
