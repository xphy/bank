package com.orilore.daos;
import com.orilore.entitys.Bank;
import java.sql.*;
import java.util.*;
public class BankDAO implements IBankDAO{
	private PreparedStatement pstmt;
	private ResultSet rs;
	public boolean insert(Bank bank,Connection conn) throws Exception{
		String sql="insert into bank(bname) values(?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,bank.getBname());		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public boolean delete(int id,Connection conn) throws Exception{
		String sql = "delete from bank where bid=?";
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
	public boolean update(Bank bank,Connection conn) throws Exception{;
		String sql="update bank set bname=? where bid=?";
		pstmt = conn.prepareStatement(sql);		pstmt.setString(1,bank.getBname());		if(pstmt.executeUpdate()>0){
			this.close();
			return true;
		}else{
			this.close();
			return false;
		}
	}
	public Bank selectOne(int id,Connection conn) throws Exception{
		String sql = "select * from bank where bid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,id);		rs = pstmt.executeQuery();
		Bank bank = new Bank();
		if(rs.next()){
			bank.setBid(rs.getInt("bid"));
			bank.setBname(rs.getString("bname"));
			bank.setBid(rs.getInt("id"));
		}
		this.close();
		return bank;
	}
	public List<Bank> select(Connection conn) throws Exception{
		String sql = "select * from bank";
		pstmt = conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		List<Bank> banks = new ArrayList<Bank>();
		while(rs.next()){
			Bank bank = new Bank();
			bank.setBid(rs.getInt("bid"));
			bank.setBname(rs.getString("bname"));
			banks.add(bank);
		}
		this.close();
		return banks;
	}
	public void close() throws Exception{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
}