package book;

import author.AuthorEntity;
import com.fasterxml.classmate.GenericType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBHandler;

import java.util.List;

public class BookRepository {
    public void createBook(BookEntity book){
        Transaction transaction = null;

        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public <T extends GenericType<T>> BookEntity getBook(T t1){
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            BookEntity book = session.find(BookEntity.class, t1);
            return book;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void deleteBook(BookEntity book){
        Transaction transaction = null;
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateBook(BookEntity book){
        Transaction transaction = null;
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<BookEntity> getAllBooks(){
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            List<BookEntity> books = session.createQuery("from BookEntity", BookEntity.class).list();
            return books;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
