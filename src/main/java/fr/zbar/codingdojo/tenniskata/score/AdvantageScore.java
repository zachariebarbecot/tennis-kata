package fr.zbar.codingdojo.tenniskata.score;

import fr.zbar.codingdojo.tenniskata.player.Player;

public record AdvantageScore(Player player) implements ScoreSystem {

    @Override
    public String getScore() {
        return "Advantage player " + player.name();
    }
}
