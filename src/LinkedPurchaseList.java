import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {


    public LinkedPurchaseList(KeySubscriptions id) {
        this.id = id;
//        this.courseId = courseId;
//        this.studentId = studentId;
    }

    @EmbeddedId
    private KeySubscriptions id;



    public KeySubscriptions getId() {
        return id;
    }

    public void setId(KeySubscriptions id) {
        this.id = id;
    }
}
