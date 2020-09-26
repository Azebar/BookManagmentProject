package author;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBHandler;

import java.util.List;

public class AuthorRepository {
    public void createAuthor(AuthorEntity author){
        Transaction transaction = null;

        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public AuthorEntity getAuthor(Integer id){
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            AuthorEntity author = session.find(AuthorEntity.class, id);
            return author;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void deleteAuthor(AuthorEntity author){
        Transaction transaction = null;
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(author);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateAuthor(AuthorEntity author){
        Transaction transaction = null;
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(author);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<AuthorEntity> getAllAuthors(){
        try {
            Session session = DBHandler.getSessionFactory().openSession();
            List<AuthorEntity> authors = session.createQuery("from AuthorEntity", AuthorEntity.class).list();
            return authors;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
