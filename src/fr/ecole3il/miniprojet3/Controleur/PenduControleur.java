package fr.ecole3il.miniprojet3.Controleur;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

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

    private static String formatGuesses(Set<Character> guesses) {
        StringBuilder builder = new StringBuilder();
        for (char guess : guesses) {
            if (builder.length() > 0) {
                builder.append(", ");
            }
            builder.append(guess);
        }
        return builder.toString();
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
                    System.out.println(modele.getMotClair());
                    vue.setMot(modele.getMotClair());
                    vue.disableAllInputs();
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
            if(guess != 3)
                vue.setMot(modele.getMot());

            vue.setHistoryLabel(formatGuesses(modele.getGuesses()));
            
            Graphics g = vue.getGraphics();
            if (g != null) {
                vue.dessinerPendu(g);
            }
            vue.setMessage(message);
        }
    }
}
