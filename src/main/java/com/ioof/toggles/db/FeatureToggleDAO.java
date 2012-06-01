package com.ioof.toggles.db;

import com.ioof.toggles.db.mappers.FeatureToggleMapper;
import com.ioof.toggles.domain.FeatureToggle;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(FeatureToggleMapper.class)
public interface FeatureToggleDAO {

    @SqlQuery("select id, `name`, description, url, `status` "  +
              "from toggle.feature_toggle")
    List<FeatureToggle> getAllFeatureToggles();
}
