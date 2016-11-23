package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Test;
import com.example.mapper.TestMapper;
import com.example.utils.DbContext;

@Service
public class TestService {

	@Autowired
	private TestMapper testMapper;

	public List<Test> findById(Integer id) {
		return testMapper.select(id);
	}

	public void insert(Test e) {
		try {
			DbContext.writeOn();

			testMapper.insert(e);

		} finally {
			DbContext.writeOff();
		}
	}

}
