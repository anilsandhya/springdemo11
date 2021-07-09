package com.anil.demo11.service;

import org.springframework.stereotype.Service;

import com.anil.demo11.domainobject.Num2Words;

@Service
public class Num2WordsService implements INum2Words {
	
	@Override
	public Num2Words getInWords(int number) {
				
		//ask this Num2Words domain object why i am creating as new object.
		Num2Words num2Words = new Num2Words();
		String words = convertNum2Words1(number);
		num2Words.setNum(number);
		num2Words.setWords(words);
		return num2Words;
	}
	
	public String convertNum2Words1(int number) {
		String words = "";
		String unitArray[] = { "zero", "one", "two", "three", "four", "five",
				"six", "seven", "eight", "nine", "ten", "eleven", "twelve",
				"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };
		String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", 
				"fifty", "sixty", "seventy", "eighty", "ninety"};
		
		if (number == 0) {
			return "zero";
		}
		
		if (number < 0) {
			number = number * (-1);
			return "Negative " + convertNum2Words1(number);
		}
		
		if ((number / 1000000) > 0) {
			words += convertNum2Words1(number / 1000000) + " million ";
			number %= 1000000;
		}
		
		if ((number / 1000) > 0) {
			words += convertNum2Words1(number / 1000) + " thousand ";
			number %= 1000;			
		}
		
		if ((number / 100) > 0) {
			words += convertNum2Words1(number / 100) + " hundred ";
			number %= 100;
		}
		
		if (number > 0) {
			if (number < 20) {
				words += unitArray[number];
			} else {
				words += tensArray[number / 10];
				if ((number % 10) > 0) {
					words += "-" + unitArray[number % 10]; 
				}
			}
		}
		return words;
	}
}
