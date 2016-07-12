package com.theironyard;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ben on 7/12/16.
 */
public class MainTest {
    /*HashSet<Card> deck = Main.createDeck();
    HashSet<HashSet<Card>> hands = Main.createHands(deck);*/

    @Test
    public void testIsFlush() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.THREE));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.KING));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        boolean value = Main.isFlush(hand);
        assertTrue(value);
    }

    @Test
    public void testIsStraight() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.THREE));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR));
        boolean value = Main.isStraight(hand);
        assertTrue(value);
    }

    @Test
    public void testIsStraightFlush() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.THREE));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR));
        boolean value = Main.isStraightFlush(hand);
        assertTrue(value);
    }

    @Test
    public void testIsFourOfAKind() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        boolean value = Main.isFourOfAKind(hand);
        assertTrue(value);
    }

    @Test
    public void testIsThreeOfAKind() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        boolean value = Main.isThreeOfAKind(hand);
        assertTrue(value);
    }

    @Test
    public void testIsTwoPair() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.TWO));
        hand.add(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        boolean value = Main.isTwoPair(hand);
        assertTrue(value);
    }
}


