package org.singhindustry;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.singhindustry.entities.Employee;
import org.singhindustry.entities.Kharcha;
import org.singhindustry.entities.Monthly_staff;
import org.singhindustry.services.EmployeeService;
import org.singhindustry.services.KharchaService;
import org.singhindustry.services.Monthly_staffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SinghIndustryApplicationTests {

	@Autowired
	private KharchaService kharchaService;
	
	@Autowired
	private Monthly_staffService monthly_staffService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Before
    public void initDb(){

		{
//			Employee employee = new Employee(1,"Krijan","03/15/2018",24,LocalDateTime.now(),LocalDateTime.now());
//        	employeeService.save(employee);
//        	
//			Kharcha kharcha = new Kharcha(1,"02/13/208",300,LocalDateTime.now(),LocalDateTime.now());
//			kharchaService.save(kharcha);
//			
//			List<Kharcha> list = new ArrayList<Kharcha>();
//			list.add(kharcha);
//			
//        	Monthly_staff monthly_staff = new Monthly_staff(1,employee,list,1000,500,200,LocalDateTime.now(),LocalDateTime.now());
//        	monthly_staffService.save(monthly_staff);
		}
     
    }
	
//	 @Test
//	    public void testUser(){
//	        Employee employee =employeeService.findemployee(1);
//	        assertNotNull(employee);
//
//	        Kharcha kharcha =kharchaService.findkharcha(1);
//	        assertNotNull(kharcha);
//	        
//	        
//	    }
	 
//	 @Test
//	 public void testMonthly() {
//		 Monthly_staff monthly_staff =monthly_staffService.findmonthly_staff(1);
//	        assertNotNull(monthly_staff);
//	 }
	 

}