package com.ioof.ftm.core;

public class FeatureToggle {
    private final long id;
    private final String name;
    private final String description;
    private final String url;
    private final Boolean enabled;

    public FeatureToggle(long id, String name, String description, String url, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getEnabled() {
        return enabled;
    }
}
