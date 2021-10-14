package fr.zbar.codingdojo.tenniskata.score;


import fr.zbar.codingdojo.tenniskata.player.Player;
import fr.zbar.codingdojo.tenniskata.player.Point;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public enum ScoreRules {
    RUNNING_SCORE(Constants.RUNNING_SCORE, RunningScore::new),
    DEUCE_SCORE(Constants.AT_LEAST_THREE_POINTS_HAVE_BEEN_SCORED_BY_BOTH_PLAYERS_AND_SCORES_IS_EQUAL, (p1, p2) -> new DeuceScore()),
    WINNER_PLAYER_ONE(Constants.PLAYER_ONE_HAS_FOUR_POINTS_AND_PLAYER_TWO_HAS_LESS_THAN_THREE_POINTS, (p1, p2) -> new WinningScore(p1)),
    WINNER_PLAYER_TWO(Constants.PLAYER_TWO_HAS_FOUR_POINTS_AND_PLAYER_ONE_HAS_LESS_THAN_THREE_POINTS, (p1, p2) -> new WinningScore(p2)),
    ADVANTAGE_PLAYER_ONE(Constants.AT_LEAST_THREE_POINTS_HAVE_BEEN_SCORED_BY_BOTH_PLAYERS_AND_PLAYER_ONE_HAS_ONE_MORE_POINT, (p1, p2) -> new AdvantageScore(p1)),
    ADVANTAGE_PLAYER_TWO(Constants.AT_LEAST_THREE_POINTS_HAVE_BEEN_SCORED_BY_BOTH_PLAYERS_AND_PLAYER_TWO_HAS_ONE_MORE_POINT, (p1, p2) -> new AdvantageScore(p2));

    private final BiPredicate<Player, Player> predicate;
    private final BiFunction<Player, Player, ScoreSystem> function;

    ScoreRules(BiPredicate<Player, Player> predicate, BiFunction<Player, Player, ScoreSystem> function) {
        this.predicate = predicate;
        this.function = function;
    }

    public ScoreSystem score(Player p1, Player p2) {
        return function.apply(p1, p2);
    }

    public BiPredicate<Player, Player> predicate() {
        return predicate;
    }

    private static class Constants {
        public static final BiPredicate<Player, Player> RUNNING_SCORE = (p1, p2) ->
                Constants.AT_LEAST_THREE_POINTS_HAVE_BEEN_SCORED_BY_BOTH_PLAYERS_AND_SCORES_IS_EQUAL.negate().test(p1, p2)
                        && Constants.PLAYER_ONE_HAS_FOUR_POINTS_AND_PLAYER_TWO_HAS_LESS_THAN_THREE_POINTS.negate().test(p1, p2)
                        && Constants.PLAYER_TWO_HAS_FOUR_POINTS_AND_PLAYER_ONE_HAS_LESS_THAN_THREE_POINTS.negate().test(p1, p2)
                        && Constants.AT_LEAST_THREE_POINTS_HAVE_BEEN_SCORED_BY_BOTH_PLAYERS_AND_PLAYER_ONE_HAS_ONE_MORE_POINT.negate().test(p1, p2)
                        && Constants.AT_LEAST_THREE_POINTS_HAVE_BEEN_SCORED_BY_BOTH_PLAYERS_AND_PLAYER_TWO_HAS_ONE_MORE_POINT.negate().test(p1, p2);
        public static final BiPredicate<Player, Player> AT_LEAST_THREE_POINTS_HAVE_BEEN_SCORED_BY_BOTH_PLAYERS_AND_SCORES_IS_EQUAL = (p1, p2) -> Point.THREE.test(p1) && Point.THREE.test(p2);
        public static final BiPredicate<Player, Player> PLAYER_ONE_HAS_FOUR_POINTS_AND_PLAYER_TWO_HAS_LESS_THAN_THREE_POINTS = (p1, p2) -> Point.FOUR.test(p1) && Point.FOUR.or(Point.THREE).negate().test(p2);
        public static final BiPredicate<Player, Player> PLAYER_TWO_HAS_FOUR_POINTS_AND_PLAYER_ONE_HAS_LESS_THAN_THREE_POINTS = (p1, p2) -> Point.FOUR.test(p2) && Point.FOUR.or(Point.THREE).negate().test(p1);
        public static final BiPredicate<Player, Player> AT_LEAST_THREE_POINTS_HAVE_BEEN_SCORED_BY_BOTH_PLAYERS_AND_PLAYER_ONE_HAS_ONE_MORE_POINT = (p1, p2) -> Point.FOUR.test(p1) && Point.THREE.test(p2);
        public static final BiPredicate<Player, Player> AT_LEAST_THREE_POINTS_HAVE_BEEN_SCORED_BY_BOTH_PLAYERS_AND_PLAYER_TWO_HAS_ONE_MORE_POINT = (p1, p2) -> Point.FOUR.test(p2) && Point.THREE.test(p1);
    }
}
