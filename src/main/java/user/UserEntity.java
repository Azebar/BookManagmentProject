package user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import rental.RentalEntity;
import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer userId;

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

    public UserEntity(String firstName, String lastName, String email, String username, String phone, String password, Date dateOfBirth, String userAddress) {
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
