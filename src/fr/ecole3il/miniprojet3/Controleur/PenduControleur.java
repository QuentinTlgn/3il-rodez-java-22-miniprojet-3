package fr.ecole3il.miniprojet3.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.ecole3il.miniprojet3.Modele.Pendu;
import fr.ecole3il.miniprojet3.Vue.PenduVue;

public class PenduControleur implements ActionListener {
    private Pendu modele;
    private PenduVue vue;

    public PenduControleur(Pendu modele, PenduVue vue) {
        this.modele = modele;
        this.vue = vue;

        vue.setMot(modele.getMot());
        
        // Ajout de l'action listener au bouton
        vue.getSubmitButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vue.getSubmitButton()) {
            // Récupérer le texte entré dans le champ de saisie
            String enteredText = vue.getEnteredText();
            // Mettre à jour le label avec le texte récupéré
            modele.guess(enteredText.charAt(0));
            vue.setMot(modele.getMot());
        }
    }
}
