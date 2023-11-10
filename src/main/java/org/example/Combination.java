package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Combination {

    public static int getRang(List<Card> cardList){
        int rang = 0;
        if (isRoyalFlush(cardList)){
            return 9;
        }
        if(isStraightFlush(cardList)){
            return 8;
        }
        if(isKare(cardList)){//Kare
            return 7;
        }
        if(isFullHouse(cardList)){//FullHouse
            return 6;
        }
        if (isFlush(cardList) && !isStraight(cardList)){//Flush
            return 5;
        }
        if (isStraight(cardList)){//Стрит
            return 4;
        }
        if (haveTreeCards(cardList)){//Сет
            return 3;
        }
        if (countPairs(cardList)==2){ //две пары
            return 2;
        }
        if (countPairs(cardList)==1){ //одна пара
            return 1;
        }

        return rang;
    }

    private static boolean isRoyalFlush(List<Card> cards) {
    Collections.sort(cards);
    return isFlush(cards) && cards.get(0).getNominal().equals("T") && cards.get(4).getNominal().equals("A");
    }

    private static boolean isStraightFlush(List<Card> cards) {
        return isFlush(cards) && isStraight(cards)? true:false;
    }

    private static boolean isKare(List<Card> cards) {
        long count = cards.stream().map(c->c.getNominal())
                .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum))
                .entrySet().stream().filter(k->k.getValue()==4).count();
        return count==1 ? true:false;
    }

    private static boolean isFullHouse(List<Card> cardList) {
        return haveTreeCards(cardList) && (countPairs(cardList)==1);
    }

    public static List<Card> getSortedBySuit(List<Card> cardList){
        Comparator<Card> cardBySuit = Comparator.comparing(Card::getSuit);
        List<Card> res = cardList.stream().sorted(cardBySuit).collect(Collectors.toList());
        return res;
    }

    //количество пар
    protected static  long countPairs(List<Card> cards) {
        return cards.stream().map(c->c.getNominal())
                .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum))
                .entrySet().stream().filter(k->k.getValue()==2).count();
    }

    protected static boolean haveTreeCards(List<Card> cards){
        long count = cards.stream().map(c->c.getNominal())
                .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum))
                .entrySet().stream().filter(k->k.getValue()==3).count();
        return count==1 ? true:false;
    }

    protected static boolean isStraight(List<Card> cards){
        Collections.sort(cards);//
        for (int i = 0; i < cards.size() - 1; i++) {
            if (Card.ordering.indexOf(cards.get(i+1).getNominal()) - Card.ordering.indexOf(cards.get(i).getNominal()) != 1) return false;
        }

        return true;
    }

    protected static boolean isFlush (List<Card> cards){
        long count = cards.stream().map(c->c.getSuit())
                .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum))
                .entrySet().stream().filter(k->k.getValue()==5).count();
        return count==1 ? true:false;
    }


}
