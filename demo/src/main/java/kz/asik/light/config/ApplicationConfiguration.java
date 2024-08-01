package kz.asik.light.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

@Configuration
@ComponentScan (basePackages = "kz.asik.light")
public class ApplicationConfiguration {
    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

    @Bean
    public DataSource dataSource() {


        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Account");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
