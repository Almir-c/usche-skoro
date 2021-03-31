package com.company.graphic.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Панель с текстом и диалогами
 */
public class StoryPanel extends JPanel {
    //Текст диалогов
    JLabel textLabel = new JLabel("Нажмите на кнопку <<Начать>>, чтобы игра началась");

    public StoryPanel() {
        this.setSize(700, 300);
        this.setLocation(300, 500);
        this.setBackground(Color.GREEN);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(textLabel);
    }

    public void changeText(String text) {
        textLabel.setText(text);
    }
}
