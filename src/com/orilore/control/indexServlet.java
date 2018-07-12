package com.orilore.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.alibaba.fastjson.JSONObject;
import com.orilore.bizs.IUserBiz;
import com.orilore.daos.DBUtil;
import com.orilore.daos.IUserDAO;
import com.orilore.daos.UserDAO;
import com.orilore.entitys.MD5;
import com.orilore.entitys.User;


@WebServlet("/index.do")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDAO dao = new UserDAO();
	private DBUtil db = new DBUtil();
	private MD5 md = new MD5();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String yz = request.getParameter("yz");
		HttpSession session = request.getSession();
		String yzse = (String)session.getAttribute("rand");
		String flag =null;
		int uid=0;
		String pw = md.md5crypt(password);
		
		Connection conn =this.db.getConnection();
		if(yz.equals(yzse)) {			
			try {
				User user = this.dao.selectOne(name, conn);
				if(user.getPassword()==null) {
					flag="user is null";
				}else {					
					if(pw.equals(user.getPassword())) {
						flag = "success";
						uid = user.getUid();
					}else {
						flag="failure";
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			 flag ="yzerror";
		}
		JSONObject jj =new JSONObject();
		jj.put("flag", flag);
		jj.put("uid",uid);
				
		out.print(jj);
		out.flush();
		out.close();
	}

}
