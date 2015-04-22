package dao;

import bean.User;

public interface UserDAO {
	
	public void createUser(String login, String password);

	public void deleteUser(String login);

	public User getUser(String login);

	public String getUID(String user);
}
