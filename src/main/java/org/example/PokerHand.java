package org.example;

import java.util.List;

public class PokerHand implements Comparable<PokerHand>{
    private String setOfCards; //строка с рукой карт
    private List<Card> cardList; //список карт
    private int rang; //ранг (уровень) руки
    public PokerHand() {
    }

    public PokerHand(String setOfCards) {
        this.setOfCards = setOfCards;
        cardList = HandParser.getListCards(setOfCards);
        rang = Combination.getRang(cardList);
    }
    public int getRang() {
        return rang;
    }

    @Override
    public int compareTo(PokerHand o) {
        return Integer.compare(o.getRang(), this.getRang());
    }


    @Override
    public String toString() {
        return "PokerHand{" +
                "cardList=" + cardList +
                ", rang=" + rang +
                '}';
    }
}
