import bean.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import bean.Book;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

public class Config {
      static Configuration configuration=new Configuration().configure().addAnnotatedClass(Book.class);
      static  SessionFactory sessionFactory= configuration.buildSessionFactory();
     static BufferedReader bf=new BufferedReader( new InputStreamReader(System.in));

    public  static  void insertData() throws IOException {
        Session session= sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
        System.out.print("Enter BookName :: ");
         String bookName= bf.readLine();
        System.out.print("Enter Publisher :: ");
        String publisher= bf.readLine();
        System.out.print("Enter Price :: ");
        int price= Integer.parseInt(bf.readLine());

        Book book=new Book();
        book.setBookName(bookName);
        book.setPublisher(publisher);
        book.setPrice(price);

        session.save(book);
        tx.commit();
        session.close();

    }


    //update data
    public static void updateData() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        System.out.print("Enter BookName :: ");
        String bookName= bf.readLine();

        System.out.print("Enter Price :: ");
        int price= Integer.parseInt(bf.readLine());

//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaUpdate<Book> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Book.class);
//        Root<Book> root = criteriaUpdate.from(Book.class);
//        criteriaUpdate.set(root.get("price"), price);
//        criteriaUpdate.where(criteriaBuilder.equal(root.get("bookName"), bookName));
//        int updatedRowCount = session.createQuery(criteriaUpdate).executeUpdate();


        Query query=session.createQuery("update  Book set  price =:y where bookname =:x ");
        query.setParameter("x",bookName);
        query.setParameter("y",price);

        int updatedRowCount= query.executeUpdate();
        if (updatedRowCount > 0) {
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }

        tx.commit();
        session.close();

    }

    // Delete data

    public static void deleteData() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter BookName :: ");
        String bookName= bf.readLine();

//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaDelete<Book> criteriaDelete = criteriaBuilder.createCriteriaDelete(Book.class);
//        Root<Book> root = criteriaDelete.from(Book.class);
//        criteriaDelete.where(criteriaBuilder.equal(root.get("bookName"), bookName));



        Query query=session.createQuery("delete from Book where bookname =:x ");
        query.setParameter("x",bookName);

        int deletedRowCount = query.executeUpdate();

        if (deletedRowCount > 0) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }

        tx.commit();
        session.close();




    }

    // Show Data

    public static  void showData(){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

//        List<Book> books = (List<Book>) ((org.hibernate.query.Query<?>) query).list();

        Query query = session.createQuery("FROM Book");
        List<Book> books=query.getResultList();
        if (!books.isEmpty()) {
            System.out.println("All Books:");
            for (Book book : books) {
                System.out.println(book.toString());
            }
        } else {
            System.out.println("No books found.");
        }

        tx.commit();
        session.close();

    }

}
