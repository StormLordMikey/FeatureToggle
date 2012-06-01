package com.ioof.toggles;

import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.HttpConfiguration;
import com.yammer.dropwizard.config.LoggingConfiguration;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class FeatureToggleConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty
    private DatabaseConfiguration database = new DatabaseConfiguration();

    @Valid
    @NotNull
    @JsonProperty
    private HttpConfiguration http = new HttpConfiguration();

    @Valid
    @NotNull
    @JsonProperty
    public LoggingConfiguration logging = new LoggingConfiguration();


    public DatabaseConfiguration getDatabaseConfiguration() {
        return database;
    }

    public LoggingConfiguration getLoggingConfiguration() {
        return logging;
    }

    public HttpConfiguration getHttpConfiguration() {
        return http;
    }
}
