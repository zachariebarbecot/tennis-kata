package fr.zbar.codingdojo.tenniskata;


import fr.zbar.codingdojo.tenniskata.player.Player;
import fr.zbar.codingdojo.tenniskata.score.ScoreRules;
import fr.zbar.codingdojo.tenniskata.score.ScoreSystem;

import java.util.stream.Stream;

public record TennisScoringGame(Player playerOne, Player playerTwo) {

    public String getScore() {
        return Stream.of(ScoreRules.values())
                .filter(rule -> rule.predicate().test(playerOne, playerTwo))
                .map(rule -> rule.score(playerOne, playerTwo))
                .map(ScoreSystem::getScore)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
