package fr.ecole3il.miniprojet3.Game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * La classe Pendu représente le jeu du pendu où les joueurs tentent de deviner
 * un mot en proposant des lettres.
 */
public class Pendu {

    private List<Character> letters; // List to store the letters of the word
    private Set<Character> guesses; // Set to store the letters guessed by the player
    private int nombreEssais; // Number of attempts made by the player
    private boolean partieFinie; // Indicates if the game is over

    /**
     * Constructor for Pendu class.
     *
     * @param mot The word to be guessed.
     */
    public Pendu(String mot) {
        this.letters = initLetters(mot); // Initialize the letters of the word
        this.guesses = new HashSet<>(); // Initialize the set of guessed letters
        this.nombreEssais = 0; // Initialize the number of attempts made
        this.partieFinie = false; // Initialize the game state to not finished
    }

    /**
     * Initialize the letters of the word by filtering out non-letter characters.
     *
     * @param mot The word to be guessed.
     * @return List of letters in the word.
     */
    private List<Character> initLetters(String mot) {
        List<Character> originalLetters = new ArrayList<>();
        for (char c : mot.toCharArray()) {
            if (Character.isLetter(c)) {
                originalLetters.add(c);
            }
        }
        return originalLetters;
    }

    /**
     * Method for making a guess.
     *
     * @param lettre The letter guessed by the player.
     * @return An integer representing the result of the guess:
     *         0 if the letter was already guessed,
     *         1 if the guess was correct,
     *         2 if the guess was incorrect but the game continues,
     *         3 if the guess was incorrect and the game is over,
     *         4 if the input is not a letter.
     */
    public int guess(char lettre) {
        if (Character.isLetter(lettre)) {
            lettre = Character.toLowerCase(lettre);
            if (guesses.contains(lettre)) {
                return 0;
            }

            guesses.add(lettre);

            if (letters.contains(lettre)) {
                if (guesses.containsAll(letters)) {
                    partieFinie = true;
                    return 5;
                }
                return 1;
            } else {
                nombreEssais++;
                if (nombreEssais >= 10) {
                    partieFinie = true;
                    return 3;
                } else {
                    return 2;
                }
            }
        } else {
            return 4;
        }
    }

    /**
     * Get the word to be guessed with the letters already guessed filled in.
     *
     * @return The word to be guessed with the letters already guessed filled in.
     */
    public String getMot() {
        StringBuilder motReconstruit = new StringBuilder();
        for (char c : letters) {
            if (Character.isLetter(c) && guesses.contains(Character.toLowerCase(c))) {
                motReconstruit.append(c);
            } else {
                motReconstruit.append('_');
            }
        }
        return motReconstruit.toString();
    }

    /**
     * Get the original word to be guessed.
     *
     * @return The original word to be guessed.
     */
    public String getMotClair() {
        StringBuilder motReconstruit = new StringBuilder();
        for (char c : letters) {
            motReconstruit.append(c);
        }
        return motReconstruit.toString();
    }

    /**
     * Get the number of attempts made.
     *
     * @return The number of attempts made.
     */
    public int getNombreEssais() {
        return nombreEssais;
    }

    /**
     * Get the set of letters already guessed.
     *
     * @return The set of letters already guessed.
     */
    public Set<Character> getGuesses() {
        return guesses;
    }

    /**
     * Check if the game is over.
     *
     * @return true if the game is over, false otherwise.
     */
    public boolean ispartieFinie() {
        return partieFinie;
    }
}
