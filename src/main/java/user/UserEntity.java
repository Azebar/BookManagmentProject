package user;

import javax.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;

@Entity
@Table(schema = "users", name = "user")
public class UserEntity {

    //	id int not null auto_increment,
    //	first_name varchar(20) not null,
    //	last_name varchar(20) not null,
    //	email varchar(20) not null unique,
    //	username varchar(20) not null unique,
    //	phone varchar(20) null,
    //	password varchar(100) not null,
    //	dateOfBirth date not null,
    //    address varchar(200) not null,
    //    created_at timestamp default current_timestamp,
    //    rentID int,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

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

    public UserEntity(String firstName, String lastName, String email, String username, String phone,
                      String password, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.dateOfBirth = convertDateStringToDateFormat(dateOfBirth);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
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
