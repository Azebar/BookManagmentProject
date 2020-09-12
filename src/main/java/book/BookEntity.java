package book;

import author.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import review.ReviewEntity;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer bookId;

    @Column(name = "title")
    private String bookTitle;

    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = {@JoinColumn(name = "bookID")},
            inverseJoinColumns = {@JoinColumn(name = "authorID")}
            )
    private List<AuthorEntity> author;

    @Column(name = "book_description")
    private String bookPrice;

    @Column(name = "release_year")
    private Date bookReleaseYear;

    @Column(name = "genre")
    private String bookGenre;

    @OneToMany(mappedBy = "book")
    private List<ReviewEntity> reviews;

    public BookEntity(String bookTitle, List<AuthorEntity> author, String bookPrice, Date bookReleaseYear, String bookGenre) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.bookPrice = bookPrice;
        this.bookReleaseYear = bookReleaseYear;
        this.bookGenre = bookGenre;
    }

}
