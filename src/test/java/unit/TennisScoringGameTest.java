package unit;

import fr.zbar.codingdojo.tenniskata.TennisScoringGame;
import fr.zbar.codingdojo.tenniskata.player.Player;
import fr.zbar.codingdojo.tenniskata.player.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisScoringGameTest {

    @ParameterizedTest(name = "When Player One has \"{0}\" & Player Two has \"{1}\", score should be \"{2}\"")
    @CsvSource({
            "ZERO,ZERO,Love - Love",
            "ONE,ZERO,15 - Love",
            "TWO,ZERO,30 - Love",
            "THREE,ZERO,40 - Love",
            "ZERO,ONE,Love - 15",
            "ZERO,TWO,Love - 30",
            "ZERO,THREE,Love - 40",
            "ONE,ONE,15 - 15",
            "TWO,TWO,30 - 30",
            "THREE,THREE,Deuce",
            "ONE,TWO,15 - 30",
            "TWO,ONE,30 - 15",
            "THREE,TWO,40 - 30",
            "TWO,THREE,30 - 40",
            "FOUR,ZERO,Player One wins",
            "ZERO,FOUR,Player Two wins",
            "FOUR,TWO,Player One wins",
            "TWO,FOUR,Player Two wins",
            "FOUR,THREE,Advantage player One",
            "THREE,FOUR,Advantage player Two"
    })
    public void should_display_score(String playerOnePoint, String playerTwoPoint, String expectedScore) {
        Player playerOne = new Player("One", Point.valueOf(playerOnePoint));
        Player playerTwo = new Player("Two", Point.valueOf(playerTwoPoint));
        TennisScoringGame game = new TennisScoringGame(playerOne, playerTwo);

        String score = game.getScore();

        assertThat(score).isEqualTo(expectedScore);
    }
}
