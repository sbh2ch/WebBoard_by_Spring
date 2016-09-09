package reply;

import java.util.Date;

public class ReplyVO {
	private int replyNo;
	private int no;
	private String name;
	private String content;
	private String owner;
	private Date regDate;

	public ReplyVO() {
		super();
	}

	public ReplyVO(int replyNo, String content) {
		super();
		this.replyNo = replyNo;
		this.content = content;
	}

	public ReplyVO(int no, String name, String content, String owner) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
		this.owner = owner;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", no=" + no + ", name=" + name + ", content=" + content + ", owner=" + owner + ", regDate=" + regDate + "]";
	}
	
	

}
