package TestUser;


import SessionFactorySetUp.SessionFactoryRule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import user.UserEntity;
import user.UserRepository;

public class TestUserRepository  {
    private SessionFactory sessionFactory;
    private Session session;

    @Rule
    public final SessionFactoryRule sf = new SessionFactoryRule();

    @Test
    public void testCreateUser(){
        Session session = sf.getSession();
        UserRepository userRepository = new UserRepository();


        UserEntity user = new UserEntity();
        userRepository.createUser(user);
        session.save(user);

        sf.commit();

    }
    @After
    public void after(){
        session.close();
        sessionFactory.close();
    }

}
