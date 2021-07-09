package com.shirley.example.graphql.resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import com.shirley.graphql.commontypes.Service;

@Component
public class ServiceQueryResolver implements GraphQLQueryResolver {
	
	public List<Service> getServices(){
		return Lists.newArrayList();
	}
}
