package com.zti.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.zti.model.User;

public class UserSerializer extends StdSerializer<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserSerializer() {
		this(null);
	}

	public UserSerializer(Class<User> t) {
		super(t);
	}

	@Override
	public void serialize(User user, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		jgen.writeStartObject();
		jgen.writeNumberField("id", user.getId());
		jgen.writeStringField("firstname", user.getFirstname());
		jgen.writeStringField("lastname", user.getLastname());
		jgen.writeStringField("email", user.getEmail());
		jgen.writeStringField("username", user.getEmail());
		jgen.writeObjectField("roles", user.getRoles());
		jgen.writeEndObject();
	}

}
