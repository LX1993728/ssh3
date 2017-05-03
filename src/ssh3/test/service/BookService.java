package ssh3.test.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ssh3.test.dao.BookDao;
import ssh3.test.vo.Book;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
@Service("bookService")
public class BookService {
	@Autowired
	@Qualifier("bookDao")
	private BookDao bookDao;

	public void add(Book book) {
		System.out.println("Service层保存图书......");
		bookDao.save(book);
	}
}
