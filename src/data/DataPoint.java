package data;

public class DataPoint {
    private int rank;
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
        this.addingTag = 0;
    }

    public void add(String value) {
        switch(addingTag) {
            case 0:
                this.rank = Integer.parseInt(value);
                break;
            case 1:
                this.playerName = value;
                break;
            case 2:
                this.fromYear = Integer.parseInt(value);
                break;
            case 3:
                this.toYear = Integer.parseInt(value);
                break;
            case 4:
                this.gamesPlayed = Integer.parseInt(value);
                break;
            case 5:
                this.minutesPlayed = Double.parseDouble(value); 
                break;
            case 6:
                this.ppg = Double.parseDouble(value); 
                break;
            case 7:
                this.rpg = Double.parseDouble(value); 
                break;
            case 8:
                this.apg = Double.parseDouble(value); 
                break;
            case 9:
                this.spg = Double.parseDouble(value); 
                break;
            case 10:
                this.bpg = Double.parseDouble(value); 
                break;
            case 11:
                this.fgPercent = Double.parseDouble(value); 
                break;
            case 12:
                this.threePointPercent = Double.parseDouble(value); 
                break;
            case 13:
                this.freeThrowPercent = Double.parseDouble(value); 
                break;
            case 14:
                this.careerWinShares = Double.parseDouble(value);
                break;
            case 15:
                this.winSharesPer = Double.parseDouble(value);
                break;
            case 16:
                this.bRefTag = value;
                break;
        }

        this.addingTag++;
    }

    public int getRank() {
        return this.rank;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getFromYear() {
        return this.fromYear;
    }

    public int getToYear() {
        return this.toYear;
    }

    

    

    



}
