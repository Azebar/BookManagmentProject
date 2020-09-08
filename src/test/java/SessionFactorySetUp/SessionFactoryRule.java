package SessionFactorySetUp;

import author.AuthorEntity;
import book.BookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import rental.RentalEntity;
import user.UserEntity;

public class SessionFactoryRule implements MethodRule {
        private SessionFactory sessionFactory;
        private Transaction transaction;
        private Session session;


        @Override
        public Statement apply(final Statement statement, FrameworkMethod frameworkMethod, Object test) {
            return new Statement() {

                @Override
                public void evaluate() throws Throwable {
                    sessionFactory = createSessionFactory();
                    createSession();
                    beginTransaction();
                    try {
                        statement.evaluate();
                    }finally {
                        shutdown();
                    }
                }
            };
        }
        private void shutdown() {
            try{
                try{
                    try{
                        transaction.rollback();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    session.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                sessionFactory.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        private SessionFactory createSessionFactory() {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(UserEntity.class)
                    .addAnnotatedClass(AuthorEntity.class)
                    .addAnnotatedClass(BookEntity.class)
                    .addAnnotatedClass(RentalEntity.class);
            configuration.setProperty("hibernate.connection.driver_class",
                    "org.h2.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem");
            configuration.setProperty("hibernate.hbm2ddl.auto", "create");

            SessionFactory sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        }

        public Session createSession(){
            session = sessionFactory.openSession();
            return session;
        }

        public void commit(){
            transaction.commit();
        }

        public void beginTransaction(){
            transaction = session.beginTransaction();
        }

        public Session getSession(){
            return session;
        }
}
