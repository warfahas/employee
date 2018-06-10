package org.launchcode.employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.launchcode.employee.models.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeApplicationTests {
@Autowired
public SmsService smsService;
	@Test
	public void contextLoads() {
		smsService.sendSms("Hi", "+1");
	}

}
