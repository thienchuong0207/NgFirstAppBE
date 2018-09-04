package ng.first.app.be.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gender Enumeration
 * @author giraffefamily
 *
 */
public enum GenderEnum {

	FEMALE(0),
	MALE(1);
	
	@JsonValue
	private final Integer value;
	
	private GenderEnum(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return this.value;
	}
}
