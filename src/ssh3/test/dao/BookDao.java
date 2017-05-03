package ssh3.test.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import ssh3.test.vo.Book;

@Repository("bookDao")
public class BookDao {

	@Autowired
	@Qualifier("hibernateTemplate")
	HibernateTemplate hibernateTemplate;

	public void save(Book book) {
		System.out.println("DAO层保存图书");
		hibernateTemplate.save(book);
	}
}
