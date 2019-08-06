package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Bishaji extends BaseSprite implements Moveable, Drawable {
    private List<Image> imageList=new ArrayList<>();
    private int index =0;

    public Bishaji(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Bishaji() {
        imageList.add(ImageMap.get("bsj1_1"));
        imageList.add(ImageMap.get("bsj1_2"));
        imageList.add(ImageMap.get("bsj1_3"));
        imageList.add(ImageMap.get("bsj1_4"));
        imageList.add(ImageMap.get("bsj1_5"));
        imageList.add(ImageMap.get("bsj1_6"));
        imageList.add(ImageMap.get("bsj1_7"));
        imageList.add(ImageMap.get("bsj1_8"));
        imageList.add(ImageMap.get("bsj1_9"));
    }

    public Bishaji(int x, int y, List<Image> imageList) {
        super(x, y);
        this.imageList = imageList;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    @Override
    public void draw(Graphics g) {

        g.drawImage(imageList.get(index++/3), 20, 100,
                imageList.get(1).getWidth(null)*3, imageList.get(1).getHeight(null)*3, null);
        if (index>=27){
            index=0;
        }
    }
    GameFrame gameFrame= DataStore.get("gameFrame");

    @Override
    public void move() {

    }
//    public void keyPressed(KeyEvent e) {
//
//        if (e.getKeyCode() == KeyEvent.VK_K) {
//             gameFrame.bsj= true;
//        }}
//
//    public void keyReleased(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_K) {
//            gameFrame.bsj = false;
//        }
}
