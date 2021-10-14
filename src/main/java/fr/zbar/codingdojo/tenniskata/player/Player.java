package fr.zbar.codingdojo.tenniskata.player;

public record Player(String name, Point point) {

    public String translatedPoint() {
        return point.value();
    }
}
