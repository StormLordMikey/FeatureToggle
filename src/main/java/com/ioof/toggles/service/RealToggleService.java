package com.ioof.toggles.service;

import com.google.inject.Inject;
import com.ioof.toggles.domain.FeatureToggle;
import com.ioof.toggles.repositories.FeatureToggleRepository;
import com.yammer.dropwizard.logging.Log;

import java.util.List;

public class RealToggleService implements ToggleService {
    
    private static final Log LOG = Log.forClass(RealToggleService.class);

    private final FeatureToggleRepository repository;

    @Inject
    public RealToggleService(FeatureToggleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FeatureToggle> getFeatureToggles() {
        return repository.getAllFeatureToggles();
    }
}
