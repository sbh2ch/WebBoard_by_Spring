package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {
	private String[] pages;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String path = request.getServletPath();
		boolean chk = false;

		if (request.getSession().getAttribute("user") == null) {
			for (String uri : pages) {
				if (path.endsWith(uri))
					chk = true;
			}
		} else {
			chk = true;
		}

		if (chk)
			chain.doFilter(req, res);
		else
			response.sendRedirect("/Test04/board/list");
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		pages = fc.getInitParameter("pages").split(";");
	}

}
