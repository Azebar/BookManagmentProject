package book;

import author.AuthorEntity;
import review.ReviewEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "books")
public class BookEntity {

    //	id int not null auto_increment,
    //    title varchar(20) not null,
    //    authorID int,
    //    release_year date not null,
    //    genre varchar(40) not null,
    //    reviewID int,
    //    primary key(id),
    //    foreign key (authorID) references Author(id),
    //    foreign key (reviewID) references reviews(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long bookId;

    @Column(name = "title")
    private String bookTitle;

    @ManyToOne
    @JoinColumn(name = "authorID")
    private AuthorEntity author;

    @Column(name = "book_description")
    private String bookPrice;

    @Column(name = "release_year")
    private Date bookReleaseYear;

    @Column(name = "genre")
    private Float bookGenre;

    @Column(name = "reviews")
    private List<ReviewEntity> reviews;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getBookReleaseYear() {
        return bookReleaseYear;
    }

    public void setBookReleaseYear(Date bookReleaseYear) {
        this.bookReleaseYear = bookReleaseYear;
    }

    public Float getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(Float bookGenre) {
        this.bookGenre = bookGenre;
    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public BookEntity() {
    }

    public BookEntity(long bookId, String bookTitle, AuthorEntity author, String bookPrice, Date bookReleaseYear,
                      Float bookGenre, List<ReviewEntity> reviews) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.bookPrice = bookPrice;
        this.bookReleaseYear = bookReleaseYear;
        this.bookGenre = bookGenre;
        this.reviews = reviews;
    }
}
