package com.orilore.bizs;
import com.orilore.entitys.*;
import java.util.*;
public interface ITradBiz{
	public boolean addTrad(Trad trad);
	public boolean removeTrad(int id);
	public boolean modifyTrad(Trad trad);
	public Trad getTrad(int id);
	public List<Trad> findTrad();
	public void close();
}