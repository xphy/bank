package com.orilore.daos;
import com.orilore.entitys.Trad;
import java.sql.*;
import java.util.*;
public class TradDAO implements ITradDAO{
	private PreparedStatement pstmt;
	private ResultSet rs;
	public boolean insert(Trad trad,Connection conn) throws Exception{
		String sql="insert into trad(type,money,data,cid) values(?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public boolean delete(int id,Connection conn) throws Exception{
		String sql = "delete from trad where tid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);
		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public boolean update(Trad trad,Connection conn) throws Exception{;
		String sql="update trad set type=?,money=?,data=?,cid=? where tid=?";
		pstmt = conn.prepareStatement(sql);
			this.close();
			return true;
		}else{

			return false;
		}
	}
	public Trad selectOne(int id,Connection conn) throws Exception{
		String sql = "select * from trad where tid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);
		Trad trad = new Trad();
		if(rs.next()){
			trad.setTid(rs.getInt("tid"));
			trad.setType(rs.getInt("type"));
			trad.setMoney(rs.getString("money"));
			trad.setData(rs.getString("data"));
			trad.setCid(rs.getInt("cid"));
		}
		this.close();
		return trad;
	}
	public List<Trad> select(Connection conn) throws Exception{
		String sql = "select tid,type,a.money,data,a.cid,cnum from trad as a left join ic as b on a.cid = b.cid";
		pstmt = conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		List<Trad> trads = new ArrayList<Trad>();
		while(rs.next()){
			Trad trad = new Trad();
			trad.setTid(rs.getInt("tid"));
			trad.setType(rs.getInt("type"));
			trad.setMoney(rs.getString("a.money"));
			trad.setData(rs.getString("data"));
			trad.setCid(rs.getInt("cid"));
			trad.setCnum(rs.getInt("cnum"));
			trads.add(trad);
		}
		this.close();
		return trads;
	}
	public void close() throws Exception{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
}