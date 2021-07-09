package com.weilina.example.graphql.resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import com.weilina.example.graphql.commontypes.User;
import com.weilina.example.graphql.repository.UserRepository;

@Component
public class UserQueryResolver implements GraphQLQueryResolver {

	public List<User> getUsers() {
		return Lists.newArrayList(UserRepository.users.values());
	}
	
	public User user(int id) {
		return UserRepository.users.get(id);
	}
}
