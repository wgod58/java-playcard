/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo2;

public enum Suit {
    CLUBS(1), DIAMONDS(2), HEARTS(3), SPADES(4);

    private int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}