package ru.kotovalexandrfrombutovo.destrictpassenger.server.utils;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.repositories.RouteRepository;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services.IRoutePersistenceService;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services.RoutePersistenceServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by alexkotov on 29.11.17.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.repositories")
public class JpaConfiguration {


    @Bean
    public IRoutePersistenceService routePersistenceService(){
        return new RoutePersistenceServiceImpl();
    }

    @Bean
    public RouteRepository routeRepository() throws SQLException {
        return repositoryFactorySupport().getRepository(RouteRepository.class);
    }


    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://127.0.0.1:5432/DB_DP");
        config.setUsername("postgres");
        config.setPassword("123456");
        config.setMaximumPoolSize(5);
        return new HikariDataSource(config);
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws SQLException {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.enities");
        factory.setDataSource(dataSource());
        Properties properties = new Properties();
        properties.put("hibernate.default_schema", "public");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.use_sql_comments", "true");
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");

        factory.setJpaProperties(properties);
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public RepositoryFactorySupport repositoryFactorySupport() throws SQLException {
        return new JpaRepositoryFactory(entityManager(entityManagerFactory()));
    }

}
