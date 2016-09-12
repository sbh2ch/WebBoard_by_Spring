package kr.co.mlec.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/down")
public class Download extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getParameter("path");
		String realName = req.getParameter("realName");
		String oriName = req.getParameter("oriName");
		String draw = req.getParameter("draw");

		String uploadPath = req.getServletContext().getRealPath("/upload");

		File f = new File(uploadPath + path + realName);
		
		if(draw != null && draw.equalsIgnoreCase("y")){
			resp.setHeader("Content-Type", "image/jpeg");
		} else {
			resp.setHeader("Content-Type", "application/octet-stream");
			String fName = new String(oriName.getBytes("utf-8"), "8859_1");
			resp.setHeader("Content-Disposition", "attachment;filename="+fName);
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Content-Length", String.valueOf(f.length()));
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		
		int ch;
		while((ch = bis.read())!= -1)
			bos.write(ch);
		
		
		bis.close();
		bos.close();
	}

}
