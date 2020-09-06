package review;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class ReviewEntity {

    //id int not null auto_increment,
    //    review varchar(1000) not null,
    //	rating double,
    //    bookID int,
    //    userID int,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long reviewId;

    @Column(name = "review")
    private String reviewText;

    @Column(name = "rating")
    private double reviewRating;

    @Column(name = "bookID")
    private int bookId;

    @Column(name = "userID")
    private int userId;
}
