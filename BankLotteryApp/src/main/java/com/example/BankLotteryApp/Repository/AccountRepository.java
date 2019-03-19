package com.example.BankLotteryApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankLotteryApp.Entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
