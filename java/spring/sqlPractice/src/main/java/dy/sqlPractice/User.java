package dy.sqlPractice;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;

import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class User {
	@Id
	@GeneratedValue
	private int userId;
	private String username;
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User(int userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
