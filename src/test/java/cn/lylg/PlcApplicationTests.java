package cn.lylg;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlcApplicationTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void contextLoads() {
		String date="2015-08-01" ;
		String newdate=     date.replaceAll("-", ""); //20150801
		StringBuffer sb= new StringBuffer(newdate);

		String gd="HtpYS" ;

		for(int i=0;i<gd.length()*2;i=i+2){
			sb.insert(i, gd.charAt(i/2));
		}
		String  a1=sb.substring(0, 1);
		String  a2=sb.substring(1,2);
		String  a8=sb.substring(7, 8);
		String  a10=sb.substring(9,10);
		sb.replace(0, 1, a8).replace(7, 8, a1)
				.replace(1, 2, a10).replace(9, 10, a2);
		System.out.println(sb.toString());


	}

}
