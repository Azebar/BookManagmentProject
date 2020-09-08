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

    @Column(name = "bookID")
    private String bookId;

    @Column(name = "userID")
    private double userId;

    @Column(name = "isReturned")
    private boolean rentalIsActive;

    private Date rented_at;
    private Date return_date;

    @PrePersist
    private void onCreate() {
        rented_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        return_date = new Date();
    }

    public long getRentalId() {
        return rentalId;
    }

    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public double getUserId() {
        return userId;
    }

    public void setUserId(double userId) {
        this.userId = userId;
    }

    public boolean isRentalIsActive() {
        return rentalIsActive;
    }

    public void setRentalIsActive(boolean rentalIsActive) {
        this.rentalIsActive = rentalIsActive;
    }

    public Date getRented_at() {
        return rented_at;
    }

    public void setRented_at(Date rented_at) {
        this.rented_at = rented_at;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public RentalEntity() {
    }

    public RentalEntity(long rentalId, String bookId, double userId, boolean rentalIsActive) {
        this.rentalId = rentalId;
        this.bookId = bookId;
        this.userId = userId;
        this.rentalIsActive = rentalIsActive;
    }
}