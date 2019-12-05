package servlet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class dao {
    public void add(cat cat)  {
        Session session = utils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.save(cat);
        tx.commit();
    }
    //sele All

    public List<cat> selectAll() {
        Session session =utils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String hql="from cat";
        Query query = session.createQuery(hql);
        List list = query.list();
        tx.commit();
        return list;

    }
    //select by name

    public List<cat> select(String c_name) {
        Session session = utils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<cat> query = criteriaBuilder.createQuery(cat.class);
        //equal  sql from(和sql中的from差不多)
        Root<cat> root = query.from(cat.class);
        query.select(root).where(criteriaBuilder.like(root.<String>get("c_name"),"%"+c_name+"%"));
        Query<cat> query1 = session.createQuery(query);
        List<cat> cats = query1.list();
        tx.commit();
        return cats;
    }

    public void delete(String c_name) {
        Session session = utils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        //首先要先能找到
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<cat> query = criteriaBuilder.createQuery(cat.class);
        Root<cat> root = query.from(cat.class);
        query.select(root).where(criteriaBuilder.equal(root.<String>get("c_name"), c_name));
        Query<cat> query1 = session.createQuery(query);
        List<cat> cats = query1.list();
        //找到后删除
        for(cat cat:cats)
            session.delete(cat);
        tx.commit();


    }

    public void update(cat u_pro) {
        Session session = utils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        //首先要先能找到
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<cat> query = criteriaBuilder.createQuery(cat.class);
        Root<cat> root = query.from(cat.class);
        query.select(root).where(criteriaBuilder.equal(root.<String>get("c_name"),u_pro.getC_name()));
        Query<cat> query1 = session.createQuery(query);
        List<cat> cats = query1.list();
        for(cat cat:cats)
        {
            cat.setC_name(u_pro.getC_name());
            session.save(cat);
        }
        tx.commit();
    }
}
