package fr.ecole3il.miniprojet3.Controleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.ecole3il.miniprojet3.Modele.*;
import fr.ecole3il.miniprojet3.Vue.*;

public class PenduControleur {
    private PenduModele modele;
    private PenduVue vue;
    private JButton boutonChoixCouleur;

    public PenduControleur(PenduModele modele, PenduVue vue, JButton boutonChoixCouleur) {
        this.modele = modele;
        this.vue = vue;

        this.boutonChoixCouleur = boutonChoixCouleur;

        // Ajoute un écouteur au bouton pour gérer le choix de couleur
        boutonChoixCouleur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choisirCouleur();
            }
        });
    }

    // Méthode pour gérer le choix de couleur
    private void choisirCouleur() {
        // Utilisez JColorChooser pour permettre à l'utilisateur de choisir une couleur
        Color nouvelleCouleur = JColorChooser.showDialog(null, "Choisir une couleur", modele.getCouleurTrait());

        // Mettez à jour la couleur dans le modèle
        if (nouvelleCouleur != null) {
            modele.setCouleurTrait(nouvelleCouleur);
        }
    }
}
