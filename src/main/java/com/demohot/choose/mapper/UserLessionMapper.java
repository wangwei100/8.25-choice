package com.demohot.choose.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demohot.choose.model.UserLession;

public interface UserLessionMapper {
	void insert(UserLession userLession);

	void delete(UserLession userLession);

	UserLession get(@Param("id") Integer id);

	UserLession getByUserIdLessionId(@Param("user_id") Integer user_id, @Param("lession_id") Integer lession_id);

	List<UserLession> getById(Integer id);

	int countByUserId(@Param("user_id") Integer user_id);

	int getTotalRecord();
}
