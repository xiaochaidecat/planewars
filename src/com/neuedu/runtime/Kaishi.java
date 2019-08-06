package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Kaishi extends BaseSprite implements Moveable, Drawable {
    private Image image;
    GameFrame gameFrame = DataStore.get("gameFrame");
    public boolean kaishi1=false;

    public Kaishi() {
        image = ImageMap.get("kaishi");
    }

    public Kaishi(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, -320, 40, image.getWidth(null), FrameConstant.FRAME_HEIGHT, null);

    }

    @Override
    public void move() {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("开始");
            kaishi1 = true;
        }
    }
}