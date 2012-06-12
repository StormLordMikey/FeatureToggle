package com.ioof.ftm.resources;

import com.ioof.ftm.db.FeatureToggleDAO;
import com.ioof.ftm.views.FeatureToggleView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/toggle/{featureId}")
@Produces(MediaType.TEXT_HTML)
public class ToggleResource {

    private final FeatureToggleDAO featureToggleDAO;

    public ToggleResource(FeatureToggleDAO featureToggleDAO) {
        this.featureToggleDAO = featureToggleDAO;
    }

    @GET
    public FeatureToggleView toggleFeature(@PathParam("featureId") Integer featureId) {
        featureToggleDAO.toggleFeature(featureId);
        return new FeatureToggleView(featureToggleDAO.findAll());
    }
}
