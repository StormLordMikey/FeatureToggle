package com.ioof.toggles.resources;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.ioof.toggles.domain.FeatureToggle;
import com.ioof.toggles.service.ToggleService;
import com.yammer.dropwizard.logging.Log;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/toggles/status")
@Produces(MediaType.APPLICATION_JSON)
public class ToggleResource {

    private static final Log LOG = Log.forClass(ToggleResource.class);

    private Injector injector;

    @Inject
    public ToggleResource(Injector injector) {
        this.injector = injector;
    }

    @GET
    @Timed
    public List<FeatureToggle> getAllFeatureToggles() {
        LOG.debug("Retrieving all current feature toggles");

        ToggleService service = injector.getInstance(ToggleService.class);

        return service.getFeatureToggles();
    }
}
