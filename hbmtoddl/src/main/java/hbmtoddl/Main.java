package hbmtoddl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public class Main {
  public static void main(String[] args) {
    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
        .applySettings(configuration.getProperties());
    SessionFactory factory = configuration.buildSessionFactory(builder.build());
    Session session = factory.openSession();
    Transaction transaction = session.beginTransaction();
    Student student = new Student();
    student.setStudentName("Chandra Shekhar");
    student.setAddress("Hyderabad");
    session.save(student);
    transaction.commit();
    session.flush();
    session.close();
    System.out.println("Transaction Completed !");
  }
}