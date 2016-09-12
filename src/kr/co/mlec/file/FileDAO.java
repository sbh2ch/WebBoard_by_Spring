package kr.co.mlec.file;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;

public class FileDAO {
	private SqlSession session;

	public FileDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public void insert(FileVO f){
		session.insert("myFile.insert", f);
		session.commit();
	}
	
	public FileVO select(int no){
		return session.selectOne("myFile.selectOne", no);
	}

	public void delete(FileVO f, ServletContext servletContext) {
		File delFile = new File(servletContext.getRealPath("/upload")+f.getFilePath()+f.getRealName());
		delFile.delete();
		
		session.delete("myFile.delete", f.getNo());
		session.commit();
	}

}
