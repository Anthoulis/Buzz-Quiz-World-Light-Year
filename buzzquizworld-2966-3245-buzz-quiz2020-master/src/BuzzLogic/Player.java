package BuzzLogic;

public class Player {
    private final String name;
    private boolean answer_given;
    private String answer;
    private int score;
    /*private KeyCode [] controls;
    For future upgrade we will let player to change his control settings
    */
    public Player(String name)
    {
        this.name=name;
        answer_given =false;
        answer="";
        score=0;
    }
    public String getName() {
        return name;
    }
    //Answered
    public boolean isAnswer_given() {
        return answer_given;
    }
    public void setAnswer_given(boolean answer_given) {
        this.answer_given = answer_given;
    }
    //Answer
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    //Score
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
