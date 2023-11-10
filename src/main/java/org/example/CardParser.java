package org.example;

public class CardParser {
    private static final String nominals ="23456789TJQKA";
    private static final String suits ="CHDS";
    public static Card getCard(String card){

        String [] mCard = card.split("");
        try {
            String nominal = mCard[0].toUpperCase();
            String suit = mCard[1].toUpperCase();
            if (nominals.contains(nominal) && suits.contains(suit)) {
                return new Card(nominal, suit);
            } else {
                throw new IllegalArgumentException("Invalid card!");
            }
        } catch (ArrayIndexOutOfBoundsException e){
            throw new IllegalArgumentException("Invalid card in poker hand!");
        }

    }
}
