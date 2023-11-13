package org.example;

import org.junit.jupiter.api.Assertions;
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

    @Test
    void noThrowExceptionsTest(){
        Assertions.assertDoesNotThrow(() -> CardParser.getCard("4d"));
        Assertions.assertDoesNotThrow(() -> CardParser.getCard("4D"));
    }

    @Test
    void throwIllegalArgumentExceptionWhenWrongNominalTest(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CardParser.getCard("Gd");
        });
        Assertions.assertEquals("Invalid nominal card!", thrown.getMessage());
    }

    @Test
    void throwIllegalArgumentExceptionWhenWrongSuitTest(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CardParser.getCard("2F");
        });
        Assertions.assertEquals("Invalid suit card!", thrown.getMessage());
    }
    @Test
    void throwIllegalArgumentExceptionWhenWrongCardTest(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CardParser.getCard("1F");
        });
        Assertions.assertEquals("Invalid card!", thrown.getMessage());
    }

}