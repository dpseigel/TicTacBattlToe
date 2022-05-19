package com.tictacbattltoe.main;

import java.awt.*;

public class Board extends GameObject{

    public Board(int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(100, 100, 100, 8);
    }
}
