package ru.job4j;

import java.util.List;
import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}

public class Card {
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + " " + value;
    }

    public static void main(String[] args) {
        List<Card> cardDeck = Stream.of(Suit.values())
                .flatMap(suit1 -> Stream.of(Value.values())
                        .map(value1 -> new Card(suit1, value1))).toList();

        cardDeck.forEach(System.out::println);
    }
}