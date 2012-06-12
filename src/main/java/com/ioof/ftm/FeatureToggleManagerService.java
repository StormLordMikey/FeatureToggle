package com.ioof.ftm;

import com.ioof.ftm.db.FeatureToggleDAO;
import com.ioof.ftm.resources.FeatureToggleResource;
import com.ioof.ftm.resources.FeatureToggleViewResource;
import com.ioof.ftm.resources.ToggleResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.bundles.AssetsBundle;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.Database;
import com.yammer.dropwizard.db.DatabaseFactory;
import com.yammer.dropwizard.views.ViewBundle;

public class FeatureToggleManagerService extends Service<FeatureToggleManagerConfiguration> {
    public static void main(String[] args) throws Exception {
        new FeatureToggleManagerService().run(args);
    }
    
    private FeatureToggleManagerService() {
        super("feature-toggle");
        addBundle(new ViewBundle());
        addBundle(new AssetsBundle());
    }

    @Override
    protected void initialize(FeatureToggleManagerConfiguration configuration, Environment environment) throws ClassNotFoundException {

        final DatabaseFactory factory = new DatabaseFactory(environment);
        final Database db = factory.build(configuration.getDatabaseConfiguration(), "mysql");
        final FeatureToggleDAO featureToggleDAO = db.onDemand(FeatureToggleDAO.class);

        environment.addResource(new FeatureToggleResource(featureToggleDAO));
        environment.addResource(new FeatureToggleViewResource(featureToggleDAO));
        environment.addResource(new ToggleResource(featureToggleDAO));
    }
}
