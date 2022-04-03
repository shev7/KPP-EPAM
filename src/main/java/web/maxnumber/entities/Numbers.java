package web.maxnumber.entities;

import java.util.Objects;

public class Numbers {
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public Numbers(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        if (other == null || getClass() != other.getClass()) return false;

        Numbers that = (Numbers)other;

        return Integer.compare(that.firstNumber, firstNumber) == 0
                && Integer.compare(that.secondNumber, secondNumber) == 0
                && Integer.compare(that.thirdNumber, thirdNumber) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNumber, secondNumber, thirdNumber);
    }
}
