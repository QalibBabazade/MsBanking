package com.example.msbanking.repository;

import com.example.msbanking.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

  Card findCardByIdAndActive(Long id, Integer active);

  List<Card> findAllByActive(Integer active);

  Card findCardByNumberAndActive(String number,Integer active);
}
