package com.shapeapp;

import com.ca1.ShapesManager;

import javax.swing.*;
import java.awt.*;

public class CustomWindow extends JFrame {

    private CustomPanel mainPanel;

    public CustomWindow(ShapesManager shapesManager){
        super("Tom's frame");

        mainPanel = new CustomPanel(shapesManager);
        mainPanel.setBackground(new Color(173, 210, 209));
        add(mainPanel,BorderLayout.CENTER);
        setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);
    }
}
