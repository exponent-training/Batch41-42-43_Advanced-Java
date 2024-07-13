package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserRequest;

@Repository
public interface UserRepository extends JpaRepository<UserRequest, Integer>{

	UserRequest findByUname(String uname);
	
	List<UserRequest> findByAgeGreaterThan(long age);
	
	//@Query(value = "select * from user_request where address='pune'",nativeQuery = true)
	@Query(value = "select u from UserRequest u where u.address= ?1")
	List<UserRequest> findUserRequestUsingAddress(String address);
	
	List<UserRequest> findBystartDateBetween(String startDate,String endDate);
	
	//findByAgeLessThan
	//findByAgeLessThanEqual
	//findByAgeGreaterThanEqual
	//findBystartDateBetween Add here Equal.
}
