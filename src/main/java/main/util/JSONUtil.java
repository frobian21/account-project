package main.util;

import javax.enterprise.inject.Default;
import com.fasterxml.jackson.databind.ObjectMapper;

@Default
public class JSONUtil {
	public JSONUtil() {

	}

	private ObjectMapper mapper = new ObjectMapper();

	public String toJSON(Object obj) {
		try {
			return this.mapper.writeValueAsString(obj);
		} catch (
		Exception e) {
			return e.toString();
		}
	}
	
	public <T> T fromJSON(String json, Class<T> clazz) {
		try {
			return this.mapper.readValue(json, clazz);
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
