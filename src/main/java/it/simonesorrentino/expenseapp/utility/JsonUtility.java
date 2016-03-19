package it.simonesorrentino.expenseapp.utility;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

public class JsonUtility {
	
	public static JSONObject returnJson(HttpServletRequest request){
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		       BufferedReader reader = request.getReader();
		       while ((line = reader.readLine()) != null)
			    jb.append(line);
		  } catch (Exception e) {

		  }
		
		return new JSONObject(jb.toString());
	}

}
