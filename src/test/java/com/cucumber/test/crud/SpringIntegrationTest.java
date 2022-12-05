package com.cucumber.test.crud;

import java.io.IOException; 
import java.util.HashMap;
import java.util.Map;
 
import org.springframework.http.HttpMethod; 
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse; 
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.cucumber.test.crud.model.Employee; 
import com.fasterxml.jackson.databind.ObjectMapper; 

import io.cucumber.spring.CucumberContextConfiguration; 
import org.springframework.boot.test.context.SpringBootTest; 
 
@CucumberContextConfiguration
@SpringBootTest
class SpringIntegrationTest {
	protected static ResponseResults latestResponse = null; 
	protected final ObjectMapper objectMapper = new ObjectMapper();
	protected static ResponseEntity<Employee> response= null;
	protected static String id = null;

	protected static String addURI = "";

    protected RestTemplate restTemplate = null;
    
    protected void executeGet(String url) throws IOException
    { 
        final Map<String,String> headers = new HashMap<>();
        headers.put("Accept","application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();
        if (restTemplate == null)
        {
            restTemplate = new RestTemplate();
        }
        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate.execute(
    	  url,
	      HttpMethod.GET,
	      requestCallback,
	      new ResponseExtractor<ResponseResults>()
	      {
	          @Override
	          public ResponseResults extractData(ClientHttpResponse response) throws IOException
	          {
	              if (errorHandler.hadError)
	              {
	                  return (errorHandler.getResults());
	              }
	              else
	              {
	                  return (new ResponseResults(response));
	              }
	          }
	      });

    }
    
    protected void executePost(String url,String data) throws IOException
    { 
    	 final Map<String,String> headers = new HashMap<>();
         headers.put("Content-Type","application/json");
         headers.put("Accept","application/json");
         final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
         requestCallback.setBody(data);
         final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();
         if (restTemplate == null)
         {
             restTemplate = new RestTemplate();
         }
         restTemplate.setErrorHandler(errorHandler);
         latestResponse = restTemplate.execute(
     	  url,
 	      HttpMethod.POST,
 	      requestCallback,
 	      new ResponseExtractor<ResponseResults>()
 	      {
 	          @Override
 	          public ResponseResults extractData(ClientHttpResponse response) throws IOException
 	          {
 	              if (errorHandler.hadError)
 	              {
 	                  return (errorHandler.getResults());
 	              }
 	              else
 	              {
 	                  return (new ResponseResults(response));
 	              }
 	          }
 	      }); 
    	
    }
    
    protected void executePut(String url,String data) throws IOException
    { 
    	 final Map<String,String> headers = new HashMap<>();
         headers.put("Content-Type","application/json");
         headers.put("Accept","application/json");
         final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
         requestCallback.setBody(data);
         final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();
         if (restTemplate == null)
         {
             restTemplate = new RestTemplate();
         }
         restTemplate.setErrorHandler(errorHandler);
         latestResponse = restTemplate.execute(
     	  url,
 	      HttpMethod.PUT,
 	      requestCallback,
 	      new ResponseExtractor<ResponseResults>()
 	      {
 	          @Override
 	          public ResponseResults extractData(ClientHttpResponse response) throws IOException
 	          {
 	              if (errorHandler.hadError)
 	              {
 	                  return (errorHandler.getResults());
 	              }
 	              else
 	              {
 	                  return (new ResponseResults(response));
 	              }
 	          }
 	      }); 
    }
    
    protected void executeDelete(String url) throws IOException
    { 
        final Map<String,String> headers = new HashMap<>();
        headers.put("Accept","application/json");
        final HeaderSettingRequestCallback requestCallback = new HeaderSettingRequestCallback(headers);
        final ResponseResultErrorHandler errorHandler = new ResponseResultErrorHandler();
        if (restTemplate == null)
        {
            restTemplate = new RestTemplate();
        }
        restTemplate.setErrorHandler(errorHandler);
        latestResponse = restTemplate.execute(
    	  url,
	      HttpMethod.DELETE,
	      requestCallback,
	      new ResponseExtractor<ResponseResults>()
	      {
	          @Override
	          public ResponseResults extractData(ClientHttpResponse response) throws IOException
	          {
	              if (errorHandler.hadError)
	              {
	                  return (errorHandler.getResults());
	              }
	              else
	              {
	                  return (new ResponseResults(response));
	              }
	          }
	      });

    }

    private class ResponseResultErrorHandler implements ResponseErrorHandler
    {
        private ResponseResults results = null;
        private Boolean hadError = false;

        private ResponseResults getResults()
        {
            return results;
        }

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException
        {
            hadError = response.getRawStatusCode() >= 400;
            return hadError;
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException
        {
            results =  new ResponseResults(response);
        }
    }
}
