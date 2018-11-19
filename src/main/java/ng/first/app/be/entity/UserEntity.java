package ng.first.app.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User Class
 * @author giraffefamily
 *
 */
@Entity
@Table(name = "users")
public class UserEntity {

	/* Properties */
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
	/* Getters and Setters */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
