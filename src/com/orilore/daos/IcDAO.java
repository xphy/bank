package com.orilore.daos;
import com.orilore.entitys.Ic;
import java.sql.*;
import java.util.*;
public class IcDAO implements IIcDAO{
	private PreparedStatement pstmt;
	private ResultSet rs;
	public boolean insert(Ic ic,Connection conn) throws Exception{
		String sql="insert into ic(cnum,money,bid,uid,date) values(?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);		pstmt.setInt(1,ic.getCnum());		pstmt.setInt(2,ic.getMoney());		pstmt.setInt(3,ic.getBid());		pstmt.setInt(4,ic.getUid());		pstmt.setString(5,ic.getDate());		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public boolean delete(int id,Connection conn) throws Exception{
		String sql = "delete from ic where cid=?";
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
	public boolean update(Ic ic,Connection conn) throws Exception{;
		String sql="update ic set cnum=?,money=?,bid=?,uid=?,date=? where cid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,ic.getCnum());		pstmt.setInt(2,ic.getMoney());		pstmt.setInt(3,ic.getBid());		pstmt.setInt(4,ic.getUid());		pstmt.setString(5,ic.getDate());		pstmt.setInt(6,ic.getCid());		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public Ic selectOne(int num,Connection conn) throws Exception{
		String sql = "select * from ic where cnum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,num);		rs = pstmt.executeQuery();
		Ic ic = new Ic();
		if(rs.next()){
			ic.setCid(rs.getInt("cid"));
			ic.setCnum(rs.getInt("cnum"));
			ic.setMoney(rs.getInt("money"));
			ic.setBid(rs.getInt("bid"));
			ic.setUid(rs.getInt("uid"));
			ic.setDate(rs.getString("date"));
		}
		this.close();
		return ic;
	}
	public List<Ic> select(Connection conn) throws Exception{
		String sql = "select cid,bname,cnum,money,uid,date,a.bid  from ic as a left join bank as b on a.bid=b.bid";
		pstmt = conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		List<Ic> ics = new ArrayList<Ic>();
		while(rs.next()){
			Ic ic = new Ic();
			ic.setCid(rs.getInt("cid"));
			ic.setCnum(rs.getInt("cnum"));
			ic.setMoney(rs.getInt("money"));
			ic.setBname(rs.getString("bname"));
			ic.setBid(rs.getInt("a.bid"));
			ic.setUid(rs.getInt("uid"));
			ic.setDate(rs.getString("date"));
			ics.add(ic);
		}
		this.close();
		return ics;
	}
	public void close() throws Exception{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	@Override
	public Ic select(int num, Connection conn) throws Exception {
		
		String sql = "select cid,cnum,money,a.bid,uid,date,bname from ic as a left join bank as b  on a.bid=b.bid where cnum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,num);
		rs = pstmt.executeQuery();
		Ic ic = new Ic();
		if(rs.next()){
			ic.setCid(rs.getInt("cid"));
			ic.setCnum(rs.getInt("cnum"));
			ic.setMoney(rs.getInt("money"));
			ic.setBid(rs.getInt("bid"));
			ic.setUid(rs.getInt("uid"));
			ic.setDate(rs.getString("date"));
			ic.setBname(rs.getString("bname"));
		}
		this.close();
		return ic;
	}
}