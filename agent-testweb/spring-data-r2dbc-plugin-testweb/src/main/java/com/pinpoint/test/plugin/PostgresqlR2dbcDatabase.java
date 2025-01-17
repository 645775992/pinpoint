package com.pinpoint.test.plugin;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.Duration;

@Component
@Qualifier("postgresql")
public class PostgresqlR2dbcDatabase implements R2dbcDatabase {
    private PostgresqlConnectionFactory connectionFactory;

    public PostgresqlR2dbcDatabase() {
    }

    @PostConstruct
    public void init() throws Exception {
        connectionFactory = new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .host("localhost").port(1505).database("test").username("test").password("test").connectTimeout(Duration.ofSeconds(5 * 60)).build());
    }

    @PreDestroy
    public void destroy() {
    }

    @Override
    public ConnectionFactory getConnectionFactory() {
        return this.connectionFactory;
    }
}
