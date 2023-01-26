package com.example.msbanking.repository;

import com.example.msbanking.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRespository extends JpaRepository<Transfer,Long> {


}
