package com.ioof.toggles.repositories;

import com.google.inject.Inject;
import com.ioof.toggles.db.FeatureToggleDAO;
import com.ioof.toggles.domain.FeatureToggle;

import java.util.List;

public class FeatureToggleRepository {
    private final FeatureToggleDAO featureToggleDAO;

    @Inject
    public FeatureToggleRepository(FeatureToggleDAO featureToggleDAO) {
        this.featureToggleDAO = featureToggleDAO;
    }

    public List<FeatureToggle> getAllFeatureToggles() {
        return featureToggleDAO.getAllFeatureToggles();
    }
}
