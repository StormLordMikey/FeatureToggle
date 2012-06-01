package com.ioof.toggles.service;

import com.ioof.toggles.domain.FeatureToggle;

import java.util.List;

public interface ToggleService {
    List<FeatureToggle> getFeatureToggles();
}
