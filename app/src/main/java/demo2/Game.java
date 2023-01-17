package demo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    private int numberOfRounds;
    private Map<Player, Integer> scores;

    // constructor
    public Game(int numberOfPlayers) {
        this.players = new ArrayList<Player>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("player" + i));
        }
        this.deck = new Deck();
        this.numberOfRounds = 0;
        this.scores = new HashMap<Player, Integer>();
        for (Player player : players) {
            scores.put(player, 0);
        }
    }

    // start
    public void start(int numberOfCards) {
        deck.shuffle();
        deck.dealCards(players, numberOfCards);
        while (!isGameOver()) {
            playRound();
        }
        determineWinner();
        printHistory();
    }

    // playRound
    public void playRound() {
        numberOfRounds++;
        System.out.println("Round " + numberOfRounds);
        Card winningCard = null;
        Player winningPlayer = null;
        for (Player player : players) {
            Card card = player.playCard();
            System.out.println(player + " plays " + card);
            if (winningCard == null || card.compareTo(winningCard)) {
                winningCard = card;
                winningPlayer = player;
            }
        }
        System.out.println(winningPlayer + " wins with " + winningCard);
        scores.put(winningPlayer, scores.get(winningPlayer) + 1);
    }

    // isGameOver
    public boolean isGameOver() {
        for (Player player : players) {
            if (player.getHand().size() == 0) {
                return true;
            }
        }
        return false;
    }

    // determineWinner
    public void determineWinner() {
        int maxScore = 0;
        ArrayList<Player> winners = new ArrayList<>();
        for (Player player : scores.keySet()) {
            int playerScore = scores.get(player);
            if (playerScore > maxScore) {
                maxScore = playerScore;
                winners.clear();
                winners.add(player);
            } else if (playerScore == maxScore) {
                winners.add(player);
            }
        }
        if (winners.size() > 1) {
            System.out.println("It's a tie between: ");
            for (Player winner : winners) {
                System.out.println(winner);
            }
        } else {
            System.out.println("The winner is: " + winners.get(0));
        }
    }

    // printHistory
    public void printHistory() {
        System.out.println("Number of rounds: " + numberOfRounds);
        for (Player player : players) {
            System.out.println(player + ": " + scores.get(player) + " points");
        }
    }

    public Map<Player, Integer> getScores() {
        return scores;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
