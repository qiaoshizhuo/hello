package servlet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class utils {

        public static final SessionFactory sessionFactory;
        // 创建sessionFactory
        static {
            Configuration cfg = new Configuration().configure();
            sessionFactory = cfg.buildSessionFactory();
        }

        public static Session openSession() {
            return sessionFactory.openSession();

        }

        public static Session getCurrentSession() {
            return sessionFactory.getCurrentSession();

        }

    }
