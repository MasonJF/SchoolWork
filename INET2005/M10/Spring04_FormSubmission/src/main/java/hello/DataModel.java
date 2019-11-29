package hello;

public class DataModel {

    private String sessionId;
    private long sessionGuess;
    private int sessionWin;
    private int gameNumber;

    public DataModel(String sessionId, int gameNumber, long sessionGuess, int sessionWin) {
        this.sessionId = sessionId;
        this.sessionGuess = sessionGuess;
        this.sessionWin = sessionWin;
        this.gameNumber = gameNumber;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "sessionId=" + sessionId +
                ", Number to guess=" + gameNumber +
                ", sessionGuess='" + sessionGuess + '\'' +
                ", sessionWin=" + sessionWin;
    }

    public String getSessionId() {
        return sessionId;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public long getSessionGuess() {
        return sessionGuess;
    }

    public void setSessionGuess(long sessionGuess) {
        this.sessionGuess = sessionGuess;
    }

    public int getSessionWin() {
        return sessionWin;
    }

    public void setSessionWin(int sessionWin) {
        this.sessionWin = sessionWin;
    }
}
