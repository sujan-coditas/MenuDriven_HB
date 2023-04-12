package bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Book")
public class Book  implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int bookid;
    private int price;

    private String bookName, Publisher;

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public Book() {
    }

    public Book(int bookid, String bookName, String publisher,int price) {
        this.bookid = bookid;
        this.price = price;
        this.bookName = bookName;
        this.Publisher = publisher;
    }

    @Override
    public String toString() {
        return "bean.Book{" +
                "bookid=" + bookid +
                ", price=" + price +
                ", bookName='" + bookName + '\'' +
                ", Publisher='" + Publisher + '\'' +
                '}';
    }
}
