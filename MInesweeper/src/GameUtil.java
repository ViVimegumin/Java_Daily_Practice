import java.awt.*;

/*
* 工具类
* 存放静态参数
* 工具方法
* */
public class GameUtil {
    //地雷个数
    static int RAY_MAX = 8;
    //地图的宽（在一个横向上格子的个数）
    static int MAP_W=11;
    //地图的高（在一个纵向上格子的个数）
    static int MAP_H=11;
    //雷区偏移量
    static int OFFSET = 45;
    //格子边长
    static int SQUARE_LENGTH= 50;

    //鼠标相关
    //坐标
    static int MOUSE_X;
    static int MOUSE_Y;
    //状态
    static boolean LEFT = false;
    static boolean RIGHT = false;

    //游戏状态 0游戏中  1胜利 2失败
    static int state = 0;


    //底层元素 -1雷  0空  1-8表示对应数字
    static int [][] DATA_BUTTON = new int [MAP_W+2][MAP_H+2];
    //顶层元素 -1无覆盖 0覆盖 1插旗 2差错旗
    static int[][] DATA_TOP = new int [MAP_W+2][MAP_H+2];

    //载入图片
    static Image lei = Toolkit.getDefaultToolkit().getImage("imgs/lei.png");
    static Image top = Toolkit.getDefaultToolkit().getImage("imgs/top.gif");
    static Image flag = Toolkit.getDefaultToolkit().getImage("imgs/flag.gif");
    static Image noflag = Toolkit.getDefaultToolkit().getImage("imgs/noflag.png");

    static Image face = Toolkit.getDefaultToolkit().getImage("imgs/face.png");
    static Image over = Toolkit.getDefaultToolkit().getImage("imgs/over.png");
    static Image win = Toolkit.getDefaultToolkit().getImage("imgs/win.png");

    static Image[] images = new Image[9];
    static {
        for (int i = 1; i <=8 ; i++) {
            images[i] = Toolkit.getDefaultToolkit().getImage("imgs/num/"+i+".png");
        }
    }

}
