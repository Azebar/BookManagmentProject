package review;

import book.BookEntity;
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

    @ManyToOne
    @JoinColumn(name = "bookID")
    private BookEntity book;

    @Column(name = "userID")
    private int userId;

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public double getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(double reviewRating) {
        this.reviewRating = reviewRating;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ReviewEntity() {
    }

    public ReviewEntity(long reviewId, String reviewText, double reviewRating, BookEntity book, int userId) {
        this.reviewId = reviewId;
        this.reviewText = reviewText;
        this.reviewRating = reviewRating;
        this.book = book;
        this.userId = userId;
    }
}