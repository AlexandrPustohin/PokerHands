package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandParser {

    public static List<Card> getListCards (String hand){
        List<String> list = Stream.of(hand.split(" ")).collect(Collectors.toList());
        if (list.size()!=5){
            throw new IllegalArgumentException("Invalid poker hand!");
        }
        List<Card> res =list.stream().map(c-> CardParser.getCard(c)).collect(Collectors.toList());

        return res;
    }
}
