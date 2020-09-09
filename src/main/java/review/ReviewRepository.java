package review;

import com.fasterxml.classmate.GenericType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rental.RentalEntity;
import util.DBHandler;

import java.util.List;

public class ReviewRepository {
    public void createReview(ReviewEntity review){
        Transaction transaction = null;

        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(review);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public <T extends GenericType<T>> ReviewEntity getReview(T t1){
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            ReviewEntity review = session.find(ReviewEntity.class, t1);
            return review;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void deleteReview(ReviewEntity review){
        Transaction transaction = null;
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(review);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateReview(ReviewEntity review){
        Transaction transaction = null;
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(review);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<ReviewEntity> getAllReviews(){
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            List<ReviewEntity> reviews = session.createQuery("from ReviewEntity", ReviewEntity.class).list();
            return reviews;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}