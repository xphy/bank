package com.orilore.daos;
import com.orilore.entitys.Ic;
import java.util.*;
import java.sql.*;
public interface IIcDAO{
	public boolean insert(Ic ic,Connection conn) throws Exception;
	public boolean delete(int id,Connection conn) throws Exception;
	public boolean update(Ic ic,Connection conn) throws Exception;
	public Ic selectOne(int num,Connection conn) throws Exception;
	public Ic select(int num,Connection conn) throws Exception;
	public List<Ic> select(Connection conn) throws Exception;
	public void close() throws Exception;
}