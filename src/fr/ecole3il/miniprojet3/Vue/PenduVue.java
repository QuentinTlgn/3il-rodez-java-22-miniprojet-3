package fr.ecole3il.miniprojet3.Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.awt.event.MouseMotionAdapter;

import fr.ecole3il.miniprojet3.Modele.*;

import java.util.List;

public class PenduVue extends JPanel {
    private PenduModele modele;

    public PenduVue(PenduModele modele) {
        this.modele = modele;

        setBackground(Color.WHITE);
    }

}
