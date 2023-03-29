package fr.timeto.timutilslib;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollBarUI extends BasicScrollBarUI {
    @Override
    protected void configureScrollBarColors() {
        this.trackColor = new Color(25, 25, 25);
        this.trackHighlightColor = new Color(40, 40, 40);
        this.thumbColor = new Color(40, 40, 40);
        this.thumbDarkShadowColor = new Color(40, 40, 40);
        this.thumbLightShadowColor = new Color(40, 40, 40);
        this.thumbHighlightColor = new Color(40, 40, 40);
    }

    protected JButton createZeroButton() {
        JButton button = new JButton("");
        Dimension zeroDim = new Dimension(0,0);
        button.setPreferredSize(zeroDim);
        button.setMinimumSize(zeroDim);
        button.setMaximumSize(zeroDim);
        return button;
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new BasicArrowButton(orientation,
                new Color(40, 40, 40),
                new Color(40, 40, 40),
                Color.RED,
                new Color(40, 40, 40));
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new BasicArrowButton(orientation,
                new Color(40, 40, 40),
                new Color(40, 40, 40),
                Color.RED,
                new Color(40, 40, 40));
    }
}
