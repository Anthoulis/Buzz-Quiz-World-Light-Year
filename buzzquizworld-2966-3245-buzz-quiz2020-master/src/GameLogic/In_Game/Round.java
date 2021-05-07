package GameLogic.In_Game;

public abstract class Round {
    protected String type;
    protected int bonus;

    public Round()
    {
        type="";
        bonus=0;
    }
    //type
    public String getType() {
        return type;
    }
    //Bonus
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    public int getBonus() {
        return bonus;
    }
}
