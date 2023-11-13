package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PokerHand pokerHandMainCard = new PokerHand("4d 6s kc 8H 3S");//старшая карта
        PokerHand pokerHandP1 = new PokerHand("2D 6H 7D TC TS");//одна пара
        PokerHand pokerHandP2 = new PokerHand("4H JC JH QC QD");//две пары
        PokerHand pokerHandSet = new PokerHand("7H TS KH KD KC");//Set Три карты одного номинала
        PokerHand pokerHandStraight = new PokerHand("8H 9S TS JD QC");//Straight
        PokerHand pokerHandFlush = new PokerHand("4S 8S 9S 6S TS");//Flush
        PokerHand pokerHandFullHouse = new PokerHand("7C 7H 7D JS JH");//FullHouse
        PokerHand pokerHandKare = new PokerHand("7C JC JD JS JH");//Каре
        PokerHand pokerHandStraightFlush = new PokerHand("7C 8C 9C TC JC");//Стрит-Флеш
        PokerHand pokerHandSRoyalFlush = new PokerHand("TH JH QH KH AH");//Флеш-Рояль
/*
        System.out.println("Старшая карта: "+pokerHandMainCard.getRang());
        System.out.println("Одна пара: "+pokerHandP1.getRang());
        System.out.println("Две пары: "+pokerHandP2.getRang());
        System.out.println("Сет (три карты одного достоинства): "+pokerHandSet.getRang());
        System.out.println("Стрит (все карты последовательно): "+pokerHandStraight.getRang());
        System.out.println("Флеш (все карты одной масти): "+pokerHandFlush.getRang());
        System.out.println("Фулл-Хаус (сети и пара): "+pokerHandFullHouse.getRang());
        System.out.println("Каре (сети пара): "+pokerHandKare.getRang());
        System.out.println("Стрит-Флеш (стрит и флеш): "+pokerHandStraightFlush.getRang());
        System.out.println("Флеш-Рояль (от 10 до туза одной масти): "+pokerHandSRoyalFlush.getRang());
*/
        System.out.println(Combination.isRoyalFlush(HandParser.getListCards("TH JH QH KH AH")));
        System.out.println(Combination.isKare(HandParser.getListCards("TH JH QH KH AH")));

        List<PokerHand> pokerHandList = new ArrayList<>();
        pokerHandList.add(pokerHandFlush);
        pokerHandList.add(pokerHandSRoyalFlush);
        pokerHandList.add(pokerHandFullHouse);
        pokerHandList.add(pokerHandP2);
        pokerHandList.add(pokerHandMainCard);
        pokerHandList.add(pokerHandKare);
        pokerHandList.add(pokerHandP1);
        pokerHandList.add(pokerHandSet);
        pokerHandList.add(pokerHandStraight);
        pokerHandList.add(pokerHandStraightFlush);
        Collections.sort(pokerHandList);
        pokerHandList.forEach(System.out::println);

    }
}