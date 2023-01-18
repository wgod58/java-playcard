/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo2;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String name;
    private ArrayList<Card> cards;
    private Random rand = new Random();

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand() {
        return cards;
    }

    public void setHand(ArrayList<Card> hand) {
        this.cards = hand;
    }

    public Card playCard() {
        if (cards.size() == 0) {
            System.out.println(name + " doesn't have any card left!");
            return null;
        }
        int index = rand.nextInt(cards.size());
        Card cardToPlay = cards.remove(index);
        return cardToPlay;
    }

    public String toString() {
        return name;
    }
}