package com.orilore.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.orilore.daos.DBUtil;
import com.orilore.daos.IUserDAO;
import com.orilore.daos.UserDAO;
import com.orilore.entitys.MD5;
import com.orilore.entitys.User;


@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBUtil db = new DBUtil();
	private IUserDAO dao=new UserDAO();
	private User bean=new User();
	private MD5 md = new  MD5();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String flag=null;
		PrintWriter out=response.getWriter();
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		if(name!=null&&!"".equals(name)) {
			bean.setUname(name);
		}
		if(pwd!=null&&!"".equals(pwd)) {
			String pw = md.md5crypt(pwd);
			bean.setPassword(pw);
		}
		Connection conn = this.db.getConnection();
		try {
			User bean = this.dao.selectOne(name, conn);
			if(bean.getPassword()==null) {				
				  if(this.dao.insert(bean, conn))flag="success";
				  
			}else {
				flag="failure";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(flag);
		out.flush();
		out.close();
		
	}

}
