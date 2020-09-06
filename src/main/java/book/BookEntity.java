package book;

import javax.persistence.*;
import java.sql.Date;


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

        @Column(name = "authorID")
        private int bookAuthorID;

        @Column(name = "price")
        private Float bookPrice;

        @Column(name = "release_year")
        private Date bookReleaseYear;

        @Column(name = "genre")
        private Float bookGenre;

        @Column(name = "reviewID")
        private int bookReviewId;
}
