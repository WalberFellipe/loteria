package com.walber.loteria.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walber.loteria.entities.Bet;
import com.walber.loteria.repositories.BetRepository;

@RestController
@RequestMapping(value = "/draw")
public class BetResource {
	
	@Autowired BetRepository betRepository;
			@PostMapping("/create")
			public int[] createBet(@Validated @RequestBody String email) {
				
				Bet newBet = new Bet();
				List<Bet> bets;
				Boolean created = false;
				
				newBet.setNumbers(newBet.bet(6));
				
				newBet.setEmail(email);
					
				bets = betRepository.findAll();
				
				for (int i = 0; i < bets.size(); i++)
				{
					
					if(bets.get(i).getNumbers().toString().equals(newBet.getNumbers().toString()) && bets.get(i).getEmail().equals(email))
					{
						created = true;
					}
				}

				if(created == false)
				{				
					betRepository.save(newBet);
					return newBet.getNumbers();
				}
				else
				{
					return this.createBet(email);
				}			
			}
			
			@GetMapping("/list")
			public List<Bet> getBets(@Validated @RequestBody String email) {
				
			    List<Bet> bets = betRepository.findAll();
			    List<Bet> betsReturn = new ArrayList<>();;
			    
			    for (int c = 0; c < bets.size(); c++)
			    {
			    	
			    	if(bets.get(c).getEmail().equals(email))
			    	{
			    		betsReturn.add(bets.get(c));			    	
			    	}
			    }
			    
				return betsReturn;
			}
}
