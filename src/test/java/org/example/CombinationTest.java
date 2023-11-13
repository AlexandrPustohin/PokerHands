package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationTest {

    @Test
    void getRang() {
        assertEquals(new PokerHand("4d 6s kc 8H 3S").getRang(),0);//старшая карта
        assertEquals(new PokerHand("2D 6H 7D TC TS").getRang(),1);//одна пара
        assertEquals(new PokerHand("4H JC JH QC QD").getRang(),2);//две пары
        assertEquals(new PokerHand("7H TS KH KD KC").getRang(),3);//Set Три карты одного номинала
        assertEquals(new PokerHand("8H 9S TS JD QC").getRang(),4);//Straight
        assertEquals(new PokerHand("4S 8S 9S 6S TS").getRang(),5);//Flush
        assertEquals(new PokerHand("7C 7H 7D JS JH").getRang(),6);//FullHouse
        assertEquals(new PokerHand("7C JC JD JS JH").getRang(),7);//Каре
        assertEquals(new PokerHand("7C 8C 9C TC JC").getRang(),8);//Стрит-Флеш
        assertEquals(new PokerHand("TH JH QH KH AH").getRang(),9);//Флеш-Рояль
    }

    @Test
    void countPairs() {
        assertEquals(Combination.countPairs(HandParser.getListCards("4H JC JH QC QD")),2);
        assertEquals(Combination.countPairs(HandParser.getListCards("2D 6H 7D TC TS")),1);
    }

    @Test
    void haveTreeCards() {
        assertTrue(Combination.haveTreeCards(HandParser.getListCards("7H TS KH KD KC")));
    }

    @Test
    void isStraight() {
        assertTrue(Combination.isStraight(HandParser.getListCards("8H 9S TS JD QC")));
    }

    @Test
    void isFlush() {
        assertTrue(Combination.isFlush(HandParser.getListCards("4S 8S 9S 6S TS")));

    }

    @Test
    void isRoyalFlush() {
        assertTrue(Combination.isRoyalFlush(HandParser.getListCards("TH JH QH KH AH")));
    }

    @Test
    void isStraightFlush() {
        assertTrue(Combination.isStraightFlush(HandParser.getListCards("7C 8C 9C TC JC")));
    }

    @Test
    void isKare() {
        assertTrue(Combination.isKare(HandParser.getListCards("7C JC JD JS JH")));
    }

    @Test
    void isFullHouse() {
        assertTrue(Combination.isFullHouse(HandParser.getListCards("7C 7H 7D JS JH")));
    }

    @Test
    void isNotRoyalFlush() {
        assertFalse(Combination.isRoyalFlush(HandParser.getListCards("4S 8S 9S 6S TS")));
    }
}