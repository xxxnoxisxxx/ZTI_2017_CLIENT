package com.zti.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Klasa odpowiedzialna za konwersje daty - do obsługi JSON
 * 
 * @author PawełN
 *
 */
@Converter
public class LocalDateTimeConverter implements AttributeConverter<java.time.LocalDateTime, java.sql.Timestamp> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
	 * Object)
	 */
	@Override
	public java.sql.Timestamp convertToDatabaseColumn(java.time.LocalDateTime entityValue) {
		return entityValue == null ? null : java.sql.Timestamp.valueOf(entityValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	@Override
	public java.time.LocalDateTime convertToEntityAttribute(java.sql.Timestamp dbValue) {
		return dbValue == null ? null : dbValue.toLocalDateTime();
	}
}