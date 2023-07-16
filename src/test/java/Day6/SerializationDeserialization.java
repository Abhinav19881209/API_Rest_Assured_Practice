package Day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDeserialization {
	
	@Test(priority = 1)
	void convertJavaObjToJSON() throws JsonProcessingException {
			
			Student stu = new Student();
			
			stu.setName("Abhinav");
			stu.setMob("0987654321");
			stu.setLocation("Pune");	
			String courses[] = {"JAVA","Python"};		
			stu.setCourses(courses);
			
			ObjectMapper objmap = new ObjectMapper();
			String jdata = objmap.writerWithDefaultPrettyPrinter().writeValueAsString(stu);
			
			System.out.println(jdata);
			
			/*
			 * 
			 {
  "name" : "Abhinav",
  "location" : "Pune",
  "mob" : "0987654321",
  "courses" : [ "JAVA", "Python" ]
}
*/			
	}
	
	@Test (priority = 2)
	void convertJSONToPOJO() throws JsonMappingException, JsonProcessingException {
			
		String strjson = "{\r\n"
				+ "  \"name\" : \"Akshay\",\r\n"
				+ "  \"location\" : \"Mumbai\",\r\n"
				+ "  \"mob\" : \"654587\",\r\n"
				+ "  \"courses\" : [ \"COBOL\", \"Perl\" ]\r\n"
				+ "}";
		
		ObjectMapper objmap = new ObjectMapper();
		Student pojodata = objmap.readValue(strjson, Student.class);
		
		System.out.println(pojodata.getName());
		System.out.println(pojodata.getMob());
		System.out.println(pojodata.getLocation());
		String str [] =pojodata.getCourses();
		System.out.println(str[0]);
		System.out.println(str[1]);

	}

}
