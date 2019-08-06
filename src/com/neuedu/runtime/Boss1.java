package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Boss1 extends BaseSprite implements Moveable, Drawable {
    private List<Image> imageList = new ArrayList<>();
    private List<Image> imageList1 = new ArrayList<>();
    public List<Image> shandian1 = new ArrayList<>();
    public int boosblood = FrameConstant.BLOOD * 100;
    private int count = 0;
    private boolean stop = true;
    private Random random = new Random();
    int index = 0;
    int zdcount = 0;
    int sdcount = 0;
    int shandianjishi=0;


    public Boss1() {

//        this((FrameConstant.FRAME_WIDTH - ImageMap.get("boss1").getWidth(null) ) / 2, -500, ImageMap.get("boss1"));

       //越大boss出场越晚
        super((FrameConstant.FRAME_WIDTH - ImageMap.get("boss1").
                getWidth(null)) / 2, -4000);
        imageList.add(ImageMap.get("boss0"));
        imageList.add(ImageMap.get("boss1"));
        imageList.add(ImageMap.get("boss2"));
        imageList.add(ImageMap.get("boss3"));
        imageList.add(ImageMap.get("boss4"));
        imageList.add(ImageMap.get("boss5"));
        imageList.add(ImageMap.get("boss6"));
        imageList.add(ImageMap.get("boss7"));


        imageList1.add(ImageMap.get("boss1_1"));
        imageList1.add(ImageMap.get("boss1_2"));
        imageList1.add(ImageMap.get("boss1_3"));
        imageList1.add(ImageMap.get("boss1_4"));
        imageList1.add(ImageMap.get("boss1_5"));
        imageList1.add(ImageMap.get("boss1_6"));
        imageList1.add(ImageMap.get("boss1_7"));
        imageList1.add(ImageMap.get("boss1_8"));
        imageList1.add(ImageMap.get("boss1_9"));

        shandian1.add(ImageMap.get("shandian1"));
        shandian1.add(ImageMap.get("shandian2"));
        shandian1.add(ImageMap.get("shandian3"));
        shandian1.add(ImageMap.get("shandian4"));
        shandian1.add(ImageMap.get("shandian5"));

    }

    public Boss1(int x, int y, List<Image> imageList) {
        super(x, y);
        this.imageList = imageList;
    }

    public void fire() {
        GameFrame gameFrame = DataStore.get("gameFrame");
        //

        if (random.nextInt(1000) > 980) {
            gameFrame.enemyBulletList.add(new EnemyBullet(getX() + (imageList.get(1).getWidth(null) / 2) - ImageMap.get("ezd1").getWidth(null) / 2,
                    getY() + imageList.get(1).getHeight(null), ImageMap.get("ezd1")));
        } else if (random.nextInt(1000) > 970 && random.nextInt(1000) <= 980) {
            gameFrame.enemyBulletList.add(new EnemyBullet(getX() + (imageList.get(1).getWidth(null)) - ImageMap.get("ezd1").getWidth(null) / 2,
                    getY() + imageList.get(1).getHeight(null), ImageMap.get("ezd1")));
        } else if (random.nextInt(1000) <= 970 && random.nextInt(1000) > 960) {
            gameFrame.enemyBulletList.add(new EnemyBullet(getX(),
                    getY() + imageList.get(1).getHeight(null), ImageMap.get("ezd1")));
        }

        //
        /**
         * boss开始扔血轮的时间段
         */
        if (boosblood <= 30 && boosblood >= 12) {
            zdcount++;
            if (zdcount == 50) {
                gameFrame.bossBulletList.add(new BossBullet(getX(),
                        getY() + imageList.get(1).getHeight(null), ImageMap.get("bosszd")));
                zdcount = 0;
            }
        }
    }


    @Override
    public void draw(Graphics g) {
        GameFrame gameFrame = DataStore.get("gameFrame");
        move();
        if (boosblood >= 30) {
            g.drawImage(imageList.get(index++ / 3), getX(), getY(),
                    imageList.get(1).getWidth(null), imageList.get(1).getHeight(null),
                    null);
        } else if(boosblood<30&&boosblood>0){
            g.drawImage(imageList1.get(index++ / 3), (FrameConstant.FRAME_WIDTH - ImageMap.get("boss1_9").getWidth(null)) / 2, getY(),
                    imageList1.get(1).getWidth(null), imageList1.get(1).getHeight(null),
                    null);

        }else if (boosblood<=0){
            g.setFont(new Font("楷体", 0, 136));
            g.setColor(Color.RED);
            g.drawString("GAME WIN" , 130, 400);
            g.drawImage(imageList1.get(index++ / 3), getX(), getY(),
                    imageList1.get(1).getWidth(null), imageList1.get(1).getHeight(null),
                    null);
        }
        if (index >= 24) {
            index = 0;
        }

        borderTesting();
        /**
         * boss开火
         */
        fire();
        if (gameFrame.bsjjishu == 1 && getX() > 0 && getY() > 0 && boosblood > 0) {
            boosblood -= 5;
        }
//闪电开
        if (gameFrame.plane.shandiankai){
            shandianjishi++;
        }
        if (gameFrame.plane.shandiankai && sdcount == 0&&gameFrame.shandiancount>0) {
            gameFrame.shandianList.add(new shandian(gameFrame.plane.getX(), gameFrame.plane.getY(), shandian1));
            sdcount = 1;
            gameFrame.shandiancount--;
        }
        if (shandianjishi>=200){
            gameFrame.shandianList.clear();
            shandianjishi=0;
            gameFrame.plane.shandiankai=false;
            sdcount=0;
        }

        if (boosblood <= 30 && count < 1) {
            gameFrame.bossLoseList.add(new BossLose(400, 200, ImageMap.get("diaoluo1")));
            count++;
        }
    }

    @Override
    public void move() {
        if (stop) {
            setY(getY() + 5);
        }
        if (boosblood <= 0) {
            setX(-1000);
        }

    }


    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), imageList.get(1).getWidth(null), imageList.get(1).getHeight(null));

    }

    public void borderTesting() {
        if (getY() >= 200) {
            stop = false;
        }
    }

}
