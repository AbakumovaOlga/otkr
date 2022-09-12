package com.example.otkr;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.otkr.models.*;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OtkrApplication {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Card[] cards = objectMapper.readValue(new File("inputData.json"), Card[].class);

		int countZp = 0;
		int countAct = 0;
		for (Card card : cards) {
			if (card.cardData.tarif.equals("Opencard Зарплатная")) {
				countZp++;
			}
			if (card.cardData.status.plasticStatus.equals("Active") && card.cardData.status.statusCode.equals("00")) {
				countAct++;
			}
		}
		System.out.println("Кол-во Зарплатных карт=" + countZp);
		System.out.println("Кол-во активных карт=" + countAct);
		System.out.println("Введите cardID");

		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String cardID = buffer.readLine();
		Card resCard=null;
		for (Card card : cards) {
			if(card.cardData.cardID.equals(cardID)){
				resCard=card;
				System.out.println("Тариф карты ="+card.cardData.tarif);
				System.out.println("Имя владельца карты = "+card.cardData.cardHolderName);
			}
		}
		if(resCard==null){
			System.out.println("У вас нет такой карты");
		}
	}

}
