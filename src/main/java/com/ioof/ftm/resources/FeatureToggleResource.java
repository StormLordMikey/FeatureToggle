package com.ioof.ftm.resources;

import com.ioof.ftm.core.FeatureToggle;
import com.ioof.ftm.db.FeatureToggleDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/feature-toggles")
@Produces(MediaType.APPLICATION_JSON)
public class FeatureToggleResource {

    private final FeatureToggleDAO featureToggleDAO;

    public FeatureToggleResource(FeatureToggleDAO featureToggleDAO) {
        this.featureToggleDAO = featureToggleDAO;
    }

    @GET
    public List<FeatureToggle> listFeatureToggle() {
        return featureToggleDAO.findAll();
    }

}
