package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import bean.BookBean;
import dao.GeneralDao;
import db.ConnectionToDB;
import db.LoadJDBC;

public class BookModel {
	public static ArrayList<BookBean> getBookListAll() {
		
		final String SELECT_BOOKLIST_SQL = "SELECT * FROM BOOK";
		ArrayList<Object> paramList = new ArrayList<Object>() {{ }};
		ArrayList<BookBean> bookList = new ArrayList<BookBean>();
		
		LoadJDBC.LoadingJDBC();
		try (Connection conn = ConnectionToDB.getConnection()) {
			ResultSet result = GeneralDao.executeQuery(conn, SELECT_BOOKLIST_SQL, paramList);
			
			while (result.next()) {
				String janCd = result.getString("JAN_CD");
                String isbnCd = result.getString("ISBN_CD");
                String bookNm = result.getString("BOOK_NM");
                String bookKana = result.getString("BOOK_KANA");
                int price = result.getInt("PRICE");
                Date issueDate = result.getDate("ISSUE_DATE");
                Timestamp createDatetime = result.getTimestamp("CREATE_DATETIME");
                Timestamp updateDatetime = result.getTimestamp("UPDATE_DATETIME");
                
                BookBean bookBean = new BookBean(janCd, isbnCd, bookNm, bookKana, price, issueDate, createDatetime, updateDatetime);
                bookList.add(bookBean);
            }
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	    return bookList;
	}
	
	public static BookBean getBookInfo(String janCd) {
		return null;
	}
}
