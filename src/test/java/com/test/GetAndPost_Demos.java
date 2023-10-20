package com.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPost_Demos {
	
	
	@Test
	public void testGet() {
		
		baseURI="https://reqres.in/api/";
		
	    given().
	    get("users?page=2").
	    then().
	    statusCode(200).
	    body("data[4].first_name",equalTo("George")).
	    body("data.first_name", hasItems("George","Rachel"));
		
		
	}
	
	@Test
	public void testPost() {
		
		Map<String, Object> map=new HashMap<String, Object>();
		//map.put( "name", "morpheus");
		//map.put( "job", "teacher");
		//System.out.println(map);
		
		JSONObject request=new JSONObject();
		
		request.put("name", "morpheus");
		request.put("job", "teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api/";
		
		given().
		  header("Content-Type", "application/json").
		  body(request.toJSONString()).	
		when().
		  post("/users").
		then().
	      statusCode(201).log().all();
	}

}
