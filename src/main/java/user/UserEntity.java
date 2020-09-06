package user;

import javax.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "users")
public class UserEntity {

    //id int not null auto_increment,
    //	first_name varchar(20) not null,
    //	last_name varchar(20) not null,
    //	email varchar(20) not null unique,
    //	username varchar(20) not null unique,
    //	phone varchar(20) null,
    //	password varchar(100) not null,
    //	dateOfBirth date not null,
    //    address varchar(200) not null,
    //    created_at timestamp default current_timestamp,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "address")
    private String userAddress;

    private Date created;
    private Date updated;

    @PrePersist
    private void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public UserEntity() {
    }

    public Date convertDateStringToDateFormat(String date) {
        Date convertedDate = new Date();
        try {
            convertedDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertedDate;
    }
}
