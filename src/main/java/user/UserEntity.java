package user;

import org.hibernate.annotations.CreationTimestamp;
import rental.RentalEntity;

import javax.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private java.util.Date createdAt;

   @OneToMany(mappedBy = "user")
   private List<RentalEntity> rent;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public java.util.Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.util.Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<RentalEntity> getRent() {
        return rent;
    }

    public void setRent(List<RentalEntity> rent) {
        this.rent = rent;
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
    public UserEntity(String firstName, String lastName, String email, String username, String phone, String password, java.sql.Date dateOfBirth, String userAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.userAddress = userAddress;
    }
}
