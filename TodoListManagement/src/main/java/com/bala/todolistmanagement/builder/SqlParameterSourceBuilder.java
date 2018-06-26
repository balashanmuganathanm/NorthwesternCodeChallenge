package com.bala.todolistmanagement.builder;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class SqlParameterSourceBuilder {

	public SqlParameterSource build(Object object) {
		return new BeanPropertySqlParameterSource(object);
	}
}
