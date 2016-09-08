package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;

public class BoardDAO {
	private SqlSession session;

	public BoardDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public List<BoardVO> selectAll() {
		return session.selectList("myBoard.selectAll");
	}

	public BoardVO selectOne(int no) {
		return session.selectOne("myBoard.selectOne", no);
	}

	public int insert(BoardVO b) {
		session.insert("myBoard.insert", b);
		session.commit();
		
		return b.getNo();
	}

	public void delete(int no) {
		session.delete("myBoard.delete", no);
		session.commit();
	}

	public void update(BoardVO b) {
		session.update("myBoard.update", b);
		session.commit();
	}

}
