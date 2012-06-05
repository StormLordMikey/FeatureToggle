package com.ioof.toggles.db;

import com.google.common.collect.ImmutableList;
import com.ioof.toggles.db.mappers.FeatureToggleMapper;
import com.ioof.toggles.core.FeatureToggle;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(FeatureToggleMapper.class)
public interface FeatureToggleDAO {

    @SqlQuery("select id, `name`, description, url, status "  +
              "from toggle.feature_toggle")
    ImmutableList<FeatureToggle> findAll();

}
