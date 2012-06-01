package com.ioof.toggles.repositories;

import com.google.inject.Inject;
import com.ioof.toggles.db.FeatureToggleDAO;
import com.ioof.toggles.domain.FeatureToggle;

import java.util.List;

public class JDBIFeatureToggleRepository implements FeatureToggleRepository {
    private final FeatureToggleDAO featureToggleDAO;

    @Inject
    public JDBIFeatureToggleRepository(FeatureToggleDAO featureToggleDAO) {
        this.featureToggleDAO = featureToggleDAO;
    }

    @Override
    public List<FeatureToggle> getAllFeatureToggles() {
        return featureToggleDAO.getAllFeatureToggles();
    }
}
