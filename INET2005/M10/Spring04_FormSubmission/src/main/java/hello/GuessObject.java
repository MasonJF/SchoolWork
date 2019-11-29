package hello;

public class GuessObject {
    private int guess;
    private int incorrectCount = 0;
    private int cheater;


    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getIncorrectCount() {
        if(incorrectCount != null) {
            return incorrectCount;
        }

    }

    public void setIncorrectCount(int incorrectCount) {
        this.incorrectCount = incorrectCount;
    }

    public int getCheater() {
        return cheater;
    }

    public void setCheater(int cheater) {
        this.cheater = cheater;
    }
}
