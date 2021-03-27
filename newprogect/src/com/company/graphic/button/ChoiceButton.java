package com.company.graphic.button;

import com.company.graphic.panel.ChoicePanel;
import com.company.graphic.panel.ImagePanel;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Кнопка выбора
 */
public class ChoiceButton extends JButton {

    public ChoiceButton(String text, ActionListener actionListener) {
        super(text);
        this.addActionListener(actionListener);
    }

    public ChoiceButton(String text) {
        super(text);
    }
}
