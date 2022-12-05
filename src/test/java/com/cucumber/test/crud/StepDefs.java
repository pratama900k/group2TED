package com.cucumber.test.crud;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat; 

import java.io.IOException; 
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
 
import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefs extends SpringIntegrationTest{
	@Given("^Mengatur api karyawan dengan metode POST$")
    public void setPostEndpoint(){
        addURI = "http://localhost:8081/api/employee/";
        System.out.println("Add URL :"+addURI);
    }
	
	@When ("^Mengirim permintaan HTTP POST$")
    public void sendPostRequest(){ 
		try {
			executePost(addURI,"{\"name\":\"joni\",\"phone\":\"092382832\",\"job\":\"Karyawan\"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Then("^Menerima Respon metode POST yang valid$")
	public void cekPostBody() throws Throwable { 
		JsonNode root = objectMapper.readTree(latestResponse.getBody());  
		id = root.path("id").asText();
	    assertThat(root.path("name").asText(), is("joni"));
	}

	@And("^Menerima kode respons HTTP POST yang valid yaitu (\\d+)$")
	public void cekPostStatus(int statusCode) throws Throwable {
		HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode(); 
        System.out.println("Add URL :"+currentStatusCode.value());
        assertThat(currentStatusCode.value(), is(statusCode));
		Assert.isTrue(currentStatusCode.value()==statusCode);
	}
	
//	UPDATE 
	@Given("^Mengatur api karyawan dengan metode PUT$")
    public void setUPDATEEndpoint(){
        addURI = "http://localhost:8081/api/employee/update/"+id;
        System.out.println("Add URL :"+addURI);
    }
	
	@When ("^Mengirim permintaan HTTP PUT$")
    public void sendUPDATERequest(){ 
		try {
			executePut(addURI,"{\"name\":\"jonis\",\"phone\":\"092382832\",\"job\":\"Karyawan\"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Then("^Menerima Respon metode PUT yang valid$")
	public void cekUPDATEBody() throws Throwable { 
		JsonNode root = objectMapper.readTree(latestResponse.getBody());  
	    assertThat(root.path("name").asText(), is("jonis"));
	}

	@And("^Menerima kode respons HTTP PUT yang valid yaitu (\\d+)$")
	public void cekUPDATEStatus(int statusCode) throws Throwable {
		HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode(); 
        System.out.println("Add URL :"+currentStatusCode.value());
        assertThat(currentStatusCode.value(), is(statusCode));
		Assert.isTrue(currentStatusCode.value()==statusCode);
	}
	
//	GET API EMPLOYEE
	 
	@Given("^Mengatur api karyawan dengan metode GET$")
    public void setGETEndpoint(){
        addURI = "http://localhost:8081/api/employee";
        System.out.println("Add URL :"+addURI);
    }
	
	@When ("^Mengirim permintaan HTTP GET$")
    public void sendGETRequest(){ 
		try {
			executeGet(addURI);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Then("^Menerima kode respons HTTP GET yang valid yaitu (\\d+)$")
	public void cekGETStatus(int statusCode) throws Throwable { 
		HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();  
        assertThat(currentStatusCode.value(), is(statusCode)); 
	}
 
	
//	DELETE API EMPLOYEE
	@Given("^Mengatur api karyawan dengan metode DELETE$")
    public void setDELETEEndpoint(){
        addURI = "http://localhost:8081/api/employee/delete/"+id;
        System.out.println("Add URL :"+addURI);
    }
	
	@When ("^Mengirim permintaan HTTP DELETE$")
    public void sendDELETERequest(){ 
		try {
			executeDelete(addURI);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Then("^Menerima kode respons HTTP DELETE yang valid yaitu (\\d+)$")
	public void cekDELETEStatus(int statusCode) throws Throwable { 
		HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();  
        assertThat(currentStatusCode.value(), is(statusCode)); 
	} 
}
