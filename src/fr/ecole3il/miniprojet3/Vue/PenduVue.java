package fr.ecole3il.miniprojet3.Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import fr.ecole3il.miniprojet3.Modele.*;

public class PenduVue extends JPanel {
    private Pendu modele;
    private JTextField guessField;
    private JLabel motLabel;
    private JButton submitButton;

    public PenduVue(Pendu modele) {
        this.modele = modele;

        setBackground(Color.WHITE);

        // Création du champ de saisie
        guessField = new JTextField(3); // Limite de caractères à 1
        add(guessField);

        // Création du label pour afficher le texte modifiable
        motLabel = new JLabel("");
        motLabel.setVisible(false);
        add(motLabel);

        // Création du bouton pour soumettre une lettre
        submitButton = new JButton("Soumettre");
        add(submitButton);
    }

    public JTextField getGuessField() {
        return guessField;
    }

    public JLabel getMotLabel() {
        return motLabel;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    // Méthode pour récupérer le texte entré dans le champ de saisie
    public String getEnteredText() {
        return guessField.getText();
    }

    // Méthode pour définir le texte à afficher dans le label
    public void setMot(String text) {
        motLabel.setText(text);
        motLabel.setVisible(true);
        repaint();
    }

    public static void main(String[] args) {
        // Création d'une instance de modèle Pendu
        Pendu modele = new Pendu("hello");

        // Création de l'instance de la vue PenduVue
        PenduVue vue = new PenduVue(modele);

        // Création de la fenêtre Swing pour afficher la vue
        JFrame frame = new JFrame("Test PenduVue");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vue);
        frame.pack();
        frame.setVisible(true);
    }
}
