package org.sam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionPutExample {

	private void putMethodExample() throws IOException {
		//1	CREATE OBJECT FOR URL
		URL url = new URL("https://dummy.restapiexample.com/api/v1/update/2333");

		//2 URL CONNECTION & STORE IN THE PARENT CLASS
		HttpURLConnection connection =(HttpURLConnection) url.openConnection();

		//3 SET THE REQUEST TYPE
		connection.setRequestMethod("PUT");


		connection.setRequestProperty("Content-Type", "application/json");

		connection.setDoOutput(true);


		String jsonBody = ("{\"name\":\"Naga\",\"salary\":\"12311\",\"age\":\"23\"}");

		byte[] inputJson =jsonBody.getBytes();


		int statusCode = connection.getResponseCode();
		System.out.println("Status Code is" +statusCode);

		String message =connection.getResponseMessage();
		System.out.println("Responce Message "+message);


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

		HttpURLConnectionPutExample example = new HttpURLConnectionPutExample();
		example.putMethodExample();

	}

}
