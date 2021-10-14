package fr.zbar.codingdojo.tenniskata.score;

public record DeuceScore() implements ScoreSystem {

    @Override
    public String getScore() {
        return "Deuce";
    }
}
