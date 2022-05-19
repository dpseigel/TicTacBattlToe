package com.tictacbattltoe.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Game extends Canvas implements Runnable {

    private static final long SerialVersionUID = 1550691097823471818L;
    private Thread thread;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Handler handler;

    public Game() {
        handler = new Handler();
        new Window(WIDTH, HEIGHT, "Tic Tac Battl' Toe", this);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static float clamp(float var, float min, float max){
        if (var >= max) {
            return max;
        }
        if (var <= min) {
            return min;
        }
        else {
            return var;
        }
    }

    public static void main(String args[]) {
        new Game();

    }

    public void run() {
        while (true){
            tick();
            render();
        }
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);

        g.dispose();
        bs.show();
    }
}