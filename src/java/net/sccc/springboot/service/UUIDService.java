package net.sccc.springboot.service;

import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UUIDService {
	
	
	public String getRandomID() {
		String websiteResponse = "https://www.uuidtools.com/api/generate/v1";
		
		RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(websiteResponse, String.class);	
	    JSONArray root = new JSONArray(result);
	    return root.toString();
	}
	
	
    

}
