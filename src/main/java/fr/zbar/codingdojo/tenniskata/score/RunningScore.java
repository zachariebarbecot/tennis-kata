package fr.zbar.codingdojo.tenniskata.score;

import fr.zbar.codingdojo.tenniskata.player.Player;

public record RunningScore(Player p1, Player p2) implements ScoreSystem {

    @Override
    public String getScore() {
        return p1.translatedPoint() + " - " + p2.translatedPoint();
    }
}
