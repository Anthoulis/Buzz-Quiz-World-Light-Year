package BuzzLogic;

/**
 * This class represents the Settings of the Game who are initiated from The Game Menu
 * @author Giannis Anthoulis 2966
 * @author Alexandros Seremetas Mpildiris 3245
 */
public class Settings {
    private final int rounds;
    private final int questions_per_round;
    private final int numberOfQuestions;
    private final String mode;

    public Settings(int rounds, int questions_per_round, String mode) {
        this.rounds = rounds;
        this.questions_per_round = questions_per_round;
        this.numberOfQuestions=rounds*questions_per_round;
        if(mode.equals("1")||mode.equals("SINGLE")||mode.equals("Single")||mode.equals("single"))
        {
            this.mode="single";
        }
        else
        {
            this.mode="two";
        }
    }
    public int getRounds() {
        return rounds;
    }
    public int getQuestions_per_round() {
        return questions_per_round;
    }
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
    public String getMode() {
        return mode;
    }
}
