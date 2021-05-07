package GameLogic.In_Game;

public class BetRound extends Round {
    private final String [] betoptions;

    public BetRound()
    {
        super();
        type="Bet Round";
        betoptions=new String[4];
        betoptions[0]="250";
        betoptions[1]="500";
        betoptions[2]="750";
        betoptions[3]="1000";
    }
    //Bet Options
    public String[] getBetoptions() {
        return betoptions;
    }
    //Methods

    /**
     * Setting the bonus depending on the bet selected and the answer given, if it is correct or not
     * @param bet
     * @param correct
     */

    public void setBonus(String bet, boolean correct) {
        if(correct)
        {
            if(bet.equals(betoptions[0]))
            {
                bonus=250;
            }
            else if(bet.equals(betoptions[1]))
            {
                bonus=500;
            }
            else if(bet.equals(betoptions[1]))
            {
                bonus=750;
            }
            else if(bet.equals(betoptions[1]))
            {
                bonus=1000;
            }
            else
            {
                System.out.println("Error setting bonus");
                System.exit(1);
            }
        }
        else
        {
            if(bet.equals(betoptions[0]))
            {
                bonus=-250;
            }
            else if(bet.equals(betoptions[1]))
            {
                bonus=-500;
            }
            else if(bet.equals(betoptions[1]))
            {
                bonus=-750;
            }
            else if(bet.equals(betoptions[1]))
            {
                bonus=-1000;
            }
            else
            {
                System.out.println("Error setting bonus");
                System.exit(1);
            }
        }
    }

    //Useful Command Line Methods
    public void show()
    {
        {
            System.out.println("+------------------------------------------------+");
            System.out.println("|                 Bet Round                      |");
            System.out.println("|                                                |");
            System.out.println("| Place you bet       250  500  750  1000        |");
            System.out.println("|                                                |");
            System.out.println("| Enter the number you want to bet according to  |");
            System.out.println("| the above options!                             |");
            System.out.println("|                                                |");
        }
    }
    public void showPress()
    {
        System.out.println("Press 100 or 250 or 500 or 750 or 1000");
    }
}
