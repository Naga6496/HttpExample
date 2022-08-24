package org.sam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionGetExample {

	// GET MEHTOD

	public void getMethodExample() throws IOException {


		//1	CREATE OBJECT FOR URL
		URL url = new URL("https://dummy.restapiexample.com/api/v1/employees");

		//2 URL CONNECTION & STORE IN THE PARENT CLASS
		HttpURLConnection connection= (HttpURLConnection)url.openConnection();

		//3 SET THE REQUEST TYPE
		connection.setRequestMethod("GET");

		//4 CONNECT (not mandatory)
		connection.connect();

		//5 GET THE STATUS CODE FROM THE OBJECT & PRINT
		int statusCode = connection.getResponseCode();
		System.out.println("Status Code is" +statusCode);

		//6 GET THE RESPONCE MESSAGE & PRINT
		String message =connection.getResponseMessage();
		System.out.println("Responce Message "+message);

		//7 READ THE RESPONCE USING GETINPUTSTREAM
		InputStream inputStream = connection.getInputStream();

		//8 CREATE AN INPUTSTREAM READER FOR READING THE RESPONCE BODY
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		//9 CREATE BUFFER READER & PASS THE INPUTSTREAM READER

		BufferedReader bufferReader = new BufferedReader(inputStreamReader);

		//10 READ THE LINE USING READLINE()
		String line;
		StringBuffer buffer = new StringBuffer();
		while((line=bufferReader.readLine())!=null){

			buffer.append(line);

		}
		System.out.println(buffer);

	}
	
	//CALL THE METHOD
	
	public static void main(String[] args) throws IOException {
		HttpURLConnectionGetExample example = new HttpURLConnectionGetExample();
		example.getMethodExample();


	}
}
 