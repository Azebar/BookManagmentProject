package rental;

import book.BookEntity;
import com.fasterxml.classmate.GenericType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBHandler;

import java.util.List;

public class RentalRepository {
    public void createRent(RentalEntity rent){
        Transaction transaction = null;

        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(rent);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public <T extends GenericType<T>> RentalEntity getRent(T t1){
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            RentalEntity rent = session.find(RentalEntity.class, t1);
            return rent;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void deleteRent(RentalEntity rent){
        Transaction transaction = null;
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(rent);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateRent(RentalEntity rent){
        Transaction transaction = null;
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(rent);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<RentalEntity> getAllRents(){
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            List<RentalEntity> rents = session.createQuery("from RentalEntity", RentalEntity.class).list();
            return rents;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
