package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {

    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit="
                + suit
                + ", value="
                + value + '}';
    }
}
