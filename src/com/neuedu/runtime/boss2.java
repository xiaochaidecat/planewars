package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class boss2  extends BaseSprite implements Moveable, Drawable {
    private List<Image> imageList=new ArrayList<>();
    int index11 =0;

    public boss2() {
        imageList.add(ImageMap.get("warning1"));
        imageList.add(ImageMap.get("warning2"));
        imageList.add(ImageMap.get("warning3"));
        imageList.add(ImageMap.get("warning4"));
        imageList.add(ImageMap.get("warning5"));
        imageList.add(ImageMap.get("warning6"));
        imageList.add(ImageMap.get("warning7"));
        imageList.add(ImageMap.get("warning8"));
        imageList.add(ImageMap.get("warning9"));
        imageList.add(ImageMap.get("warning10"));

    }

    public boss2(int x, int y, List<Image> imageList) {
        super(x, y);
        this.imageList = imageList;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(imageList.get(index11++ / 5), 100, 300,
                imageList.get(1).getWidth(null), imageList.get(1).getHeight(null),
                null);
        if (index11 >= 50) {
            index11 = 0;
        }



    }

    @Override
    public void move() {

    }
}
