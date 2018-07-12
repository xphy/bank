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
import com.orilore.daos.IIcDAO;
import com.orilore.daos.ITradDAO;
import com.orilore.daos.IcDAO;
import com.orilore.daos.TradDAO;
import com.orilore.entitys.Ic;
import com.orilore.entitys.Trad;


@WebServlet("/record.do")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBUtil db = new DBUtil();
	private ITradDAO tradao =new TradDAO();
	private IIcDAO icdao =new IcDAO();
	Connection conn =this.db.getConnection();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out =response.getWriter();
	    String flag =null;
	    String suid = request.getParameter("uid");
	    String scnum = request.getParameter("cnum");
	    int kuid = 0;
	    if(scnum!=null&&!"".equals(scnum)) {
	    	int cnum =Integer.parseInt(scnum);
	    	try {
				Ic ic = this.icdao.selectOne(cnum, conn);
				kuid = ic.getUid();
				if(kuid!=0) {
					if(suid!=null&&!"".equals(suid)) {
						int uid =Integer.parseInt(suid);
						if(uid == kuid) {
							List<Trad> record = this.tradao.select(conn);
							JSONArray jsa =new JSONArray();
							for(Trad t: record) {
								JSONObject jso =new JSONObject();
								jso.put("cnum", t.getCnum());
								jso.put("data", t.getData());
								jso.put("type",t.getType());
								jso.put("money", t.getMoney());
								jsa.add(jso);
							}
							out.print(jsa);
							out.flush();
							out.close();
						}
					}else {
						flag="yhkhcw";
					}
				}else {
					flag="";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
