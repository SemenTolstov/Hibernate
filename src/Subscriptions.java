import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscriptions {

    @EmbeddedId
    private KeySubscriptions id;

//    @Column(name = "student_id", insertable = false, updatable = false)
//    private int studentId;
//
//    @Column(name = "course_id", insertable = false, updatable = false)
//    private int courseId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
