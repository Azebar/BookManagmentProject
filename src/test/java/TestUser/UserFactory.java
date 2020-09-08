package TestUser;

import org.hibernate.Session;
import user.UserEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserFactory {

    private final Session session;

    public UserFactory(Session s){
        session = s;
    }

    public UserEntity userInstance(){
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@gmail.com");
        user.setUsername("johnDoe");
        user.setPassword("password");
        user.setPhone("0612524354");
        Date date = null;
        try{
            date = new SimpleDateFormat("dd-MM-yyyy").parse("15-05-1980");
        }catch (Exception e){
            e.printStackTrace();
        }
        user.setDateOfBirth(date);

        session.save(user);

        return user;
    }
}
