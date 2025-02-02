package fr.ecole3il.miniprojet3.Vue;

import javax.swing.*;
import java.awt.*;

import fr.ecole3il.miniprojet3.Modele.Pendu;

public class PenduVue extends JPanel {
    private Pendu modele;
    private JTextField guessField;
    private JLabel motLabel;
    private JButton submitButton;
    private JLabel messageLabel;
    private JLabel historyLabel;
    private JButton newGameButton;

    public PenduVue(Pendu modele) {
        this.modele = modele;

        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Création du label pour afficher un message en haut de la fenêtre
        messageLabel = new JLabel("Faites votre premier guess");
        add(messageLabel, gbc);

        // Création du champ de saisie
        gbc.gridy++;
        guessField = new JTextField(10);
        add(guessField, gbc);

        // Création du bouton pour soumettre une lettre
        gbc.gridy++;
        submitButton = new JButton("Soumettre");
        add(submitButton, gbc);

        // Création du label pour afficher le mot
        gbc.gridy++;
        motLabel = new JLabel("");
        add(motLabel, gbc);

        // Création du label pour afficher l'historique
        gbc.gridy++;
        historyLabel = new JLabel("Historique : ");
        add(historyLabel, gbc);

        // Création du bouton pour commencer une nouvelle partie
        gbc.gridy++;
        newGameButton = new JButton("Nouvelle partie");
        newGameButton.setVisible(false);
        add(newGameButton, gbc);

        // Définition de la taille fixe
        setPreferredSize(new Dimension(800, 350)); // Largeur: 800 pixels, Hauteur: 300 pixels
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

    public void setMessage(String text) {
        messageLabel.setText(text);
        repaint();
    }

    public JTextField getGuessField() {
        return guessField;
    }

    public void disableAllInputs() {
        submitButton.setEnabled(false);
        guessField.setEnabled(false);
    }

    public JLabel getHistoryLabel() {
        return historyLabel;
    }

    public void setHistoryLabel(String history) {
        historyLabel.setText("Historique : [" + history + "]");
    }

    public JButton getNewGameButton() {
        return newGameButton;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dessinerPendu(g);
    }

    public void dessinerPendu(Graphics g) {

        // Efface le dessin précédent en remplissant le fond avec la couleur du fond
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        // Réinitialise la couleur à la couleur par défaut
        g.setColor(getForeground());
        repaint();

        Integer erreurs = modele.getNombreEssais();
        if (erreurs >= 1) {
            // Potence verticale
            g.drawLine(100, 50, 100, 300);
        }
        if (erreurs >= 2) {
            // Barre horizontale
            g.drawLine(100, 50, 250, 50);
        }
        if (erreurs >= 3) {
            // Tête
            g.drawLine(250, 50, 250, 100);
            g.drawOval(225, 100, 50, 50);
        }
        if (erreurs >= 4) {
            // Corps
            g.drawLine(250, 150, 250, 250);
        }
        if (erreurs >= 5) {
            // Bras gauche
            g.drawLine(250, 150, 225, 200);
        }
        if (erreurs >= 6) {
            // Bras droit
            g.drawLine(250, 150, 275, 200);
        }
        if (erreurs >= 7) {
            // Jambe gauche
            g.drawLine(250, 250, 225, 300);
        }
        if (erreurs >= 8) {
            // Jambe droite
            g.drawLine(250, 250, 275, 300);
        }
    }
}
