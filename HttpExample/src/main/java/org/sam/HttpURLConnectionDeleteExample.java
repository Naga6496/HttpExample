package org.sam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionDeleteExample {


	private void deleteMethodExample() throws IOException {

		URL url= new URL("https://dummy.restapiexample.com/api/v1/delete/2333");

		HttpURLConnection connection =(HttpURLConnection) url.openConnection();

		connection.setRequestMethod("DELETE");

		connection.setRequestProperty("Content-Type", "application/json");

		connection.setDoOutput(true);

		System.out.println("Respose code :"+ connection.getResponseCode());

		System.out.println("Respose Message :"+ connection.getResponseMessage());

		InputStream inputStream = connection.getInputStream();

		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		BufferedReader bufferReader = new BufferedReader(inputStreamReader);

		String line;
		StringBuffer buffer = new StringBuffer();
		while((line=bufferReader.readLine())!=null){

			buffer.append(line);
		}


		System.out.println(buffer);
	}


	public static void main(String[] args) throws IOException {

		HttpURLConnectionDeleteExample example = new HttpURLConnectionDeleteExample();
		example.deleteMethodExample();
	}

}
