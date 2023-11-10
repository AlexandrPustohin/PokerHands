package org.example;

import java.util.Objects;

public class Card implements Comparable<Card>{
    public static final  String ordering ="23456789TJQKA";
    private String nominal; //номинал (2, 3, 4, 5, 6, 7, 8, 9, T(en), J(ack), Q(ueen), K(ing), A(ce))
    private String suit; ///масть (S(pades) пики, H(earts) червы , D(iamonds) буби, C(lubs) крести)

    public Card(String nominal, String suit) {
        this.nominal = nominal;
        this.suit = suit;
    }

    public String getNominal() {
        return nominal;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "nominal='" + nominal + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare( ordering.indexOf(this.getNominal()), ordering.indexOf(o.getNominal()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(nominal, card.nominal) && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominal, suit);
    }
}
