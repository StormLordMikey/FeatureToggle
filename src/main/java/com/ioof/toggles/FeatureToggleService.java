package com.ioof.toggles;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ioof.toggles.resources.ToggleResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

public class FeatureToggleService extends Service<FeatureToggleConfiguration> {
    public static void main(String[] args) throws Exception {
        new FeatureToggleService().run(args);
    }
    
    private FeatureToggleService() {
        super("feature-toggle");
        addBundle(new ViewBundle());
    }

    @Override
    protected void initialize(FeatureToggleConfiguration configuration, Environment environment) throws Exception {
        Injector injector = Guice.createInjector(new FeatureToggleModuleDatabase(configuration, environment));
        environment.addResource(injector.getInstance(ToggleResource.class));
    }
}
