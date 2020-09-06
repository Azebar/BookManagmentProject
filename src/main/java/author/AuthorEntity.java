package author;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "authors", name = "authors")
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
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "country")
    private Date country;
}
