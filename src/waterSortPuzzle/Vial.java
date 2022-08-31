package waterSortPuzzle;

public class Vial {

    private boolean isfull;
    private int numStuff;
    private char bottom;
    private char lower;
    private char upper;
    private char top;

    public Vial(char Top, char Upper, char Lower, char Bottom) {
        bottom= Bottom;
        lower= Lower;
        upper= Upper;
        top= Top;
        isfull= true;
        numStuff= 4;
    }

    public boolean isComplete(Vial vial) {
        if (bottom == top && bottom == lower && bottom == upper) { return true; }
        return false;
    }

    public String statement() {
        return (bottom + "" + lower + "" + upper + "" + top + "").toString();
    }

    public boolean isIsfull() {
        return isfull;
    }

    public void setIsfull(boolean isfull) {
        this.isfull= isfull;
    }

    public int getNumStuff() {
        return numStuff;
    }

    public void setNumStuff(int numStuff) {
        this.numStuff= numStuff;
    }

    public char getBottom() {
        return bottom;
    }

    public void setBottom(char bottom) {
        this.bottom= bottom;
    }

    public char getLower() {
        return lower;
    }

    public void setLower(char lower) {
        this.lower= lower;
    }

    public char getUpper() {
        return upper;
    }

    public void setUpper(char upper) {
        this.upper= upper;
    }

    public char getTop() {
        return top;
    }

    public void setTop(char top) {
        this.top= top;
    }

    public Vial() {
        bottom= 'z';
        lower= 'z';
        upper= 'z';
        top= 'z';
        isfull= false;
        numStuff= 0;
    }

}