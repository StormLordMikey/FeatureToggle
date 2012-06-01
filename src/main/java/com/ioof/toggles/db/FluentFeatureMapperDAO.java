package com.ioof.toggles.db;

import com.ioof.toggles.db.mappers.FeatureToggleMapper;
import com.ioof.toggles.domain.FeatureToggle;
import com.yammer.dropwizard.db.Database;
import org.skife.jdbi.v2.Handle;

import java.util.List;

public class FluentFeatureMapperDAO implements FeatureToggleDAO {
    
    private Database db;

    public FluentFeatureMapperDAO(Database db) {
        this.db = db;
    }

    @Override
    public List<FeatureToggle> getAllFeatureToggles() {
        Handle handle = db.open();

        try {
            String query = "select id, `name`, description, url, `status` " +
                    "from toggle.feature_toggle";

            List<FeatureToggle> result = handle.createQuery(query)
                    .map(new FeatureToggleMapper())
                    .list();
            return result;
        } finally {
        handle.close();
        }
    }
}
