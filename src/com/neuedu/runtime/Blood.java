package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.util.ImageMap;

import java.awt.*;

public class Blood extends BaseSprite implements Drawable, Moveable {
    private  Image image;

    public Blood() {

        this(20,60, ImageMap.get("blood"));
    }


    public Blood(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), 49, 49, null);

    }

    @Override
    public void move() {

    }
}
