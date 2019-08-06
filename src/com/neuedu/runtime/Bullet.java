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

public class Bullet extends BaseSprite implements Moveable, Drawable {
    private Image image;
    private  List<Image> imageList=new ArrayList<>();

    GameFrame gameFrame = DataStore.get("gameFrame");

    //子弹速度
    public Integer speed = gameFrame.zdsp +8;

    public Bullet(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    public Bullet() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);
        move();
        borderTesting();
    }

    @Override
    public void move() {
        setY(getY() - speed);
    }

    public void borderTesting() {
        if (getY() < 30) {
            GameFrame gameFrame = DataStore.get("gameFrame");
            gameFrame.bulletList.remove(this);
        }
    }


    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), image.getWidth(null), image.getHeight(null));
    }


    //子弹对boss的测试
    public void collisionTesting(Boss1 boss1) {
        GameFrame gameFrame = DataStore.get("gameFrame");
        if (boss1.getRectangle().intersects(this.getRectangle())) {
            gameFrame.bulletList.remove(this);
            if (gameFrame.level == 0) {
                boss1.boosblood--;
            } else if (gameFrame.level == 1) {
                boss1.boosblood -= 2;
            }
        }
    }

    //子弹对敌机的碰撞检测
    public void collisionTesting(List<EnemyPlane> enemyPlaneList) {
        GameFrame gameFrame = DataStore.get("gameFrame");
        for (EnemyPlane enemyPlane : enemyPlaneList) {
            if (enemyPlane.getRectangle().intersects(this.getRectangle())) {
                gameFrame.bulletList.remove(this);
                if (gameFrame.level==0){
                    enemyPlane.xueliang--;}
                    else if (gameFrame.level==1){
                        enemyPlane.xueliang-=2;
                }
                    if (enemyPlane.xueliang <= 0) {
                        enemyPlaneList.remove(enemyPlane);

                }
            }
        }
    }

    //子弹对boss子弹碰撞
    public void collisionTesting1(List<BossBullet> bossBulletList) {
        GameFrame gameFrame = DataStore.get("gameFrame");
        for (BossBullet bossBullet : bossBulletList) {
            if (bossBullet.getRectangle().intersects(this.getRectangle())) {
                if (gameFrame.level==0){bossBullet.xunlunblood --;}
                else if (gameFrame.level==1){
                bossBullet.xunlunblood -= 2;}
                gameFrame.bulletList.remove(this);
                if (bossBullet.xunlunblood <= 0) {
                    bossBulletList.remove(bossBullet);
                }

            }
        }

    }


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
