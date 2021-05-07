package GameLogic.In_Game;

import java.util.Scanner;

public class QuizQuestion {
    private String category;
    private String question;
    private String[] answer;
    private String correctanswer;
    private String picture;

    public QuizQuestion() //Default values
    {
        category="";
        question ="";
        answer=new String[]{"","","",""}; //If we want to change the number of answers in the future we just add a new private int variable for the size of the array
        correctanswer="";
        picture=""; //If picture.equals("") then it means it has no picture;
    }

    public QuizQuestion(String[]total)
    {
        this.category=total[0];
        this.question =total[1];
        this.answer= new String[4];
        answer[0]=total[2];
        answer[1]=total[3];
        answer[2]=total[4];
        answer[3]=total[5];
        this.correctanswer=total[6];
        this.picture=total[7];
    }
    public QuizQuestion(String category, String thequestion, String[]answer, String correctanswer, String picture)
    {
        this.category=category;
        this.question =thequestion;
        this.answer=answer;
        this.correctanswer=correctanswer;
        this.picture=picture;
    }
    //Category
    public String getCategory() { return category; }
    //Question
    public String getQuestion() { return question; }
    //Answers
    public String[] getAnswer() { return answer; }
    //Correct answer
    public String getCorrectanswer() { return correctanswer; }
    //Picture
    public String getPicture() { return picture; }

    //Useful Command Line Methods
    public void show()
    {
        System.out.println("|                                                |");
        System.out.println("| Category : "+category);
        System.out.println("| "+question);
        System.out.println("| 0 "+answer[0]);
        System.out.println("| 1 "+answer[1]);
        System.out.println("| 2 "+answer[2]);
        System.out.println("| 3 "+answer[3]);
        System.out.println("|Enter answer 0 1 2 or 3");
        System.out.println("+------------------------------------------------+");
    }

}
