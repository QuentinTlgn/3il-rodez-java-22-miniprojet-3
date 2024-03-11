package fr.ecole3il.miniprojet3.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * La classe FichierMotsHandler permet de charger un fichier de mots et de
 * fournir des fonctionnalités associées.
 */
public class FichierMotsHandler {

    /**
     * La carte qui stocke les mots et leurs définitions.
     */
    private Map<String, String> motsMap;

    /**
     * Constructeur de la classe FichierMotsHandler.
     *
     * @param filePath Chemin du fichier contenant les mots et leurs définitions.
     */
    public FichierMotsHandler(String filePath) {
        motsMap = new HashMap<>();
        chargerMots(filePath);
    }

    /**
     * Charge les mots et leurs définitions à partir du fichier spécifié.
     *
     * @param filePath Chemin du fichier contenant les mots et leurs définitions.
     */
    private void chargerMots(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" : ");
                if (parts.length == 2) {
                    motsMap.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Récupère l'ensemble des mots présents dans le fichier.
     *
     * @return Un ensemble de mots.
     */
    public Set<String> getMots() {
        return motsMap.keySet();
    }

    /**
     * Récupère de manière aléatoire un mot parmi ceux présents dans le fichier.
     *
     * @return Un mot choisi aléatoirement, ou null si la liste de mots est vide.
     */
    public String getMotAleatoire() {
        if (motsMap.isEmpty()) {
            return null;
        }
        Object[] motsArray = motsMap.keySet().toArray();
        Random random = new Random();
        Object randomKey = motsArray[random.nextInt(motsArray.length)];
        return randomKey.toString();
    }

    /**
     * Récupère la définition associée à un mot spécifié.
     *
     * @param mot Le mot dont on souhaite obtenir la définition.
     * @return La définition du mot, ou null si le mot n'est pas trouvé.
     */
    public String getDefinition(String mot) {
        return motsMap.get(mot);
    }
}
