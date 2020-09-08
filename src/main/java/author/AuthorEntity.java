package author;

import book.BookEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "authors")
public class AuthorEntity {

    //	id int not null auto_increment,
    //    first_name varchar(20) not null,
    //	last_name varchar(20) not null,
    //    dateOfBirth date not null,
    //    country varchar(20) not null,
    //    primary key(id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long authorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "country")
    private Date country;

    @OneToMany(mappedBy = "author")
    private List<BookEntity> books;

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getCountry() {
        return country;
    }

    public void setCountry(Date country) {
        this.country = country;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    public AuthorEntity() {
    }

    public AuthorEntity(long authorId, String firstName, String lastName, Date dateOfBirth, Date country, List<BookEntity> books) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.books = books;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> userRepository
