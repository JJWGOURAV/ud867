package com.udacity.gradle.builditbigger;

import java.io.IOException;




import java.util.HashMap;
import java.util.Map.Entry;

import android.util.Log;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {

	public static final String dummyResponse = "{\"status\":\"failed\",\"message\":\"Could not connect\"}";
	
	public static String doSynchronousGet(String url) {
		
		OkHttpClient client = new OkHttpClient();

		  Request request = new Request.Builder()
		      .url(url)
		      .build();

		  Response response;
		try {
			response = client.newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dummyResponse;
	}
	
	public static void doAsynchronousGet(String url){
		
		OkHttpClient client = new OkHttpClient();

	    Request request = new Request.Builder()
	        .url("http://publicobject.com/helloworld.txt")
	        .build();

	    client.newCall(request).enqueue(new Callback() {
	    	
		      @Override 
		      public void onFailure(Call request, IOException throwable) {
		        throwable.printStackTrace();
		      }
	
		      @Override public void onResponse(Call request, Response response) throws IOException {
		        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
	
		        Headers responseHeaders = response.headers();
		        for (int i = 0; i < responseHeaders.size(); i++) {
		          System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
		        }
	
		        System.out.println(response.body().string());
		      }
	    });
	}

	public static String doSynchronousPost(HashMap<String,String> pairs, String url) {

		OkHttpClient client = new OkHttpClient();

		FormBody.Builder builder = new FormBody.Builder();
		StringBuilder input = new StringBuilder();

		for(Entry<String,String> pair:pairs.entrySet())
		{
			input.append(";Key:" + pair.getKey() + ",Value:" + pair.getValue());
			builder.add(pair.getKey(), pair.getValue());
		}

		Log.d("Input", input.toString());

		RequestBody formBody = builder.build();
        
		Request request = new Request.Builder().url(url).post(formBody).build();

		Log.d("OkHttp", "" + request.url());
		  Response response;
		try {
			response = client.newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dummyResponse;
	}

}