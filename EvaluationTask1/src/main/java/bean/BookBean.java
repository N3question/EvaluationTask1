package bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class BookBean implements Serializable {
	private String JAN_CD;
	private String ISBN_CD;
	private String BOOK_NM;
	private String BOOK_KANA;
	private int PRICE;
	private Date ISSUE_DATE;
	private Timestamp CREATE_DATETIME;
	private Timestamp UPDATE_DATETIME;
	
	public BookBean() {}
	public BookBean(String janCd, String isbnCd, String bookNm, String bookKana, int price, Date issueDate, Timestamp createDatetime, Timestamp updateDatetime) {
		this.JAN_CD = janCd;
		this.ISBN_CD = isbnCd;
		this.BOOK_NM = bookNm;
		this.BOOK_KANA = bookKana;
		this.PRICE = price;
		this.ISSUE_DATE = issueDate;
		this.CREATE_DATETIME = createDatetime;
		this.UPDATE_DATETIME = updateDatetime;
	}
	
	public String getJAN_CD() {
		return JAN_CD;
	}

	public void setJAN_CD(String jAN_CD) {
		JAN_CD = jAN_CD;
	}

	public String getISBN_CD() {
		return ISBN_CD;
	}

	public void setISBN_CD(String iSBN_CD) {
		ISBN_CD = iSBN_CD;
	}

	public String getBOOK_NM() {
		return BOOK_NM;
	}

	public void setBOOK_NM(String bOOK_NM) {
		BOOK_NM = bOOK_NM;
	}

	public String getBOOK_KANA() {
		return BOOK_KANA;
	}

	public void setBOOK_KANA(String bOOK_KANA) {
		BOOK_KANA = bOOK_KANA;
	}

	public int getPRICE() {
		return PRICE;
	}

	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}

	public Date getISSUE_DATE() {
		return ISSUE_DATE;
	}

	public void setISSUE_DATE(Date iSSUE_DATE) {
		ISSUE_DATE = iSSUE_DATE;
	}

	public Timestamp getCREATE_DATETIME() {
		return CREATE_DATETIME;
	}

	public void setCREATE_DATETIME(Timestamp cREATE_DATETIME) {
		CREATE_DATETIME = cREATE_DATETIME;
	}

	public Timestamp getUPDATE_DATETIME() {
		return UPDATE_DATETIME;
	}

	public void setUPDATE_DATETIME(Timestamp uPDATE_DATETIME) {
		UPDATE_DATETIME = uPDATE_DATETIME;
	}

}
