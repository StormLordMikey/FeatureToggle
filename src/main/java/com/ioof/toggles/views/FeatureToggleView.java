package com.ioof.toggles.views;

import com.ioof.toggles.core.FeatureToggle;
import com.yammer.dropwizard.views.View;

import java.util.List;

public class FeatureToggleView extends View {
    private final List<FeatureToggle> featureToggles;

    public FeatureToggleView(List<FeatureToggle> featureToggles) {
        super("/templates/features.ftl");
        this.featureToggles = featureToggles;
    }

    public List<FeatureToggle> getFeatureToggles() {
        return featureToggles;
    }
}
