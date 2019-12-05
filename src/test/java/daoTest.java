import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import servlet.cat;
import servlet.utils;

public class daoTest
{
    @Test
    public void test1()
    {
        Session session=utils.getCurrentSession();
        cat c=new cat();
        c.setC_name("miao");
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();

    }
}
