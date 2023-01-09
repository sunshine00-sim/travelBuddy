package net.sccc.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import net.sccc.springboot.model.Traveller;

public interface TravellerRepo extends JpaRepository<Traveller, Long>{
	
	List<Traveller> findBylocation(String location);
	List<Traveller> findBytravellerName (String travellerName);
	
}
