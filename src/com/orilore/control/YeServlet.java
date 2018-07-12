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
import com.orilore.daos.IIcDAO;
import com.orilore.daos.ITradDAO;
import com.orilore.daos.IcDAO;
import com.orilore.daos.TradDAO;
import com.orilore.entitys.Ic;


@WebServlet("/ye.do")
public class YeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DBUtil db = new DBUtil();
	
	private IIcDAO icdao =new IcDAO();
	Connection conn =this.db.getConnection();   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out =response.getWriter();
	    String suid = request.getParameter("uid");
	    String scnum = request.getParameter("cnum");
	    if(scnum!=null&&!"".equals(scnum)) {
	    	int num = Integer.parseInt(scnum);
	    	try {
				Ic ic = this.icdao.select(num, conn);
				JSONObject jso =new JSONObject();
				jso.put("bname", ic.getBname());
				jso.put("cnum",ic.getCnum());
				jso.put("money",ic.getMoney());
				out.print(jso);
				out.flush();
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
