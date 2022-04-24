package web.maxnumber.entities;

public class CustomNumber {
    private int number;
    private int counter;

    public CustomNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setMaxNumber(int number) {
        this.number = number;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}