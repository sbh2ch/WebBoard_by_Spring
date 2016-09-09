package board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.BoardVO;
import file.FileVO;
import member.MemberVO;
import reply.ReplyVO;

public interface BoardService {
	/**
	 * @return list
	 * @throws Exception
	 * 
	 *             게시물의 목록 정보를 조회하는 기능
	 */
	public List<BoardVO> list() throws Exception;

	/**
	 * @param replyNo
	 * @throws Exception
	 * 
	 *             댓글 삭제
	 */
	public void replyDelete(int replyNo) throws Exception;

	/**
	 * @param r
	 * @throws Exception
	 * 
	 *             댓글 작성
	 */
	public void replyWrite(ReplyVO r) throws Exception;

	/**
	 * @param path
	 * @param req
	 * @return
	 * @throws Exception
	 *             게시글 업데이트
	 */
	public int updateBoard(String path, HttpServletRequest req) throws Exception;

	public int writeBoard(String path, MemberVO user, HttpServletRequest req) throws Exception;

	public void updateReply(ReplyVO r) throws Exception;

	public void deleteBoard(int no, HttpServletRequest req) throws Exception;

	public Map<String, Object> detail(int no) throws Exception;

	public BoardVO updateForm(int no) throws Exception;
	
	public List<ReplyVO> listReply(int no) throws Exception;
}
