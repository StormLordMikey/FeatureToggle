package com.ioof.toggles;

import com.ioof.toggles.db.FeatureToggleDAO;
import com.ioof.toggles.resources.FeatureToggleResource;
import com.ioof.toggles.resources.FeatureToggleViewResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.bundles.AssetsBundle;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.Database;
import com.yammer.dropwizard.db.DatabaseFactory;
import com.yammer.dropwizard.views.ViewBundle;

public class FeatureToggleService extends Service<FeatureToggleConfiguration> {
    public static void main(String[] args) throws Exception {
        new FeatureToggleService().run(args);
    }
    
    private FeatureToggleService() {
        super("feature-toggle");
        addBundle(new ViewBundle());
        addBundle(new AssetsBundle());
    }

    @Override
    protected void initialize(FeatureToggleConfiguration configuration, Environment environment) throws ClassNotFoundException {

        final DatabaseFactory factory = new DatabaseFactory(environment);
        final Database db = factory.build(configuration.getDatabaseConfiguration(), "mysql");
        final FeatureToggleDAO featureToggleDAO = db.onDemand(FeatureToggleDAO.class);

        environment.addResource(new FeatureToggleResource(featureToggleDAO));
        environment.addResource(new FeatureToggleViewResource(featureToggleDAO));
    }
}
