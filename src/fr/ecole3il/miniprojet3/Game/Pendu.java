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

    private List<Character> letters;
    private Set<Character> guesses;
    private int nombreEssais;
    private boolean partieFinie;

    public Pendu(String mot) {
        this.letters = initLetters(mot);
        this.guesses = new HashSet<>();
        this.nombreEssais = 0;
        this.partieFinie = false;
    }

    private List<Character> initLetters(String mot) {
        List<Character> originalLetters = new ArrayList<>();
        for (char c : mot.toCharArray()) {
            if (Character.isLetter(c)) {
                originalLetters.add(c);
            }
        }
        return originalLetters;
    }

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
     * Donne le mot à deviner avec les lettres déjà trouvées.
     *
     * @return Le mot à deviner avec les lettres déjà trouvées.
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
     * Donne le mot à deviner.
     *
     * @return Le mot à deviner.
     */
    public String getMotClair() {
        StringBuilder motReconstruit = new StringBuilder();
        for (char c : letters) {
            motReconstruit.append(c);
        }
        return motReconstruit.toString();
    }

    /**
     * Donne le nombre d'essais effectués.
     *
     * @return Le nombre d'essais effectués.
     */
    public int getNombreEssais() {
        return nombreEssais;
    }

    /**
     * Donne les lettres déjà proposées.
     *
     * @return Les lettres déjà proposées.
     */
    public Set<Character> getGuesses() {
        return guesses;
    }

    /**
     * Indique si la partie est finie.
     *
     * @return true si la partie est finie, false sinon.
     */
    public boolean ispartieFinie() {
        return partieFinie;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        // Choisissez un mot à deviner
        System.out.print("Entrez le mot à deviner : ");
        String motADeviner = scanner.nextLine();

        // Créez une instance de la classe Pendu
        Pendu jeuPendu = new Pendu(motADeviner);

        // Boucle principale du jeu
        while (!jeuPendu.ispartieFinie()) {
            // Affichez l'état actuel du mot à deviner
            System.out.println("Mot actuel : " + jeuPendu.getMot());

            // Affichez les lettres déjà proposées
            System.out.println("Lettres proposées : " + jeuPendu.getGuesses());

            // Demandez au joueur de deviner une lettre
            System.out.print("Devinez une lettre : ");
            char lettre = scanner.nextLine().toLowerCase().charAt(0);

            System.out.println(lettre);

            // Effectuez la tentative
            int resultatTentative = jeuPendu.guess(lettre);

            // Affichez le résultat de la tentative
            switch (resultatTentative) {
                case 0:
                    System.out.println("Lettre déjà proposée. Essayez encore.");
                    break;
                case 1:
                    System.out.println("Bonne devinette !");
                    break;
                case 2:
                    System.out.println("Lettre incorrecte. Essais restants : " + (10 - jeuPendu.getNombreEssais()));
                    break;
                case 3:
                    System.out.println(
                            "Vous avez dépassé le nombre maximal d'essais. Le mot était : " + jeuPendu.getMotClair());
                    break;
                case 4:
                    System.out.println("Entrée non valide. Veuillez entrer une lettre alphabétique.");
                    break;
                case 5:
                    System.out.println("Félicitations ! Vous avez deviné le mot : " + jeuPendu.getMotClair());
                    break;
            }
        }

        // Fermez le scanner
        scanner.close();
    }
}
