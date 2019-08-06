package com.neuedu.util;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageMap {

    private static final Map<String, Image> map=new HashMap<>();
    static {
        //背景
        map.put("bg1", ImageUtil.getImage("com\\neuedu\\imgs\\bg\\bg2.jpg"));
        map.put("kaishi", ImageUtil.getImage("com\\neuedu\\imgs\\bg\\load.png"));
        //自己的飞机
        map.put("my1", ImageUtil.getImage("com\\neuedu\\imgs\\plane\\myplane02.png"));

          //自己的子弹
        map.put("myzd1", ImageUtil.getImage("com\\neuedu\\imgs\\zidan\\mzd1.png"));
        map.put("myzd2", ImageUtil.getImage("com\\neuedu\\imgs\\zidan\\mzd2.png"));
        map.put("myzd3", ImageUtil.getImage("com\\neuedu\\imgs\\zidan\\mzd3.png"));

        //子弹动图
        map.put("huoyan1", ImageUtil.getImage("com\\neuedu\\imgs\\zidan\\1_01.png"));
        map.put("huoyan2", ImageUtil.getImage("com\\neuedu\\imgs\\zidan\\1_02.png"));
        map.put("huoyan3", ImageUtil.getImage("com\\neuedu\\imgs\\zidan\\1_03.png"));
        map.put("huoyan4", ImageUtil.getImage("com\\neuedu\\imgs\\zidan\\1_04.png"));
        map.put("huoyan5", ImageUtil.getImage("com\\neuedu\\imgs\\zidan\\1_05.png"));
        map.put("huoyan6", ImageUtil.getImage("com\\neuedu\\imgs\\zidan\\1_06.png"));

        //闪电子弹
        map.put("shandian1", ImageUtil.getImage("com\\neuedu\\imgs\\shandian\\01.png"));
        map.put("shandian2", ImageUtil.getImage("com\\neuedu\\imgs\\shandian\\02.png"));
        map.put("shandian3", ImageUtil.getImage("com\\neuedu\\imgs\\shandian\\03.png"));
        map.put("shandian4", ImageUtil.getImage("com\\neuedu\\imgs\\shandian\\04.png"));
        map.put("shandian5", ImageUtil.getImage("com\\neuedu\\imgs\\shandian\\05.png"));

       //敌人飞机
        map.put("ep1", ImageUtil.getImage("com\\neuedu\\imgs\\enemyplane\\ep1.png"));
        map.put("ep2", ImageUtil.getImage("com\\neuedu\\imgs\\enemyplane\\ep2.png"));

    //boss1动态
        map.put("boss0", ImageUtil.getImage("com\\neuedu\\imgs\\boss\\BOSS1_1.png"));
        map.put("boss1", ImageUtil.getImage("com\\neuedu\\imgs\\boss\\BOSS1_2.png"));
        map.put("boss2", ImageUtil.getImage("com\\neuedu\\imgs\\boss\\BOSS1_3.png"));
        map.put("boss3", ImageUtil.getImage("com\\neuedu\\imgs\\boss\\BOSS1_4.png"));
        map.put("boss4", ImageUtil.getImage("com\\neuedu\\imgs\\boss\\BOSS1_5.png"));
        map.put("boss5", ImageUtil.getImage("com\\neuedu\\imgs\\boss\\BOSS1_6.png"));
        map.put("boss6", ImageUtil.getImage("com\\neuedu\\imgs\\boss\\BOSS1_7.png"));
        map.put("boss7", ImageUtil.getImage("com\\neuedu\\imgs\\boss\\BOSS1_8.png"));
        //boss2
        map.put("boss1_1", ImageUtil.getImage("com\\neuedu\\imgs\\boss2\\boss_A_01.png"));
        map.put("boss1_2", ImageUtil.getImage("com\\neuedu\\imgs\\boss2\\boss_A_02.png"));
        map.put("boss1_3", ImageUtil.getImage("com\\neuedu\\imgs\\boss2\\boss_A_03.png"));
        map.put("boss1_4", ImageUtil.getImage("com\\neuedu\\imgs\\boss2\\boss_A_04.png"));
        map.put("boss1_5", ImageUtil.getImage("com\\neuedu\\imgs\\boss2\\boss_A_05.png"));
        map.put("boss1_6", ImageUtil.getImage("com\\neuedu\\imgs\\boss2\\boss_A_06.png"));
        map.put("boss1_7", ImageUtil.getImage("com\\neuedu\\imgs\\boss2\\boss_A_07.png"));
        map.put("boss1_8", ImageUtil.getImage("com\\neuedu\\imgs\\boss2\\boss_A_08.png"));
        map.put("boss1_9", ImageUtil.getImage("com\\neuedu\\imgs\\boss2\\boss_A_09.png"));

        //warning
        map.put("warning1", ImageUtil.getImage("com\\neuedu\\imgs\\warning\\1.png"));
        map.put("warning2", ImageUtil.getImage("com\\neuedu\\imgs\\warning\\2.png"));
        map.put("warning3", ImageUtil.getImage("com\\neuedu\\imgs\\warning\\3.png"));
        map.put("warning4", ImageUtil.getImage("com\\neuedu\\imgs\\warning\\4.png"));
        map.put("warning5", ImageUtil.getImage("com\\neuedu\\imgs\\warning\\5.png"));
        map.put("warning6", ImageUtil.getImage("com\\neuedu\\imgs\\warning\\6.png"));
        map.put("warning7", ImageUtil.getImage("com\\neuedu\\imgs\\warning\\7.png"));
        map.put("warning8", ImageUtil.getImage("com\\neuedu\\imgs\\warning\\8.png"));
        map.put("warning9", ImageUtil.getImage("com\\neuedu\\imgs\\warning\\9.png"));
        map.put("warning10", ImageUtil.getImage("com\\neuedu\\imgs\\warning\\10.png"));




        //必杀技1动态
        map.put("bsj1_1", ImageUtil.getImage("com\\neuedu\\imgs\\booo\\1.png"));
        map.put("bsj1_2", ImageUtil.getImage("com\\neuedu\\imgs\\booo\\2.png"));
        map.put("bsj1_3", ImageUtil.getImage("com\\neuedu\\imgs\\booo\\3.png"));
        map.put("bsj1_4", ImageUtil.getImage("com\\neuedu\\imgs\\booo\\4.png"));
        map.put("bsj1_5", ImageUtil.getImage("com\\neuedu\\imgs\\booo\\5.png"));
        map.put("bsj1_6", ImageUtil.getImage("com\\neuedu\\imgs\\booo\\6.png"));
        map.put("bsj1_7", ImageUtil.getImage("com\\neuedu\\imgs\\booo\\7.png"));
        map.put("bsj1_8", ImageUtil.getImage("com\\neuedu\\imgs\\booo\\8.png"));
        map.put("bsj1_9", ImageUtil.getImage("com\\neuedu\\imgs\\booo\\9.png"));




        //敌人子弹
        map.put("ezd1", ImageUtil.getImage("com\\neuedu\\imgs\\zidan\\ezd1.png"));
        map.put("bosszd", ImageUtil.getImage("com\\neuedu\\imgs\\zidan\\bosszd.png"));

           //飞行物
        map.put("zdup1", ImageUtil.getImage("com\\neuedu\\imgs\\up\\zdup1.png"));
        map.put("bloodup", ImageUtil.getImage("com\\neuedu\\imgs\\up\\upblood.png"));
        map.put("speedup", ImageUtil.getImage("com\\neuedu\\imgs\\up\\speedup.png"));

             //图标
        map.put("blood", ImageUtil.getImage("com\\neuedu\\imgs\\zhuangshi\\blood1.png"));
        map.put("jineng1", ImageUtil.getImage("com\\neuedu\\imgs\\zhuangshi\\jinengtubiao.png"));
        map.put("bosstb", ImageUtil.getImage("com\\neuedu\\imgs\\boss\\bosstb.png"));
        map.put("shantb", ImageUtil.getImage("com\\neuedu\\imgs\\zhuangshi\\shandiantubiao.png"));

        //掉落物
        map.put("diaoluo1", ImageUtil.getImage("com\\neuedu\\imgs\\up\\boss1lose.png"));
        map.put("shandianup", ImageUtil.getImage("com\\neuedu\\imgs\\up\\shandianup.png"));


    }

    public static Image get(String key){
        return map.get(key);
    }

}
