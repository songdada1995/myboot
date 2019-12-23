package com.spbt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybootApplicationTests {

	private Logger logger = LoggerFactory.getLogger(MybootApplicationTests.class);

	@Test
	public void contextLoads() {
		try{
			logger.info("测试记录日志");
			System.out.println(1 / 0);
		} catch (Exception e){
			logger.error("异常日志: " + e.getMessage());
		}

	}

}
