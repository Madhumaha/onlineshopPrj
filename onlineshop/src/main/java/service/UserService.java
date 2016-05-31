package service;


import java.util.List;

import Model.Product;
import Model.User;

public interface UserService {
	public void createu(User u);
	public List<User> getAll();
}
