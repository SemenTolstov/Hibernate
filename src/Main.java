import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/resources/hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "From " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseLists = session.createQuery(hql).getResultList();
        System.out.println(purchaseLists);

        String hqlCourse = "From " + Course.class.getSimpleName();
        List<Course> courseList = session.createQuery(hqlCourse).getResultList();
        System.out.println(courseList);

        String hqlStudent = "From " + Student.class.getSimpleName();
        List<Student> studentList = session.createQuery(hqlStudent).getResultList();
        System.out.println(studentList);


//        List<LinkedPurchaseList> linkedPurchaseLists = new ArrayList<>();

        for (PurchaseList purchaseList : purchaseLists) {
//            System.out.println(purchaseList.getId());
            int courseId = 0;
            for (Course course : courseList) {

                if (course.getName().equals(purchaseList.getId().getCourseName())) {
                    courseId = course.getId();
                    break;
                }

            }
            int studentId = 0;
            for (Student student : studentList) {
                if (student.getName().equals(purchaseList.getId().getStudentName())) {
                    studentId = student.getId();
                    break;
                }

            }
            KeySubscriptions subs = new KeySubscriptions();
            subs.setCourseId(courseId);
            subs.setStudentId(studentId);
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(subs);
            session.save(linkedPurchaseList);
        }


        transaction.commit();
        sessionFactory.close();
    }
}
