package com.orilore.daos;
import com.orilore.entitys.Trad;
import java.util.*;
import java.sql.*;
public interface ITradDAO{
	public boolean insert(Trad trad,Connection conn) throws Exception;
	public boolean delete(int id,Connection conn) throws Exception;
	public boolean update(Trad trad,Connection conn) throws Exception;
	public Trad selectOne(int id,Connection conn) throws Exception;
	public List<Trad> select(Connection conn) throws Exception;
	public void close() throws Exception;
}