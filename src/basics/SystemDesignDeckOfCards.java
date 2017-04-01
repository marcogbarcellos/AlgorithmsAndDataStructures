/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basics;

import java.util.ArrayList;

/**
 *
 * @author marco
 */
enum SUIT {
    CLUBS, DIAMONDS, HEARTS, SPADES;
}
interface CardInterface {
    public int getNumber();
    public SUIT getSuit();
}
abstract class CardAbstract implements CardInterface{
    protected SUIT suit;
    protected int number;
    
    public CardAbstract(SUIT suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    @Override
    public int getNumber() {
        return this.number;
    }
    @Override
    public SUIT getSuit() {
        return this.suit;
    }
}
class Card extends CardAbstract{
    public Card(SUIT suit, int number) {
        super(suit, number);
    }
}
class BlackJackCard extends CardAbstract{
    public BlackJackCard(SUIT suit, int number) {
        super(suit, number);
    }
    
    public int getBlackJackValue() {
        if (number == 1) {
           return 11; 
        }
        if(number<10) {
            return number;
        }
        return 10;
    }
    public boolean isAce() {
        return number == 1;
    }
}
interface DeckInterface {
    public ArrayList<CardInterface> getCards();
}
abstract class DeckAbstract implements DeckInterface {
    protected ArrayList<CardInterface> cards;
    
    public DeckAbstract(ArrayList<CardInterface> cards) {
        this.cards = cards;
    }
}
class Deck extends DeckAbstract {

    public Deck(ArrayList<CardInterface> cards) {
        super(cards);
    }

    @Override
    public ArrayList<CardInterface> getCards() {
        return this.cards;
    }
    
}
class BlackJackDeck extends DeckAbstract{
    private ArrayList<CardInterface> cards;

    public BlackJackDeck(ArrayList<CardInterface> cards) {
        super(cards);
    }

    @Override
    public ArrayList<CardInterface> getCards() {
        return this.cards;
    }
    
}
public class SystemDesignDeckOfCards {
    public static void main(String[] args) {
        
    }
}
