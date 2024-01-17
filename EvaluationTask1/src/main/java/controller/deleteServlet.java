package controller;

import java.io.IOException;
import java.util.ArrayList;

import bean.BookBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BookModel;

@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String janCd = request.getParameter("jan_cd");
		BookModel.deleteBookInfo(janCd);
		
		ArrayList<BookBean> bookList = BookModel.getBookListAll();
		request.setAttribute("bookList", bookList);
	
		String view = "/WEB-INF/views/index.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}

}
