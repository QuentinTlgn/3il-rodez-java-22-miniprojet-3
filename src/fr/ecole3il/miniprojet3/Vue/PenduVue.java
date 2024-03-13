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
    private JLabel messageLabel;

    public PenduVue(Pendu modele) {
        this.modele = modele;

        setLayout(null); // Nous désactivons le layout manager par défaut

        setBackground(Color.WHITE);

        // Création du label pour afficher un message en haut de la fenêtre
        messageLabel = new JLabel("Faites votre premier guess");
        messageLabel.setBounds(10, 10, 280, 25); // Définition de la position et de la taille
        add(messageLabel);

        // Création du champ de saisie
        guessField = new JTextField();
        guessField.setBounds(10, 40, 150, 25); // Définition de la position et de la taille
        add(guessField);

        // Création du bouton pour soumettre une lettre
        submitButton = new JButton("Soumettre");
        submitButton.setBounds(170, 40, 120, 25); // Définition de la position et de la taille
        add(submitButton);

        // Création du label pour afficher le mot
        motLabel = new JLabel("");
        motLabel.setBounds(10, 70, 280, 25); // Définition de la position et de la taille
        add(motLabel);

        // Définition de la taille fixe
        setPreferredSize(new Dimension(300, 100)); // Largeur: 300 pixels, Hauteur: 100 pixels
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
        repaint();
    }

    public void setMessage(String text){
        messageLabel.setText(text);
        repaint();
    }

    public void disableAllInputs(){
        submitButton.setEnabled(false);
        guessField.setEnabled(false);
    }

    public static void main(String[] args) {
        // Création d'une instance de modèle Pendu
        Pendu modele = new Pendu("hello");

        // Création de l'instance de la vue PenduVue
        PenduVue vue = new PenduVue(modele);

        // Création de la fenêtre Swing pour afficher la vue
        JFrame frame = new JFrame("Jeu du pendu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vue);
        frame.pack();
        frame.setVisible(true);
    }
}
