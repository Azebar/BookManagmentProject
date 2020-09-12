package review;

import book.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import user.UserEntity;
import javax.persistence.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer reviewId;

    @Column(name = "review")
    private String reviewText;

    @Column(name = "rating")
    private int reviewRating;

    @ManyToOne
    @JoinColumn(name = "bookID")
    private BookEntity book;

    @OneToOne
    @JoinColumn(name = "userID")
    private UserEntity user;

}

