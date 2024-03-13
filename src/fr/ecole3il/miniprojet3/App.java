package fr.ecole3il.miniprojet3;

import fr.ecole3il.miniprojet3.Controleur.*;
import fr.ecole3il.miniprojet3.Modele.*;
import fr.ecole3il.miniprojet3.Vue.*;
import fr.ecole3il.miniprojet3.Utils.FichierMotsHandler;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        // Création d'une instance de modèle Pendu

        FichierMotsHandler handler = new FichierMotsHandler("./mots.txt");

        Pendu modele = new Pendu(handler.getMotAleatoire());

        // Création de l'instance de la vue PenduVue
        PenduVue vue = new PenduVue(modele);

        // Création de l'instance du contrôleur PenduControleur
        PenduControleur controleur = new PenduControleur(modele, vue);

        // Création de la fenêtre Swing pour afficher la vue
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(vue);
            }
        });
    }

    private static void createAndShowGUI(PenduVue vue) {
        // Création de la fenêtre Swing pour afficher la vue
        JFrame frame = new JFrame("Jeu du pendu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vue);
        frame.pack();
        frame.setVisible(true);
    }
}
