package kr.co.mlec.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import framework.WebUtil;
import kr.co.mlec.board.BoardDAO;
import kr.co.mlec.board.BoardVO;
import kr.co.mlec.file.FileDAO;
import kr.co.mlec.file.FileVO;
import kr.co.mlec.member.MemberDAO;
import kr.co.mlec.member.MemberVO;
import kr.co.mlec.reply.ReplyDAO;
import kr.co.mlec.reply.ReplyVO;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bDao;
	private ReplyDAO rDao;
	private FileDAO fDao;
	private MemberDAO mDao;

	public BoardServiceImpl() {
		bDao = new BoardDAO();
		rDao = new ReplyDAO();
		fDao = new FileDAO();
		mDao = new MemberDAO();
	}

	@Override
	public List<BoardVO> list() throws Exception {
		List<BoardVO> bList = bDao.selectAll();

		return bList;
	}

	@Override
	public void replyDelete(int replyNo) throws Exception {
		rDao.delete(replyNo);
	}

	@Override
	public void replyWrite(ReplyVO r) throws Exception {
		rDao.insert(r);
	}

	@Override
	public Map<String, Object> detail(int no) {
		Map<String, Object> models = new HashMap<>();
		models.put("f", fDao.select(no));
		models.put("b", bDao.selectOne(no));

		return models;
	}

	@Override
	public List<ReplyVO> listReply(int no) throws Exception {
		return rDao.selectAll(no);
	}

	@Override
	public int updateBoard(String path, HttpServletRequest req) throws Exception {

		int no = Integer.parseInt(req.getParameter("no"));
		BoardVO board = (BoardVO) WebUtil.getParamToVO(BoardVO.class, req);

		bDao.update(board);

		return no;
	}

	public int writeBoard(String path, MemberVO user, HttpServletRequest req) throws Exception {
		String filePath = new SimpleDateFormat("\\yyyy\\MM\\dd\\").format(new Date());
		File dir = new File(path + filePath);

		if (!dir.exists())
			dir.mkdirs();

		MultipartRequest mRequest = new MultipartRequest(req, path + filePath, 1024 * 1024 * 50, "utf-8", new DefaultFileRenamePolicy());

		String title = mRequest.getParameter("title");
		String content = mRequest.getParameter("content");

		int no = bDao.insert(new BoardVO(title, user.getName(), content, user.getEmail()));

		File newFile = mRequest.getFile("attachFile");

		if (newFile != null) {
			fDao.insert(new FileVO(no, mRequest.getOriginalFileName("attachFile"), mRequest.getFilesystemName("attachFile"), filePath, (int) newFile.length()));
		}

		return no;
	}

	@Override
	public void updateReply(ReplyVO r) throws Exception {
		rDao.update(r);
	}

	@Override
	public void deleteBoard(int no, HttpServletRequest req) throws Exception {
		bDao.delete(no);
		rDao.delete(no);

		FileVO f = fDao.select(no);
		if (f != null)
			fDao.delete(f, req.getServletContext());
	}

	@Override
	public BoardVO updateForm(int no) throws Exception {
		return bDao.selectOne(no);
	}

}
