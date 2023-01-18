package demo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;

    // constructor
    public Deck() {
        cards = new ArrayList<Card>();

        for (Suit suit : Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(i, suit));
            }
        }
    }

    // shuffle method
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // dealCards
    public void dealCards(ArrayList<Player> players, int numberOfCards) {
        Random rand = new Random();
        for (Player player : players) {
            ArrayList<Card> hand = new ArrayList<>();
            int getCardsNum = rand.nextInt(numberOfCards) + 1;
            for (int i = 0; i < getCardsNum; i++) {
                hand.add(cards.remove(0));
            }
            player.setHand(hand);
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
