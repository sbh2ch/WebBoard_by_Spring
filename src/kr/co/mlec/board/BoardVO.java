package kr.co.mlec.board;

import java.util.Date;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String content;
	private String owner;
	private Date regDate;
	private int replyCnt;

	public BoardVO() {
		super();
	}

	public BoardVO(int no, String title, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
	}

	public BoardVO(String title, String writer, String content, String owner) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.owner = owner;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getReplyCnt() {
		return replyCnt;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", owner=" + owner + ", regDate=" + regDate + ", replyCnt=" + replyCnt + "]";
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

}
