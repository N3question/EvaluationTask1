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
	
    // 一覧表示
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
	
	// 編集画面表示
	public static BookBean getBookInfo(String jan_cd) {
		final String SELECT_BOOKINFO_SQL = "SELECT * FROM BOOK WHERE JAN_CD = ?";
		ArrayList<Object> paramList = new ArrayList<>() {{ 
			add(jan_cd);
		}};
		BookBean bookbean = new BookBean();
		
		LoadJDBC.LoadingJDBC();
		try (Connection conn = ConnectionToDB.getConnection()) {
			ResultSet result = GeneralDao.executeQuery(conn, SELECT_BOOKINFO_SQL, paramList);
			
			while (result.next()) {
				String janCd = result.getString("JAN_CD");
                String isbnCd = result.getString("ISBN_CD");
                String bookNm = result.getString("BOOK_NM");
                String bookKana = result.getString("BOOK_KANA");
                int price = result.getInt("PRICE");
                Date issueDate = result.getDate("ISSUE_DATE");
                
                bookbean.setJAN_CD(janCd);
                bookbean.setISBN_CD(isbnCd);
                bookbean.setBOOK_NM(bookNm);
                bookbean.setBOOK_KANA(bookKana);
                bookbean.setPRICE(price);
                bookbean.setISSUE_DATE(issueDate);
            }
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	    return bookbean;
	}
	
	// 更新処理
	public static void updateBookInfo(BookBean bookbean, String jan_cd) {
		final String UPDATE_BOOKINFO_SQL = "UPDATE BOOK SET JAN_CD = ?, ISBN_CD = ?, BOOK_NM = ?, BOOK_KANA = ?, PRICE = ?, ISSUE_DATE = ?, UPDATE_DATETIME = ? WHERE JAN_CD = ?";
		ArrayList<Object> paramList = new ArrayList<>() {{ 
			add(bookbean.getJAN_CD());
			add(bookbean.getISBN_CD());
			add(bookbean.getBOOK_NM());
			add(bookbean.getBOOK_KANA());
			add(bookbean.getPRICE());
			add(bookbean.getISSUE_DATE());
			add(bookbean.getUPDATE_DATETIME());
			add(jan_cd);
		}};
		LoadJDBC.LoadingJDBC();
		try (Connection conn = ConnectionToDB.getConnection()) {
			GeneralDao.executeUpdate(conn, UPDATE_BOOKINFO_SQL, paramList);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	// 新規登録
	public static void insertBookInfo(BookBean bookbean) {
		final String INSERT_BOOKINFO_SQL = "INSERT INTO BOOK (JAN_CD, ISBN_CD, BOOK_NM, BOOK_KANA, PRICE, ISSUE_DATE, CREATE_DATETIME, UPDATE_DATETIME) VALUES(?, ?, ?, ?, ?, ?, ?, NULL);";
		ArrayList<Object> paramList = new ArrayList<>() {{ 
			add(bookbean.getJAN_CD());
			add(bookbean.getISBN_CD());
			add(bookbean.getBOOK_NM());
			add(bookbean.getBOOK_KANA());
			add(bookbean.getPRICE());
			add(bookbean.getISSUE_DATE());
			add(bookbean.getCREATE_DATETIME());
		}};
		LoadJDBC.LoadingJDBC();
		try (Connection conn = ConnectionToDB.getConnection()) {
			GeneralDao.executeUpdate(conn, INSERT_BOOKINFO_SQL, paramList);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	// 削除
	public static void deleteBookInfo(String jan_cd) {
		final String DELETE_BOOKINFO_SQL = "DELETE FROM BOOK WHERE JAN_CD = ?";
		ArrayList<Object> paramList = new ArrayList<>() {{ 
			add(jan_cd);
		}};
		LoadJDBC.LoadingJDBC();
		try (Connection conn = ConnectionToDB.getConnection()) {
			GeneralDao.executeUpdate(conn, DELETE_BOOKINFO_SQL, paramList);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
