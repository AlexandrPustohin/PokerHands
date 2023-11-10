package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardParserTest {

    @Test
    void getCard() {
        String strCard = "5H";
        Card card = CardParser.getCard(strCard);
        assertEquals(card.getNominal(),"5");
        assertEquals(card.getSuit(),"H");
    }
}