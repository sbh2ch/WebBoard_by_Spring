package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;

@WebServlet("/login/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDAO mDao = new MemberDAO();
		
		String email = req.getParameter("email");
		String pw = req.getParameter("pw");
		
		MemberVO user = mDao.selectOne(email);
		
		if(user != null && user.getPw().equals(pw)){
			req.getSession().setAttribute("user", user);
		}
		
		resp.sendRedirect("/Test04/board/list.do");
	}
}
