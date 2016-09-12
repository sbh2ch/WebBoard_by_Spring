package kr.co.mlec.member;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;

public class MemberDAO {
	private SqlSession session;

	public MemberDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}
	
	public MemberVO selectOne(String email){
		return session.selectOne("myMember.selectOne", email);
	}
	
	
}
