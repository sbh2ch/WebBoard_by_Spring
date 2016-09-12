package kr.co.mlec.file;

public class FileVO {
	private int fileNo;
	private int no;
	private String oriName;
	private String realName;
	private String filePath;
	private int fileSize;

	public FileVO() {
		super();
	}

	public FileVO(int no, String oriName, String realName, String filePath, int fileSize) {
		super();
		this.no = no;
		this.oriName = oriName;
		this.realName = realName;
		this.filePath = filePath;
		this.fileSize = fileSize;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOriName() {
		return oriName;
	}

	public void setOriName(String oriName) {
		this.oriName = oriName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

}
