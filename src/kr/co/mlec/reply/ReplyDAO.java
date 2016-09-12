package kr.co.mlec.reply;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;

public class ReplyDAO {
	private SqlSession session;

	public ReplyDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public void delete(int no) {
		session.delete("myReply.delete", no);
		session.commit();
	}

	public List<ReplyVO> selectAll(int no) {
		return session.selectList("myReply.selectAll", no);
	}

	public void insert(ReplyVO r) {
		session.insert("myReply.insert", r);
		session.commit();
	}

	public void update(ReplyVO r) {
		session.update("myReply.update", r);
		session.commit();
	}

}
