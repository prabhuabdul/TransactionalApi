package com.account.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.account.model.Account;
import com.account.model.AccountName;





@Repository
@Transactional
public interface AccountRepository extends JpaRepository<AccountName, Long>  {
	      @Query("SELECT acc FROM AccountName acc where account_id = (:accid) and date_time between (:lowerdate) and (:upperdate) and transaction_type =(:transaction_type)") 
		 List<AccountName> getAccountList(@Param("accid") String accid, @Param("transaction_type") String transaction_type, @Param("lowerdate") Date lowerdate, @Param("upperdate") Date upperdate);

	      @Query("SELECT acc.max(total_balance) FROM AccountName acc where account_number = (:accid)")
	      Account getAccount(@Param("accid") String accid);
}
