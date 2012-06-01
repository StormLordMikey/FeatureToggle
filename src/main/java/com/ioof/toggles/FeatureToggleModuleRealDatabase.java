package com.ioof.toggles;

import com.ioof.toggles.db.FeatureToggleDAO;
import com.ioof.toggles.db.FluentFeatureMapperDAO;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.Database;
import com.yammer.dropwizard.db.DatabaseFactory;

public class FeatureToggleModuleRealDatabase extends FeatureToggleModuleBase {

    private final FeatureToggleConfiguration configuration;
    private final Environment environment;

    public FeatureToggleModuleRealDatabase(FeatureToggleConfiguration configuration, Environment environment) {
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    protected void configureDatabase() throws ClassNotFoundException {
        final DatabaseFactory factory = new DatabaseFactory(environment);
        final Database db = factory.build(configuration.getDatabaseConfiguration(), "mysql");
        configureDAOs(db);
    }

    private void configureDAOs(Database db) {
        final FeatureToggleDAO featureToggleDAO = new FluentFeatureMapperDAO(db);
        bind(FeatureToggleDAO.class).toInstance(featureToggleDAO);
    }
}
