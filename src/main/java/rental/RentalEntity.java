package rental;

import book.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import user.UserEntity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer rentalId;

    @OneToOne
    @JoinColumn(name = "bookID")
    private BookEntity book;

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

}
