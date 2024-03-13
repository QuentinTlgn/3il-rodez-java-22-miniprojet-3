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
            Integer guess = modele.guess(enteredText.charAt(0));

            String message;

            System.out.println(guess);
            switch (guess) {
                case 0:
                    message = "La lettre proposée a déjà été proposée";
                    break;
                case 1:
                    message = "Bien joué ! La lettre est présente dans le mot";
                    break;
                case 2:
                    message = "La proposition n'est pas dans le mot";
                    break;
                case 3:
                    message = "Vos vies sont écoulées, partie terminée :(";
                    vue.disableAllInputs();
                    vue.setMot(modele.getMotClair());
                    break;
                case 4:
                    message = "L'entrée n'est pas une lettre";
                    break;
                case 5:
                    message = "Bien joué, vous avez trouvé le mot !";
                    vue.disableAllInputs();
                    break;
                default:
                    message = "Erreur interne :/";
                    break;
            }
            vue.setMot(modele.getMot());
            vue.setMessage(message);
        }
    }
}
