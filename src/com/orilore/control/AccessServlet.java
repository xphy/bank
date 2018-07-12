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
import com.orilore.daos.IIcDAO;
import com.orilore.daos.ITradDAO;
import com.orilore.daos.IcDAO;
import com.orilore.daos.TradDAO;
import com.orilore.entitys.Ic;
import com.orilore.entitys.Trad;

@WebServlet("/deposit.do")
public class AccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IIcDAO icdao =new IcDAO();
	private ITradDAO tradao =new TradDAO();
	private DBUtil db = new DBUtil();
	private Connection conn =this.db.getConnection();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out =response.getWriter();
		try {
			List<Ic> ics = this.icdao.select(conn);
			JSONArray jsa =new JSONArray();
			for(Ic ic: ics ) {
				JSONObject jso =new JSONObject();
				jso.put("cid", ic.getCid());
				jso.put("cnum", ic.getCnum());
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
	    PrintWriter out =response.getWriter();
	    Ic ic=new Ic();
	    Trad tra=new Trad();
	    String flag =null;
	    String uid = request.getParameter("uid");
		String num = request.getParameter("icnum");
		String type = request.getParameter("type");
		String date = request.getParameter("date");
		String money = request.getParameter("money");
		if(uid!=null&&!"".endsWith(uid)) {
			int id=Integer.parseInt(uid);
			ic.setUid(id);
		}
		if(type!=null&&!"".endsWith(type)) {
			int tp=Integer.parseInt(type);
			tra.setType(tp);
		}
		if(date!=null&&!"".equals(date)) {
			ic.setDate(date);
			tra.setData(date);
		}
	    try {
	    	if(num!=null&&!"".equals(num)) {
	    		int cnum = Integer.parseInt(num);
	    		ic.setCnum(cnum);
	    		Ic icone = this.icdao.selectOne(cnum, conn);
	    		ic.setBid(icone.getBid());
	    		ic.setCid(icone.getCid());
	    		tra.setCid(icone.getCid());
	    		if(money!=null&&!money.equals("")) {
	    			tra.setMoney(money);
	    			int mon = Integer.parseInt(money);
	    			int mone=0;
	    			if(type.equals("1")) {
	    				mone =mon + icone.getMoney();
	    				ic.setMoney(mone);
	    				if(this.icdao.update(ic, conn)&&this.tradao.insert(tra, conn)) {
	    		    		flag="success";
	    		    	}else {
	    		    		flag="failure";
	    		    	}
	    			}else {
	    				if(icone.getMoney()==0) {
	    					flag="yew";
	    				}else {
	    					mone =icone.getMoney() - mon;
	    					if(mone < 0) {
	    						ic.setMoney(icone.getMoney());
	    						flag="yebz";
	    					}else {
	    						ic.setMoney(mone);
	    						if(this.icdao.update(ic, conn)&&this.tradao.insert(tra, conn)) {
	    				    		flag="success";
	    				    	}else {
	    				    		flag="failure";
	    				    	}
	    					}
	    				}
	    				
	    			}
	    		}
	    	}
	    	
	    	out.print(flag);
	    	out.flush();
	    	out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
