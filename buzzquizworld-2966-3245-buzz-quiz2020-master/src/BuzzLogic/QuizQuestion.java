package BuzzLogic;

public class QuizQuestion {
    private String category;
    private String question;
    private String[] answer;
    private String correct_answer;
    private String picture;

    /**
     * Default constructor that inserts default values
     */
    public QuizQuestion()
    {
        category="Category";
        question ="Question";
        answer=new String[]{"Answer1","Answer2","Answer3","Answer4"};
        correct_answer ="Answer1";
        picture="false";
    }

    /**
     * The purpose of this constructor is to help us create a Question object that gets its values from a String array.
     * This will be useful when reading a line from a text file and splitting that line in  8 Strings.
     * @param total
     */
    public QuizQuestion(String[]total)
    {
        this.category=total[0];
        this.question =total[1];
        this.answer= new String[4];
        answer[0]=total[2];
        answer[1]=total[3];
        answer[2]=total[4];
        answer[3]=total[5];
        this.correct_answer =total[6];
        this.picture=total[7];
    }
    public QuizQuestion(String category, String the_question, String[]answer, String correct_answer, String picture)
    {
        this.category=category;
        this.question =the_question;
        this.answer=answer;
        this.correct_answer =correct_answer;
        this.picture=picture;
    }
    //Category
    public String getCategory() { return category; }
    //Question
    public String getQuestion() { return question; }
    //Answers
    public String[] getAnswer() { return answer; }
    //Correct answer
    public String getCorrect_answer() { return correct_answer; }
    //Picture
    public String getPicture() { return picture; }

}
