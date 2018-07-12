package com.orilore.bizs;
import com.orilore.entitys.*;
import java.util.*;
public interface IBankBiz{
	public boolean addBank(Bank bank);
	public boolean removeBank(int id);
	public boolean modifyBank(Bank bank);
	public Bank getBank(int id);
	public List<Bank> findBank();
	public void close();
}