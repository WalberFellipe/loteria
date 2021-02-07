package com.walber.loteria.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Bet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/*Validação de email*/
	@NotNull
	private String email;

	private int[] numbers;

	/* Getter and Setters */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public int[] bet(int n) {
		Random rand = new Random();
		int[] numbers = new int[n];
		int turns;
		Boolean ok = false;
		while (ok == false) {
			ok = true;
			for (int i = 0; i < n; i++) {
				numbers[i] = rand.nextInt(61);

			}

			Arrays.sort(numbers);

			for (int i = 0; i < numbers.length; i++) {
				turns = 0;
				for (int b = 0; b < numbers.length; b++) {
					if (numbers[i] == numbers[b])
						turns++;
					if (numbers[i] == 0)
						turns = 2;
				}
				if (turns > 1)
					ok = false;
			}
		}
		return numbers;
	}
}
