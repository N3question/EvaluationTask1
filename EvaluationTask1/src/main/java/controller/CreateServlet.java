package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import bean.BookBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BookModel;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータから値を取得
		String janCd = request.getParameter("janCd");
	    String isbnCd = request.getParameter("isbn_cd");
	    String bookNm = request.getParameter("book_name");
	    String bookKana = request.getParameter("book_name_kana");
	    int price = Integer.parseInt(request.getParameter("price"));
	    String issueDate = request.getParameter("issue_date");
	    
	    // 現在の時刻を取得（update用）
	    LocalDateTime nowDate = LocalDateTime.now();
	    Timestamp createDateTime = Timestamp.valueOf(nowDate);
	    
		// bookbeanを生成 + セット
        BookBean bookbean = new BookBean();
        bookbean.setJAN_CD(janCd);
        bookbean.setISBN_CD(isbnCd);
        bookbean.setBOOK_NM(bookNm);
        bookbean.setBOOK_KANA(bookKana);
        bookbean.setPRICE(price);
        bookbean.setISSUE_DATE(Date.valueOf(issueDate));
        bookbean.setCREATE_DATETIME(createDateTime);
		
		// 登録処理
		BookModel.insertBookInfo(bookbean);
		
		// Listの表示
		ArrayList<BookBean> bookList = BookModel.getBookListAll();
		request.setAttribute("bookList", bookList);
		
		String view = "/WEB-INF/views/index.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}

}
