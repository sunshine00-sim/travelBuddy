package net.sccc.springboot.controller;


import java.text.ParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.sccc.springboot.repository.RegistrationRepo;
import net.sccc.springboot.repository.TravellerRepo;
import net.sccc.springboot.repository.TripReqRepo;
import net.sccc.springboot.service.UUIDService;
import net.sccc.springboot.service.WeatherService;
import net.sccc.springboot.model.Traveller;
import net.sccc.springboot.model.UserRegistration;
import net.sccc.springboot.model.WeatherLayout;
import net.sccc.springboot.model.TripReq;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")

public class TravellerController {
	
	String usernameNow;
	@Autowired
	private TravellerRepo travellerRepo;
	private RegistrationRepo regRepo;
	private TripReqRepo tripRepo;
	private final WeatherService weatherService;
	private final UUIDService uuidService;

	public TravellerController(WeatherService weatherService, UUIDService uuidService, RegistrationRepo regRepo, TripReqRepo tripRepo) {
	        this.weatherService = weatherService;
	        this.uuidService = uuidService;
	        this.regRepo = regRepo;
	        this.tripRepo = tripRepo;
	    }
	
	RestTemplate restTemplate = new RestTemplate();
	List<String> wow = new ArrayList<String>();
	
	// get all travellers Rest API
	@GetMapping("/travellers")
	public List<Traveller> getAllTravellers(){
		return travellerRepo.findAll();
		
	}
	@GetMapping("/test")
	public String testAzure() {
		String wow = "hello";
		return wow;
	}
	// create a new trip Rest API
	@PostMapping("/travellers")
	public Traveller addTrip(@RequestBody Traveller traveller) {
		return travellerRepo.save(traveller);
	}
	
	// get specific trips by city Rest API
	@GetMapping("/travellers/{location}")
	public List<Traveller> getFilteredTrips(@PathVariable String location){
		List<Traveller> traveller = travellerRepo.findBylocation(location);
		return travellerRepo.saveAll(traveller);
	}
	
	@GetMapping("/mytrips")
	public List<Traveller> getMyTrips(){
		List<Traveller> traveller = travellerRepo.findBytravellerName(usernameNow);
		return travellerRepo.saveAll(traveller);
	}
	
	
	// get weather forecast by consuming an external Rest API
	@GetMapping("/forecast/{city}/{date1}/{date2}")
	public List<WeatherLayout> getWeatherForFive(
			@PathVariable String city , @PathVariable String date1, @PathVariable String date2) throws ParseException {
		return this.weatherService.getWeatherForFive(city, date1, date2);		
	}	
	
	@GetMapping("/random-id")
	public String getRandomID() {
		return this.uuidService.getRandomID();
	}
	
	@PostMapping("/registration")
	public UserRegistration registerUser(@RequestBody UserRegistration userReg) {
		return regRepo.save(userReg);
	}
	
	@PostMapping("/getcurrentuser")
	public String getCurrentUser(@RequestBody String username) {
		return usernameNow = username;
	}
	
	@GetMapping("/usernow")
	public String getUserNow() {
		return usernameNow;
	}
	
	@PutMapping("/addInterest/{id}")
	public ResponseEntity<Traveller> updateInterest(@PathVariable Long id){
		Optional<Traveller> travellerOptional = travellerRepo.findById(id);
		Traveller traveller = travellerOptional.get();
		traveller.setInterest(traveller.getInterest() + 1);
		Traveller updatedInterest = travellerRepo.save(traveller);
		return ResponseEntity.ok(updatedInterest);
	}
	
	@GetMapping("/login/{email_id}, {password}")
	public Boolean findUser(@PathVariable String email_id, @PathVariable String password) {
		UserRegistration userDet = this.regRepo.findBy(email_id, password);
		System.out.println((userDet).toString());
		if (userDet.toString() == "") {
			return false;
		}
		
		return true;

	}
	@PostMapping("/showInterest")
	public TripReq showInterest( @RequestBody TripReq tripReq) {
		return tripRepo.save(tripReq);
	}
	
	@GetMapping("/myrequests")
	public List<TripReq> checkRequests(){
		List<TripReq> tripReq = tripRepo.findBytravellerName(usernameNow);
		return tripRepo.saveAll(tripReq);
	
}
	
	@DeleteMapping("/deleteRequest/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteRequest(@PathVariable Long id){
		
		Optional<TripReq> tripReqOptional = tripRepo.findById(id);
		TripReq tripReq = tripReqOptional.get();
		
		tripRepo.delete(tripReq);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
}
