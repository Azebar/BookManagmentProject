package rental;

import book.BookEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import user.UserEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rent")
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

//    @Column(name = "bookID")
//    private String bookId;
    @OneToOne
    @JoinColumn(name = "bookID")
    private BookEntity book;

//    @Column(name = "userID")
//    private double userId;
    @ManyToOne
    @JoinColumn(name = "userID")
    private UserEntity user;

    @Column(name = "isReturned")
    private boolean rentalIsActive;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rented_at")
    private Date rentedAt;

    @Column(name = "return_date")
    private Date returnDate;

    public long getRentalId() {
        return rentalId;
    }

    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public boolean isRentalIsActive() {
        return rentalIsActive;
    }

    public void setRentalIsActive(boolean rentalIsActive) {
        this.rentalIsActive = rentalIsActive;
    }

    public Date getRentedAt() {
        return rentedAt;
    }

    public void setRentedAt(Date rentedAt) {
        this.rentedAt = rentedAt;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public RentalEntity() {
    }


}
