package fr.zbar.codingdojo.tenniskata.score;

import fr.zbar.codingdojo.tenniskata.player.Player;

public record WinningScore(Player player) implements ScoreSystem {

    @Override
    public String getScore() {
        return "Player " + player.name() + " wins";
    }
}
