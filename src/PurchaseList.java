import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

    public KeyPurchaseList getId() {
        return id;
    }

    public void setId(KeyPurchaseList id) {
        this.id = id;
    }

    @EmbeddedId
    private KeyPurchaseList id;

//    @Column(name = "student_name", insertable = false, updatable = false)
//    private String studentName;
//
//    @Column(name = "course_name", insertable = false, updatable = false)
//    private String courseName;

    private int price;

    @Override
    public String toString() {
        return "PurchaseList{" +
                "id=" + id +
                ", price=" + price +
                ", subscriptionDate=" + subscriptionDate +
                '}';
    }

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
