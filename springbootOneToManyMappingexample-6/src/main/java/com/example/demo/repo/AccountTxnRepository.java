package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AccountData;

@Repository
public interface AccountTxnRepository extends JpaRepository<AccountData, Integer>{

	
	AccountData findByAccountNumber(String accNumber);
	
	@Query(value = "select email from account_data",nativeQuery = true)
	List<String> findEmail();
	
}
