package com.qa.Lottery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.Lottery.Domain.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}
