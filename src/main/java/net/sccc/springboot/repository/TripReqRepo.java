package net.sccc.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sccc.springboot.model.TripReq;


public interface TripReqRepo extends JpaRepository<TripReq, Long> {

	List<TripReq> findBytravellerName(String usernameNow);

}
