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
import com.orilore.daos.BankDAO;
import com.orilore.daos.DBUtil;
import com.orilore.daos.IBankDAO;
import com.orilore.daos.IcDAO;
import com.orilore.entitys.Bank;
import com.orilore.entitys.Ic;


@WebServlet("/icrgt.do")
public class icrgtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DBUtil db =new  DBUtil();
    private IBankDAO dao =new BankDAO();
    private IcDAO icdao=new IcDAO();
    
    Connection conn =this.db.getConnection();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		try {
			List<Bank> banks = this.dao.select(conn);
			JSONArray jsa =new JSONArray();
			for(Bank i : banks) {
				JSONObject jso=new JSONObject();
				jso.put("bid",i.getBid());
				jso.put("bname", i.getBname());
				jsa.add(jso);
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
		PrintWriter out = response.getWriter();
		Ic ic=new Ic();
		boolean flag =false;
		String uid = request.getParameter("uid");
		String bank = request.getParameter("bank");
		String num = request.getParameter("icnum");
		String date = request.getParameter("date");
		String money = request.getParameter("money");
		if(uid!=null&&!"".endsWith(uid)) {
			int id=Integer.parseInt(uid);
			ic.setUid(id);
		}
		if(bank!=null&&!"".equals(bank)) {
			int bid=Integer.parseInt(bank);
			ic.setBid(bid);
		}
		if(num!=null&&!"".equals(num)) {
			int cnum = Integer.parseInt(num);
			ic.setCnum(cnum);
		}
		if(date!=null&&!"".equals(date)) {
			ic.setDate(date);
		}
		if(money!=null&&!money.equals("")) {
			int mon = Integer.parseInt(money);
			ic.setMoney(mon);
		}
		try {
			flag = this.icdao.insert(ic, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(flag);
		out.flush();
		out.close();
	}
}
