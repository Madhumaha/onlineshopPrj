package DAO;


import java.util.List;

import Model.User;


public interface UserDao {
	public void adduseru(User u);
	public List<User> getall();
}
