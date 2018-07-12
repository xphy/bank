package com.orilore.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.orilore.daos.DBUtil;
import com.orilore.daos.IcDAO;
import com.orilore.entitys.Ic;


@WebServlet("/icdel.do")
public class icdelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBUtil db =new  DBUtil();
    private IcDAO icdao=new IcDAO();
    
    Connection conn =this.db.getConnection();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String cid = request.getParameter("cid");
		String uid = request.getParameter("uid");
		int uid1 = Integer.parseInt(uid);
		boolean flag =false;
		PrintWriter out = response.getWriter();
		JSONArray jsa= new JSONArray();
		try {
			if(cid!=null&&!"".equals(cid)) {
				int id =Integer.parseInt(cid);
				flag = this.icdao.delete(id, conn);
				JSONObject jj =new JSONObject();
				jj.put("flag", flag);
				jsa.add(jj);
			}else {				
				List<Ic> ics = this.icdao.select(conn);
				for(Ic i :ics) {
					JSONObject jso =new JSONObject();
					if(uid1==i.getUid()) {						
						jso.put("bname", i.getBname());
						jso.put("cnum", i.getCnum());
						jso.put("money",i.getMoney());
						jso.put("cid", i.getCid());
						jsa.add(jso);
					}
				}
				
			}
			out.print(jsa);
			out.flush();
			out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
