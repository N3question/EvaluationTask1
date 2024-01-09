package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.ConstraintViolation;

import bean.BookBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BookModel;
import validation.BeanValidation;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EditServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String janCd = request.getParameter("jan_cd");
		
		BookBean bookInfo = BookModel.getBookInfo(janCd);
		request.setAttribute("bookInfo", bookInfo);
		
		String view = "/WEB-INF/views/edit.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータから値を取得
		String jan_cd = request.getParameter("jan_cd");
		String janCd = request.getParameter("janCd");
	    String isbnCd = request.getParameter("isbn_cd");
	    String bookNm = request.getParameter("book_name");
	    String bookKana = request.getParameter("book_name_kana");
	    int price = Integer.parseInt(request.getParameter("price"));
	    String issueDate = request.getParameter("issue_date");
	    // 現在の時刻を取得（update用）
	    LocalDateTime nowDate = LocalDateTime.now();
	    Timestamp updateDateTime = Timestamp.valueOf(nowDate);
	    
		// bookbeanを生成 + セット
        BookBean bookbean = new BookBean();
        bookbean.setJAN_CD(janCd);
        bookbean.setISBN_CD(isbnCd);
        bookbean.setBOOK_NM(bookNm);
        bookbean.setBOOK_KANA(bookKana);
        bookbean.setPRICE(price);
        bookbean.setISSUE_DATE(Date.valueOf(issueDate));
        bookbean.setUPDATE_DATETIME(updateDateTime);
		
		// Bean Validationは途中
//		if (BeanValidation.validate(request, bookbean)) {
//			// 更新処理
//			BookModel.updateBookInfo(bookbean, jan_cd);
//			
//			// BookListの表示
//			ArrayList<BookBean> bookList = BookModel.getBookListAll();
//			request.setAttribute("bookList", bookList);
//			
//			String view = "/WEB-INF/views/index.jsp";
//	        request.getRequestDispatcher(view).forward(request, response);
//		} else {
//			response.sendRedirect("edit");
//		}
        Set<ConstraintViolation<BookBean>> violations = BeanValidation.validate(bookbean);

        if (violations.isEmpty()) {
            response.getWriter().println("Book is valid!");
        } else {
            for (ConstraintViolation<BookBean> violation : violations) {
                response.getWriter().println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
        }
	}

}
