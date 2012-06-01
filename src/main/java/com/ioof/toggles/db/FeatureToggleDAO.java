package com.ioof.toggles.db;

import com.ioof.toggles.domain.FeatureToggle;

import java.util.List;

public interface FeatureToggleDAO {

    List<FeatureToggle> getAllFeatureToggles();
}
