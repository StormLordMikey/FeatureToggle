package com.ioof.toggles.resources;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.ioof.toggles.service.ToggleService;
import com.ioof.toggles.views.FeatureToggleView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/toggles/status")
@Produces(MediaType.TEXT_HTML)
public class ToggleResource {

    private Injector injector;

    @Inject
    public ToggleResource(Injector injector) {
        this.injector = injector;
    }

    @GET
    public FeatureToggleView getAllFeatureToggles() {

        ToggleService service = injector.getInstance(ToggleService.class);

        return new FeatureToggleView(service.getFeatureToggles());
        //TODO: get rid of service and repository and call DAO directly
    }
}
