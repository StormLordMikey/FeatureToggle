package com.ioof.toggles.resources;

import com.ioof.toggles.db.FeatureToggleDAO;
import com.ioof.toggles.views.FeatureToggleView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/feature-toggles-view")
@Produces(MediaType.TEXT_HTML)
public class FeatureToggleViewResource {

    private final FeatureToggleDAO featureToggleDAO;

    public FeatureToggleViewResource(FeatureToggleDAO featureToggleDAO) {
        this.featureToggleDAO = featureToggleDAO;
    }

    @GET
    public FeatureToggleView listFeatureToggle() {
        return new FeatureToggleView(featureToggleDAO.findAll());
    }
}
