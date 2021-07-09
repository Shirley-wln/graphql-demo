package com.weilina.example.graphql.repository;

import java.util.Map;

import com.google.common.collect.Maps;
import com.weilina.example.graphql.commontypes.User;

public class UserRepository {

	public static Map<Integer, User> users = Maps.newHashMap();
}
