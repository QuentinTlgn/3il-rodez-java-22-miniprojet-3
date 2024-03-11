package fr.ecole3il.miniprojet3.Modele;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class PenduModele {
    private Color couleurTrait;
    private ArrayList<Point> points;

    public PenduModele(Color couleurTrait) {
        this.couleurTrait = couleurTrait;
        this.points = new ArrayList<Point>();
    }

    public void ajouterPoint(Point point) {
        this.points.add(point);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setCouleurTrait(Color couleur) {
        this.couleurTrait = couleur;
    }

    public Color getCouleurTrait() {
        return couleurTrait;
    }
}
