package BuzzLogic.Rounds;

public  class Round {
    private  String type;

    public  Round(String type)
    {
        this.type=type;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Correct Answer round
     * If it is correct add 1000
     * @param correct
     * @return
     */
    public int calculateBonus(boolean correct)
    {
        if(correct)
            return 1000;
        return 0;
    }

    /**
     * Bet type round
     * @param bet_option the bet
     * @param correct isCorrect
     * @return
     */
    public int calculateBonus(String bet_option,boolean correct)
    {
        if(bet_option.equals("250"))
        {
            if(correct)
                return 250;
            return -250;
        }
        else if(bet_option.equals("500"))
        {
            if(correct)
                return 500;
            return -500;
        }
        else if(bet_option.equals("750"))
        {
            if(correct)
                return 750;
            return -750;
        }
        else
        if(correct)
            return 1000;
        return -1000;
    }
}
