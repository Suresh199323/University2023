package com.prep.prep.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableJpaRepositories
@Slf4j
@Configuration
@EnableTransactionManagement
public class PersistenceScoppConfig {

    @Bean(name = "scoppDataSource")
    public HikariDataSource getDataSource() {
        try {
            String url ="jdbc:mysql://localhost:3306/student";
            HikariDataSource dataSource = DataSourceBuilder.create(). username("root"). password("root").
                    url(url). driverClassName("com.mysql.cj.jdbc.Driver").type(HikariDataSource.class).build();
            return dataSource;

        } catch (Exception e) {
            log.error("Unable to create data source connection {}", e.getMessage());
            return null;
        }
    }


    @Bean(name = "scoppJDBCTemplate")
    public JdbcTemplate localJdbcTemplate(@Qualifier("scoppDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name="scoppTransactionManager")
    @Autowired
    DataSourceTransactionManager transactionManager(@Qualifier ("scoppDataSource") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

}



