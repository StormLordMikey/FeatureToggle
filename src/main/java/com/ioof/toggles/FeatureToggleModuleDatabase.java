package com.ioof.toggles;

import com.google.inject.AbstractModule;
import com.ioof.toggles.db.FeatureToggleDAO;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.Database;
import com.yammer.dropwizard.db.DatabaseFactory;
import com.yammer.dropwizard.logging.Log;

public class FeatureToggleModuleDatabase extends AbstractModule {
    private final FeatureToggleConfiguration configuration;
    private final Environment environment;
    
    private static final Log LOG = Log.forClass(FeatureToggleModuleDatabase.class);

    protected FeatureToggleModuleDatabase(FeatureToggleConfiguration configuration,
                                          Environment environment) {
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    protected void configure() {
        try {
            configureDatabase();
        } catch (ClassNotFoundException e) {
            LOG.error(e, "Error setting up Dependency Injection");
            throw new RuntimeException(e);
        }
    }

    protected void configureDatabase() throws ClassNotFoundException {
        final DatabaseFactory factory = new DatabaseFactory(environment);
        final Database db = factory.build(configuration.getDatabaseConfiguration(), "mysql");

        bind(FeatureToggleDAO.class).toInstance(db.onDemand(FeatureToggleDAO.class));
    }
}
