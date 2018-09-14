package com.demohot.choose.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demohot.choose.model.Classroom;

public interface ClassroomMapper {
	void insert(Classroom classroom);

	void delete(Classroom classroom);

	Classroom get(@Param("id") Integer id);

	List<Classroom> list();
}
