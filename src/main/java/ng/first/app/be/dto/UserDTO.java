package ng.first.app.be.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User DTO
 * @author giraffefamily
 *
 */
@JsonInclude(value = Include.ALWAYS)
public class UserDTO {

	/* Properties */
	@JsonProperty(value = "id")
	private String id;
	@JsonProperty(value = "username")
	private String username;
	@JsonProperty(value = "password")
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
