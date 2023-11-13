package org.example;

public class CardParser {
    private static final String nominals ="23456789TJQKA";
    private static final String suits ="CHDS";
    public static Card getCard(String card){

        String [] mCard = card.split("");

        String nominal = mCard[0].toUpperCase().trim();
        String suit = mCard[1].toUpperCase().trim();
        if ( !nominals.contains(nominal) && !suits.contains(suit)) {
            throw new IllegalArgumentException("Invalid card!");
        } else if(!suits.contains(suit)){
            throw new IllegalArgumentException("Invalid suit card!");
        } else if(!nominals.contains(nominal) ) {
            throw new IllegalArgumentException("Invalid nominal card!");
        } else {
            return new Card(nominal, suit);
        }
    }
}
