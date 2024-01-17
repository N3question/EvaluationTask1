package bean;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import group.group.Group1;
import group.group.Group2;
import group.group.Group3;

public class BookBean {
	@NotBlank(groups = Group1.class, message = "JANコードは必須です")
	@Size(min = 13, max = 13, groups = Group2.class, message = "13桁で入力してください")
	@Pattern(regexp = "^[0-9]+$", groups = Group3.class, message = "半角数字のみを入力してください")
	private String JAN_CD;
	@NotBlank(groups = Group1.class, message = "ISBNコードは必須です")
	@Size(min = 13, max = 13, groups = Group2.class, message = "13桁で入力してください")
	@Pattern(regexp = "^[0-9]+$", groups = Group3.class, message = "半角数字のみを入力してください")
	private String ISBN_CD;
	@NotBlank(groups = {Group1.class, Group2.class, Group3.class}, message = "書籍名称は必須です")
	private String BOOK_NM;
	@NotBlank(groups = {Group1.class, Group2.class, Group3.class}, message = "書籍名称カナは必須です")
	private String BOOK_KANA;
	@NotNull(groups = {Group1.class, Group2.class, Group3.class}, message = "価格は必須です")
	private Integer PRICE;
	@NotNull(groups = {Group1.class, Group2.class, Group3.class}, message = "発行日は必須です")
	private Date ISSUE_DATE;
	
	private Timestamp CREATE_DATETIME;
	private Timestamp UPDATE_DATETIME;
	
	public BookBean() {}
	
    // 一覧表示	
	public BookBean(String janCd, String isbnCd, String bookNm, String bookKana, Integer price, Date issueDate, Timestamp createDatetime, Timestamp updateDatetime) {
		this.JAN_CD = janCd;
		this.ISBN_CD = isbnCd;
		this.BOOK_NM = bookNm;
		this.BOOK_KANA = bookKana;
		this.PRICE = price;
		this.ISSUE_DATE = issueDate;
		this.CREATE_DATETIME = createDatetime;
		this.UPDATE_DATETIME = updateDatetime;
	}
	
	// 更新処理
	public BookBean(String janCd, String isbnCd, String bookNm, String bookKana, Integer price, Date issueDate, Timestamp updateDatetime) {
		this.JAN_CD = janCd;
		this.ISBN_CD = isbnCd;
		this.BOOK_NM = bookNm;
		this.BOOK_KANA = bookKana;
		this.PRICE = price;
		this.ISSUE_DATE = issueDate;
		this.UPDATE_DATETIME = updateDatetime;
	}
	
    // 編集画面表示	
	public BookBean(String janCd, String isbnCd, String bookNm, String bookKana, Integer price, Date issueDate) {
		this.JAN_CD = janCd;
		this.ISBN_CD = isbnCd;
		this.BOOK_NM = bookNm;
		this.BOOK_KANA = bookKana;
		this.PRICE = price;
		this.ISSUE_DATE = issueDate;
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

	public Integer getPRICE() {
		return PRICE;
	}

	public void setPRICE(Integer pRICE) {
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
