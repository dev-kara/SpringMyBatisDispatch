package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.entity.Test;
import com.example.service.TestService;
import com.example.utils.DbContext;

public class DemoApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		try {
			System.out.println("##########ここはSlave:" + DbContext.getDbName());
			TestService s = ctx.getBean(TestService.class);
			for (Test t : s.findById(null)) {
				System.out.println("S##" + t.getId() + "::" + t.getName());
			}

			System.out.println("##########ここはMaster:" + DbContext.getDbName());
			// s = ctx.getBean(TestService.class);
			{
				s.insert(new Test("test"));
			}
			System.out.println("##########ここはSlave:" + DbContext.getDbName());
			// s = ctx.getBean(TestService.class);
			for (Test t : s.findById(null)) {
				System.out.println("S##" + t.getId() + "::" + t.getName());
			}

			System.out.println("##########ここはMaster確認:" + DbContext.getDbName());
			DbContext.writeOn();
			for (Test t : s.findById(null)) {
				System.out.println("M##" + t.getId() + "::" + t.getName());
			}
			DbContext.writeOff();

		} finally {
			ctx.close();
		}
	}
}
