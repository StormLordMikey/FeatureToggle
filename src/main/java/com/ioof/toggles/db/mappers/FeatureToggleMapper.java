package com.ioof.toggles.db.mappers;

import com.ioof.toggles.domain.FeatureToggle;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeatureToggleMapper implements ResultSetMapper<FeatureToggle>{

    @Override
    public FeatureToggle map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new FeatureToggle(resultSet.getInt("id"),
                                 resultSet.getString("name"),
                                 resultSet.getString("description"),
                                 resultSet.getString("url"),
                                 resultSet.getString("status"));
    }
}
