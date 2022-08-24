package org.sam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ConnectIOException;

public class HttpURLConnectionPostExample {



	// POST METHOD

	private void postMethodExample() throws IOException {

		//1	CREATE OBJECT FOR URL
		URL url =new URL("https://dummy.restapiexample.com/api/v1/create");

		//2 URL CONNECTION & STORE IN THE PARENT CLASS
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();


		//3 SET THE REQUEST TYPE
		connection.setRequestMethod("POST");


		connection.setRequestProperty("Content-Type", "application/json");

		connection.setDoOutput(true);


		String jsonBody = ("{\"name\":\"Naga\",\"salary\":\"12311\",\"age\":\"23\"}");

		byte[] inputJson =jsonBody.getBytes();


		OutputStream outputstream=connection.getOutputStream();

		outputstream.write(inputJson);
		//5 GET THE STATUS CODE FROM THE OBJECT & PRINT
		System.out.println("Respose code :"+ connection.getResponseCode());

		//6 GET THE RESPONCE MESSAGE & PRINT
		System.out.println("Respose Message :"+ connection.getResponseMessage());

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
	public static void main(String[] args) throws IOException {
		HttpURLConnectionPostExample example = new HttpURLConnectionPostExample();
		example.postMethodExample();


	}

}
