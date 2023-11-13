package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandParserTest {

    @org.junit.jupiter.api.Test
    void getListCards() {
        HandParser handParser = new HandParser();
        assertArrayEquals(handParser.getListCards("4d 6s kc 8H 3S").toArray(),getTestListCards().toArray());
    }

    private List<Card> getTestListCards() {
        List<Card> list = new ArrayList<>();
        list.add(new Card("4","D"));
        list.add(new Card("6","S"));
        list.add(new Card("K","C"));
        list.add(new Card("8","H"));
        list.add(new Card("3","S"));
        return list;
    }

}