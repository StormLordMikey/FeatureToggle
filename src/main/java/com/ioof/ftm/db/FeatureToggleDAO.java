package com.ioof.ftm.db;

import com.google.common.collect.ImmutableList;
import com.ioof.ftm.core.FeatureToggle;
import com.ioof.ftm.db.mappers.FeatureToggleMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(FeatureToggleMapper.class)
public interface FeatureToggleDAO {

    @SqlQuery("select id, `name`, description, enabled "  +
              "from toggle.feature_toggle")
    ImmutableList<FeatureToggle> findAll();

    @SqlUpdate("update toggle.feature_toggle " +
               "set enabled = not enabled " +
               "where id = :featureId")
    void toggleFeature(@Bind("featureId") Integer featureId);
}
