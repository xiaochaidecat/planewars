package com.neuedu.main;

import com.neuedu.constant.FrameConstant;
import com.neuedu.runtime.*;
import com.neuedu.util.ImageMap;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameFrame extends Frame {
    //创建别境对象
    private Background background = new Background();
    //创建血量
//    private Blood blood = new Blood();
    public final List<Blood> bloodList = new CopyOnWriteArrayList<>();
    //创建飞机对象
    public Plane plane = new Plane();
    //创建boss
    private Boss1 boss1 = new Boss1();
    //创建boss子弹集合
    public final List<BossBullet> bossBulletList = new CopyOnWriteArrayList<>();


    //创建必杀技对象
    private Bishaji bishaji = new Bishaji();
    //创建警告
    private boss2 boss2 = new boss2();
    //

    public final List<Bishaji> bishajiList = new CopyOnWriteArrayList<>();

    //创建子弹集合
    public final List<Bullet> bulletList = new CopyOnWriteArrayList<>();

    //创建地方飞机集合
    public final List<EnemyPlane> enemyPlaneList = new CopyOnWriteArrayList<>();

    //创建敌人子弹集合
    public final List<EnemyBullet> enemyBulletList = new CopyOnWriteArrayList<>();

    //创建子弹增进集合
    public final List<BulletUp> bulletUpList = new CopyOnWriteArrayList<>();

    //创建掉落物集合
    public final List<BossLose> bossLoseList = new CopyOnWriteArrayList<>();
    //创建闪电
//    private shandian shandian = new shandian();
    public  final List<shandian> shandianList = new CopyOnWriteArrayList<>();


    public Kaishi kaishi=new Kaishi();


    //游戏是否结束
    public boolean game = false;

    //我方武器等级
    public Integer level = 0;
    //我方子弹速度
    public  int zdsp=1;
    //我方初始血量
    public static int hp = 15;
    //必杀技图片循环计数器
    public int bsjjishu = 0;
    //必杀技数量
    public int bsjcishu = 3;

    //闪电次数
    public int shandiancount=3;



    @Override
    public void paint(Graphics g) {
        if (!kaishi.kaishi1){
            kaishi.draw(g);
            g.setFont(new Font("楷体", 0, 56));
            g.setColor(Color.GREEN);
            g.drawString("按空格键开始游戏" , 160, 900);
        }
        else {if (!game) {
            background.draw(g);
            plane.draw(g);
            boss1.draw(g);
            if (plane.bsj && bsjcishu > 0) {
                bishaji.draw(g);
                bsjjishu++;

                if (bsjjishu >= 27) {
                    bsjcishu--;
                    plane.bsj = false;
                    bsjjishu = 0;
                }
            }
            if (boss1.boosblood >= 30 && boss1.boosblood <= 40) {
                boss2.draw(g);
            }
            for (BossBullet bossBullet : bossBulletList) {
                bossBullet.draw(g);
            }

            for (Blood blood : bloodList) {
                blood.draw(g);
            }
            for (shandian shandian : shandianList) {
                shandian.draw(g);
            }
            for (Bishaji bishaji : bishajiList) {
                bishaji.draw(g);
            }

            for (BossLose bossLose : bossLoseList) {
                bossLose.draw(g);
            }

            for (Bullet bullet : bulletList) {
                bullet.draw(g);
            }
            for (EnemyPlane enemyPlane : enemyPlaneList) {
                enemyPlane.draw(g);
            }
            for (BulletUp bulletUp : bulletUpList) {
                bulletUp.draw(g);
            }
            for (EnemyBullet enemyBullet : enemyBulletList) {
                enemyBullet.draw(g);
            }
            //子弹对敌机检测
            for (Bullet bullet : bulletList) {
                bullet.collisionTesting(enemyPlaneList);
            }
            for (EnemyBullet enemyBullet : enemyBulletList) {
                enemyBullet.collisionTesting(plane);
            }
            for (BulletUp bulletUp : bulletUpList) {
                bulletUp.collisionTesting(plane);
            }
            for (Bullet bullet : bulletList) {
                bullet.collisionTesting(boss1);
            }
            for (BossLose bossLose : bossLoseList) {
                bossLose.collisionTesting(plane);
            }
            for (BossBullet bossBullet : bossBulletList) {
                bossBullet.collisionTesting(plane);
            }
            for (Bullet bullet : bulletList) {
                bullet.collisionTesting1(bossBulletList);
            }
            for (shandian shandian : shandianList) {
                shandian.collisionTesting(boss1);
            }
            for (shandian shandian : shandianList) {
                shandian.collisionTesting(enemyPlaneList);
            }


            g.setFont(new Font("楷体", 0, 36));
            g.setColor(Color.GREEN);
            g.drawString(":" + hp, 70, 90);
//            g.drawString("" + boss1.boosblood, 200, 100);
            g.drawString(":" + bsjcishu, 70, 160);
            g.drawString(":" + shandiancount, 70, 220);

            //boss血条
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            g.setColor(Color.RED);
            g.setFont(new Font("楷体", 0, 36));
            g.drawRect(260,60,400,30);
            g.fillRect(260,60,boss1.boosblood*4,30);


            g.setColor(Color.BLACK);



        }
        }
    }

    /**
     * 使用这个方法初始化窗口
     */
    public void init() {
        //设置尺寸
        setSize(FrameConstant.FRAME_WIDTH, FrameConstant.FRAME_HEIGHT);
        //设置居中
        setLocationRelativeTo(null);

        //启动窗口不让有图片
        enableInputMethods(false);

        //关闭窗口
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //添加键盘监听
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                plane.keyPressed(e);
                kaishi.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                plane.keyReleased(e);
            }
        });


        new Thread() {
            @Override
            public void run() {

                while (true) {
                    repaint();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        //游戏初始时加一些敌机
        enemyPlaneList.add(new EnemyPlane(300, 30, 1));
        enemyPlaneList.add(new EnemyPlane(150, 70, 1));
        enemyPlaneList.add(new EnemyPlane(450, -10, 1));
        enemyPlaneList.add(new EnemyPlane(600, 30, 2));
        enemyPlaneList.add(new EnemyPlane(300, -500, 1));
        enemyPlaneList.add(new EnemyPlane(150, -170, 2));
        enemyPlaneList.add(new EnemyPlane(450, -210, 1));
        enemyPlaneList.add(new EnemyPlane(600, -1030, 2));
        enemyPlaneList.add(new EnemyPlane(300, -2030, 1));
        enemyPlaneList.add(new EnemyPlane(150, -1570, 1));
        enemyPlaneList.add(new EnemyPlane(450, -1110, 2));
        enemyPlaneList.add(new EnemyPlane(600, -3030, 1));

        enemyPlaneList.add(new EnemyPlane(300, -3500, 1));
        enemyPlaneList.add(new EnemyPlane(150, -3590, 1));
        enemyPlaneList.add(new EnemyPlane(450, -3640, 1));
        enemyPlaneList.add(new EnemyPlane(600, -4000, 2));
        enemyPlaneList.add(new EnemyPlane(300, -4000, 1));
        enemyPlaneList.add(new EnemyPlane(150, -4130, 2));
        enemyPlaneList.add(new EnemyPlane(450, -274, 1));
        enemyPlaneList.add(new EnemyPlane(600, -1650, 2));
        enemyPlaneList.add(new EnemyPlane(300, -2650, 1));
        enemyPlaneList.add(new EnemyPlane(150, -1940, 1));
        enemyPlaneList.add(new EnemyPlane(450, -1740, 2));
        enemyPlaneList.add(new EnemyPlane(600, -4100, 1));


        //增益

        bulletUpList.add(new BulletUp(400, -1330, 1));//子弹
        bulletUpList.add(new BulletUp(300, -1000, 2));//血+1
        bulletUpList.add(new BulletUp(200, -8600, 3));//速度

        //装饰
        bloodList.add(new Blood(20, 60, ImageMap.get("blood")));
        bloodList.add(new Blood(20, 120, ImageMap.get("jineng1")));
        bloodList.add(new Blood(200, 50, ImageMap.get("bosstb")));
        bloodList.add(new Blood(20, 180, ImageMap.get("shantb")));


        //
//        bossBulletList.add(new BossBullet(20,120, ImageMap.get("bosszd")));


        setVisible(true);

    }

    private Image offScreenImage = null;//创建缓冲区

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(FrameConstant.FRAME_WIDTH, FrameConstant.FRAME_HEIGHT);//这是游戏窗口的宽度和高度
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}