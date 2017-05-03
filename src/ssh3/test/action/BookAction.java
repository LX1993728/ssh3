package ssh3.test.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh3.test.service.BookService;
import ssh3.test.vo.Book;

//<package namespace="/" extends="strtus-default">
@Namespace("/")
@ParentPackage("struts-default")
@Controller("bookAction")
@Scope("prototype")
public class BookAction extends ActionSupport implements ModelDriven<Book> {
	// 模型驱动类
	private Book book = new Book();

	public Book getModel() {
		return book;
	}

	// 在Action中注入Service
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;

	// 请求处理的方法
	@Action(value = "book_add")
	public String add() {
		System.out.println("web层的方法添加执行了......");
		bookService.add(book);
		return NONE;
	}

}
