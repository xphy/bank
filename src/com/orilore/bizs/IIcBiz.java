package com.orilore.bizs;
import com.orilore.entitys.*;
import java.util.*;
public interface IIcBiz{
	public boolean addIc(Ic ic);
	public boolean removeIc(int id);
	public boolean modifyIc(Ic ic);
	public Ic getIc(int id);
	public List<Ic> findIc();
	public void close();
}