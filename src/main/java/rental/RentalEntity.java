package rental;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "")
public class RentalEntity {

    //	id int not null auto_increment,
    //    bookID int,
    //    userID int,
    //    isActive boolean'
    //    rented_at timestamp default current_timestamp,
    //    return_date date not null,
    //    primary key(id),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long rentalId;

    @Column(name = "bookId")
    private String bookId;

    @Column(name = "userId")
    private double userId;

    @Column(name = "isActive")
    private boolean rentalIsActive;

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
}
