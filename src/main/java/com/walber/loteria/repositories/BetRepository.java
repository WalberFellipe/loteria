package com.walber.loteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walber.loteria.entities.Bet;

public interface BetRepository extends JpaRepository<Bet, Long>{

}
