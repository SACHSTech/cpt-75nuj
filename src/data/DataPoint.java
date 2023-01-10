package data;

public class DataPoint {
    private String rank;
    private String playerName;
    private int fromYear;
    private int toYear;
    private int gamesPlayed;
    private double minutesPlayed;
    private double ppg;
    private double rpg;
    private double apg;
    private double spg;
    private double bpg;
    private double fgPercent;
    private double threePointPercent;
    private double freeThrowPercent;
    private double careerWinShares;
    private double winSharesPer;
    private String bRefTag;
    private int addingTag;

    /**
     * starts of datapoint tag as 0
     */
    public DataPoint() {
        addingTag = 0;
    }
    public void add() {

    }
}
