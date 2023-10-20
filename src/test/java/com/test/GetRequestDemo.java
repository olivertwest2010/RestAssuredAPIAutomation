package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetRequestDemo {

	@Test
	public void test1() {
		
		Response response=get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getStatusLine());
		
		
		int statusCode=response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	}
	
	
	@Test
	public void test2() {
		
		baseURI="https://reqres.in/api";
		
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data.id[1]",equalTo(8))
		.log().all();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
