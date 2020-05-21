package com.example.demo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSourceResolver extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		if(SchemaContextHolder.getSchemaType() == null) {
			return "datasource1";
		}else if(SchemaContextHolder.getSchemaType() == SchemaType.DATA1) {
			return "datasource1";
		}else if(SchemaContextHolder.getSchemaType() == SchemaType.DATA2) {
			return "datasource2";
		}else {
			return "datasource1";
		}
	}
}
