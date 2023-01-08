package net.sccc.springboot.service;

import java.text.ParseException;


import java.util.ArrayList;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import net.sccc.springboot.model.WeatherLayout;
import net.sccc.springboot.model.WeatherModel;


@Service
public class WeatherService extends MappingJackson2HttpMessageConverter   {
	
	
	  private static WeatherService ourInstance = new WeatherService();
      
	    public static WeatherService getInstance() {
	        return ourInstance;
	    }

	    private WeatherService() {
	    	setPrettyPrint(true);
	    }

	    public List<WeatherLayout> getWeatherForFive(String city, String date1, String date2) throws ParseException {
	       
	    	String websiteResponse = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"+city+"/"+date1+"/"+date2+"?unitGroup=metric&key=A6YUWN654YRTBG2CX68Y32TQ6&contentType=json";

	    	RestTemplate restTemplate = new RestTemplate();
	        String result = restTemplate.getForObject(websiteResponse, String.class);	    	   	    	        
	        String datetime;
	        Double tempmax;
	        Integer tempmin;
	        Double temp;
	        Double feelslike;
	        Double humidity;
	        Double precip;
	   
	        List<String> preciptype = null;
	        
	        ArrayList<WeatherLayout> weatherList = new ArrayList<>();
	        
	        JSONObject root = new JSONObject(result);
	        
	        JSONArray weatherObject = root.getJSONArray("days");

	        for(int i = 0; i < weatherObject.length(); i++) {
	              	
	            JSONObject main = weatherObject.getJSONObject(i);

	            temp = (Double) main.getDouble("temp");
	            humidity = main.getDouble("humidity");
	            tempmin = main.getInt("tempmin");
	            tempmax = main.getDouble("tempmax");
	            datetime = main.getString("datetime");
	            feelslike = main.getDouble("feelslike");
	            precip = main.getDouble("precip");

	            WeatherModel wm=new WeatherModel();
	            WeatherLayout e = new WeatherLayout();
	         
                wm.setTemp(temp);
                wm.setTempmin(tempmin);
                wm.setTempmax(tempmax);
                wm.setDatetime(datetime);
                wm.setFeelslike(feelslike);
                wm.setPrecip(precip);
                wm.setPreciptype(preciptype);
                wm.setHumidity(humidity);                                               
                
	            e.setDays(wm);
	                   
	            weatherList.add(e);              
	           }
	    
	        return weatherList;
	    }

	    
}
