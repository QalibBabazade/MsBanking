package com.example.msbanking.repository;

import com.example.msbanking.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByIdAndActive(Long id, Integer active);

    List<Account> findAllByActive(Integer active);

    List<Account> findAccountByIbanOrNumberAndActive(String iban,String number, Integer active);

    Account findAccountByIbanAndActive(String iban, Integer active);


}
