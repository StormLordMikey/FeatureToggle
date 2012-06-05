package com.ioof.toggles.resources;

import com.ioof.toggles.core.FeatureToggle;
import com.ioof.toggles.db.FeatureToggleDAO;

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

//    @POST
//    public FeatureToggle createFeatureToggle(FeatureToggle featureToggle) {
//
//    }
    
    @GET
    public List<FeatureToggle> listFeatureToggle() {
        return featureToggleDAO.findAll();
    }
}
