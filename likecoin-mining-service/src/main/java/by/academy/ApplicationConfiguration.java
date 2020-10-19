package by.academy;

import by.academy.pojo.*;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
@SpringBootConfiguration
@ComponentScan("by.academy")
//@PropertySource("classpath:application.properties")
//@EnableTransactionManagement
//@EnableWebMvc
public class ApplicationConfiguration {

//        @Bean
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new org.apache.commons.dbcp.BasicDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/likecoin?serverTimezone=UTC&createDatabaseIfNotExist=true");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        return dataSource;
//    }
//    @Bean(name="entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setAnnotatedClasses(MyUser.class, MyRole.class, MyWallet.class, Block.class,
//        Transaction.class);
//        sessionFactory.setHibernateProperties(getHibernateProperties());
//        return sessionFactory;
//    }
//    private Properties getHibernateProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//        properties.setProperty("hibernate.hbm2ddl.auto", "create");
//        properties.setProperty("show_sql","true");
//        return properties;
//    }
//    @Bean
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager hibernateTransactionManager =
//                new HibernateTransactionManager();
//        hibernateTransactionManager.setSessionFactory(sessionFactory);
//        return hibernateTransactionManager;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class);
    }
}
