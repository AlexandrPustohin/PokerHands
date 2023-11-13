package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandParserTest {

    @org.junit.jupiter.api.Test
    void getListCards() {
        HandParser handParser = new HandParser();
        assertArrayEquals(handParser.getListCards("4d 6s kc 8H 3S").toArray(),getTestListCards().toArray());
    }

    @Test
    void throwIllegalArgumentExceptionTest(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            HandParser.getListCards("4d 6s kc 8H");
        });
        Assertions.assertEquals("Invalid poker hand!", thrown.getMessage());
    }

    @Test
    void noThrowIllegalArgumentExceptionTest(){
            Assertions.assertDoesNotThrow(() -> HandParser.getListCards("4d 6s kc 8H 3S"));
    }

    private List<Card> getTestListCards() {
        List<Card> list = new ArrayList<>();
        list.add(CardParser.getCard("4d"));
        list.add(CardParser.getCard("6S"));
        list.add(CardParser.getCard("KC"));
        list.add(CardParser.getCard("8H"));
        list.add(CardParser.getCard("3S"));
        return list;
    }

}