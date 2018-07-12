package com.orilore.daos;
import com.orilore.entitys.Bank;
import java.util.*;
import java.sql.*;
public interface IBankDAO{
	public boolean insert(Bank bank,Connection conn) throws Exception;
	public boolean delete(int id,Connection conn) throws Exception;
	public boolean update(Bank bank,Connection conn) throws Exception;
	public Bank selectOne(int id,Connection conn) throws Exception;
	public List<Bank> select(Connection conn) throws Exception;
	public void close() throws Exception;
}