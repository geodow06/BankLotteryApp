package com.qa.AccountAPI.Entities;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.Lottery.Domain.Account;

@Repository
public interface AccountRepo extends MongoRepository<Account, Long> {

}
