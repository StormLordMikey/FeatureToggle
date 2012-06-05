package com.ioof.toggles.core;

public class FeatureToggle {
    private final long id;
    private final String name;
    private final String description;
    private final String url;
    private final String status;

    public FeatureToggle(long id, String name, String description, String url, String status) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}
