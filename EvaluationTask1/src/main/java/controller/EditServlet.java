package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

import javax.xml.validation.Validator;

import bean.BookBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import model.BookModel;

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
		
		// 更新処理
		BookModel.updateBookInfo(bookbean, jan_cd);
		
		// Listの表示
		ArrayList<BookBean> bookList = BookModel.getBookListAll();
		request.setAttribute("bookList", bookList);
		
		// Bean Validationは途中
		// Validator を取得
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
		
//		// バリデーションを実行
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<BookBean>> violations = validator.validate(bookbean);

        if (violations.isEmpty()) {
            // バリデーション成功時の処理
            response.getWriter().println("バリデーション成功!");
        } else {
            // バリデーションエラー時の処理
            request.setAttribute("user", user);
            request.setAttribute("nameError", getErrorMessage(violations, "name"));
            request.setAttribute("emailError", getErrorMessage(violations, "email"));

            RequestDispatcher dispatcher = request.getRequestDispatcher("/userForm.jsp");
            dispatcher.forward(request, response);
        }
	}

}
