package com.walber.loteria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walber.loteria.entities.Bet;
import com.walber.loteria.repositories.BetRepository;

@Service
public class BetService {
	
	@Autowired
	private BetRepository repository;
	
	public List<Bet> findaAll() {
		return repository.findAll();
	}
	
	public Bet findById(Long id) {
		Optional<Bet> obj = repository.findById(id);
		return obj.get();
	}

}
