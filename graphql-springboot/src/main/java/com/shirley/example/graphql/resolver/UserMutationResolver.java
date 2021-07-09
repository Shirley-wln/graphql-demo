package com.shirley.example.graphql.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.shirley.example.graphql.repository.UserRepository;
import com.shirley.graphql.commontypes.Result;
import com.shirley.graphql.commontypes.User;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {

	public Result create(User user) {
		Integer max = 0;
		if (!UserRepository.users.isEmpty()) {
			max = UserRepository.users.keySet().stream().reduce(Integer::max).get();
		}
		user.id = max + 1;
		UserRepository.users.put(user.id, user);
		Result result = new Result();
		result.isSucceed = true;
		return result;
	}
}
