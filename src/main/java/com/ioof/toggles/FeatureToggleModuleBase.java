package com.ioof.toggles;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.ioof.toggles.repositories.FeatureToggleRepository;
import com.ioof.toggles.repositories.JDBIFeatureToggleRepository;
import com.ioof.toggles.service.RealToggleService;
import com.ioof.toggles.service.ToggleService;
import com.yammer.dropwizard.logging.Log;

public abstract class FeatureToggleModuleBase extends AbstractModule {
    private static final Log LOG = Log.forClass(FeatureToggleModuleBase.class);

    @Override
    protected void configure() {
        try {
            configureServices();
            configureRepositories();
            configureDatabase();
        } catch (ClassNotFoundException e) {
            LOG.error(e, "Error setting up Dependency Injection");
            throw new RuntimeException(e);
        }
    }

    protected abstract void configureDatabase() throws ClassNotFoundException;

    private void configureRepositories() {
        bind(FeatureToggleRepository.class).to(JDBIFeatureToggleRepository.class).in(Singleton.class);
    }

    private void configureServices() {
        bind(ToggleService.class).to(RealToggleService.class);
    }
}
