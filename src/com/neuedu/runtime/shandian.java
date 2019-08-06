package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class shandian  extends BaseSprite implements Moveable, Drawable {
    private List<Image> imageList = new ArrayList<>();
    private List<Image> imageList1 = new ArrayList<>();
    int index = 0;
    int index1 = 0;
    int shandianjishi = 0;
    int shandianjishi1 = 0;


    public shandian() {
    }


    public shandian(List<Image> imageList1) {
        this.imageList1 = imageList1;
    }

    public shandian(int x, int y) {
        super(x, y);
    }

    public shandian(int x, int y, List<Image> imageList) {
        super(x, y);
        this.imageList = imageList;
    }

    @Override
    public void draw(Graphics g) {
        move();
        g.drawImage(imageList.get(index++ / 3), getX(), getY(),
                imageList.get(1).getWidth(null), imageList.get(1).getHeight(null),
                null);
        g.drawImage(imageList.get(index1++ / 2), getX() + 157, getY(),
                imageList.get(1).getWidth(null), imageList.get(1).getHeight(null),
                null);
        if (index1 >= 10) {
            index1 = 0;
        }

        if (index >= 15) {
            index = 0;

        }
    }

    GameFrame gameFrame = DataStore.get("gameFrame");


    @Override
    public void move() {
        setX(gameFrame.plane.getX() - ImageMap.get("shandian1").getWidth(null) / 2 + 10);
        setY(gameFrame.plane.getY() - ImageMap.get("shandian1").getHeight(null) + 60);
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), imageList.get(1).getWidth(null) + 170, imageList.get(1).getHeight(null));

    }

    //闪电对boss的判断
    public void collisionTesting(Boss1 boss1) {
        GameFrame gameFrame = DataStore.get("gameFrame");
        shandianjishi++;
        if (boss1.getRectangle().intersects(this.getRectangle())) {
            /**
             * 控制闪电造成伤害的频率，数越大越慢
             */
            if (shandianjishi >= 35) {
                boss1.boosblood--;
                shandianjishi = 0;
            }
        }
    }

     //闪电对敌机的碰撞
    public void collisionTesting(List<EnemyPlane> enemyPlaneList) {
        GameFrame gameFrame = DataStore.get("gameFrame");
        shandianjishi1++;
        for (EnemyPlane enemyPlane : enemyPlaneList) {
            if (enemyPlane.getRectangle().intersects(this.getRectangle())) {
                if (shandianjishi1 >=30) {
                    enemyPlane.xueliang--;
                    shandianjishi1= 0;
                }
                if (enemyPlane.xueliang<=0){
                enemyPlaneList.remove(enemyPlane);}
            } } }
}
