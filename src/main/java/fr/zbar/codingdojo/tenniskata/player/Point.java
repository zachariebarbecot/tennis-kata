package fr.zbar.codingdojo.tenniskata.player;

import java.util.function.Predicate;

public enum Point implements Predicate<Player> {
    ZERO("Love"),
    ONE("15"),
    TWO("30"),
    THREE("40"),
    FOUR;

    private final String value;

    Point() {
        this.value = null;
    }

    Point(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean test(Player player) {
        return this == player.point();
    }
}
