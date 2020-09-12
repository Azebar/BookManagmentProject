package util;

import author.AuthorEntity;
import book.BookEntity;
import rental.RentalEntity;
import review.ReviewEntity;
import user.UserEntity;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class DBHandler {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        try{
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            PropertiesConfiguration appConfig = new PropertiesConfiguration();
            appConfig.load("application.properties");

            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.URL,appConfig.getString("connectionUrl"));
            settings.put(Environment.USER, appConfig.getString("user"));
            settings.put(Environment.PASS, appConfig.getString("password"));
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");

            configuration.setProperties(settings);
            configuration.addAnnotatedClass(UserEntity.class);
            configuration.addAnnotatedClass(RentalEntity.class);
            configuration.addAnnotatedClass(BookEntity.class);
            configuration.addAnnotatedClass(AuthorEntity.class);
            configuration.addAnnotatedClass(ReviewEntity.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        }catch (Exception e){
            e.printStackTrace();
        }
        return sessionFactory;
    }
}