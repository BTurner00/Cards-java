package com.theironyard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    static HashSet<Card> createDeck() {
        HashSet<Card> deck = new HashSet<>();
        for(Card.Suit suit : Card.Suit.values()) {
            for(Card.Rank rank : Card.Rank.values()){
                Card c = new Card(suit,rank);
                deck.add(c);
            }
        }
        return deck;
    }

    static HashSet<HashSet<Card>> createHands(HashSet<Card> deck) {
        HashSet<HashSet<Card>> hands = new HashSet<>();
        for (Card c1: deck) {
            HashSet<Card> deck2 = (HashSet<Card>) deck.clone();
            deck2.remove(c1);
            for (Card c2 : deck2) {
                HashSet<Card> deck3 = (HashSet<Card>) deck2.clone();
                deck3.remove(c2);
                for (Card c3: deck3) {
                    HashSet<Card> deck4 = (HashSet<Card>) deck3.clone();
                    deck4.remove(c3);
                    for (Card c4: deck4) {
                        HashSet<Card> hand = new HashSet<>();
                        hand.add(c1);
                        hand.add(c2);
                        hand.add(c3);
                        hand.add(c4);
                        hands.add(hand);
                    }
                }
            }
        }
        return hands;
    }

    static boolean isFlush(HashSet<Card> hand) {
        HashSet<Card.Suit> suits = hand.stream()
                .map(card -> card.suit)
                .collect(Collectors.toCollection(HashSet<Card.Suit>::new));
        return suits.size() == 1;
    }

    static boolean isStraight(HashSet<Card> hand) {
        ArrayList<Integer> ranks = hand.stream()
                .map(card -> card.rank.ordinal())
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
        Collections.sort(ranks);
        HashSet<Integer> numRanks = new HashSet<>(ranks);
        boolean straight = ranks.get(3) - ranks.get(0) == 3 && numRanks.size() == 4;
        return straight && !isFlush(hand);
    }

    static boolean isStraightFlush(HashSet<Card> hand) {
        ArrayList<Integer> ranks = hand.stream()
                .map(card -> card.rank.ordinal())
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
        Collections.sort(ranks);
        HashSet<Integer> numRanks = new HashSet<>(ranks);
        boolean straight = ranks.get(3) - ranks.get(0) == 3 && numRanks.size() == 4;
        return isFlush(hand) && straight;
    }

    static boolean isFourOfAKind(HashSet<Card> hand) {
        int i= 0;
        Card prev = null;
        for (Card card: hand) {
            if ( i!= 0) {
                if (card.rank !=prev.rank ) {
                    return false;
                }
            }
            prev  = card;
            i++;
        }
        return true;
    }

    static boolean isThreeOfAKind(HashSet<Card> hand) {
        ArrayList<Integer> ranks = hand.stream()
                .map(card -> card.rank.ordinal())
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
        int[] freqs = new int[13];
        for (int rank: ranks) {
            freqs[rank]++;
        }
        for (int freq: freqs) {
            if (freq == 3 && !isFourOfAKind(hand)) {
                return true;
            }
        }
        return false;
    }

    static boolean isTwoPair(HashSet<Card> hand) {
        ArrayList<Integer> ranks = hand.stream()
                .map(card -> card.rank.ordinal())
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
        int[] freqs = new int[13];
        for (int rank: ranks) {
            freqs[rank]++;
        }

        int[] freqsOfFreqs = new int[5];
        for (int freq : freqs){
            freqsOfFreqs[freq]++;
        }


        return freqsOfFreqs[2] == 2;
    }

    public static void main(String[] args) {
        HashSet<Card> deck = createDeck();
        HashSet<HashSet<Card>> hands = createHands(deck);/*
        HashSet<HashSet<Card>> flushes = hands.stream()
                .filter(Main::isFlush)
                .collect(Collectors.toCollection(HashSet<HashSet<Card>>::new));

        HashSet<HashSet<Card>> fourOfAKind = hands.stream()
                .filter(Main::isFourOfAKind)
                .collect(Collectors.toCollection(HashSet<HashSet<Card>>::new));
        HashSet<HashSet<Card>> threeOfAKind = hands.stream()
                .filter(Main::isThreeOfAKind)
                .collect(Collectors.toCollection(HashSet<HashSet<Card>>::new));
        HashSet<HashSet<Card>> twoPair = hands.stream()
                .filter(Main::isTwoPair)
                .collect(Collectors.toCollection(HashSet<HashSet<Card>>::new));
        HashSet<HashSet<Card>> straight = hands.stream()
                .filter(Main::isStraight)
                .collect(Collectors.toCollection(HashSet<HashSet<Card>>::new));
        HashSet<HashSet<Card>> straightFlush = hands.stream()
                .filter(Main::isStraightFlush)
                .collect(Collectors.toCollection(HashSet<HashSet<Card>>::new));

        System.out.println(flushes.size());*/

    }
}
