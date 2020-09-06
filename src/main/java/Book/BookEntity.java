package Book;

import javax.persistence.*;


    @Entity
    @Table(schema = "books", name = "book")
    public class BookEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        @Column(name = "title")
        private String bookTitle;

        @Column(name = "description")
        private String description;

        @Column(name = "price")
        private Float price;

        @Column(name = "description")
        private String description;

        @Column(name = "price")
        private Float price;

        @Column(name = "description")
        private String description;

        @Column(name = "price")
        private Float price;

        @Column(name = "description")
        private String description;

        @Column(name = "price")
        private Float price;
}
