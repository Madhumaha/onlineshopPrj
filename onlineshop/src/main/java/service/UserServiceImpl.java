package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.UserDao;
import DAO.UserDaoImpl;
import Model.Product;
import Model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	   UserDao user;
	public void createu(User u)
	{
		System.out.println("adding user");
		user.adduseru(u);
	}
	public List<User> getAll()
	{
		System.out.println("list of user");
		return user.getall();
	}
}
