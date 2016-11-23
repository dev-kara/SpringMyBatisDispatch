package com.example.mapper;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.Test;

@Mapper
@Resource(name = "mapperScannerConfigurer")
public interface TestMapper {

	List<Test> select(@Param("id") Integer id);

	int insert(Test e);

	int update(Test e);
}
