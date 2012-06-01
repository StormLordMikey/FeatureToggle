package com.ioof.toggles.repositories;

import com.ioof.toggles.domain.FeatureToggle;
import java.util.List;

public interface FeatureToggleRepository {
    List<FeatureToggle> getAllFeatureToggles();
}
