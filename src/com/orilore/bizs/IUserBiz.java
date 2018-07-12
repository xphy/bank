package com.orilore.bizs;
import com.orilore.entitys.*;
import java.util.*;
public interface IUserBiz{
	public boolean addUser(User user);
	public boolean removeUser(int id);
	public boolean modifyUser(User user);
	public User getUser(int id);
	public List<User> findUser();
	public void close();
}