package com.cucumber.test.crud;

import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter; 
 
public class ResponseResults
{
    private final ClientHttpResponse theResponse;
    private final String body;

    protected ResponseResults(final ClientHttpResponse response) throws IOException
    {
        this.theResponse = response;
        final InputStream bodyInputStream = response.getBody();
        if (null == bodyInputStream)
        {
            this.body = "{}";
        }
        else
        {
            final StringWriter stringWriter = new StringWriter();
            for (int ch; (ch = bodyInputStream.read()) != -1; ) {
            	stringWriter.append((char) ch);
            } 
            this.body = stringWriter.toString(); 
        }
    }

    protected ClientHttpResponse getTheResponse()
    {
        return theResponse;
    }

    protected String getBody()
    {
        return body;
    }
}