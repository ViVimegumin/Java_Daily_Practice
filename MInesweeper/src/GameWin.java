import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {

    //进行界面规划后，修改窗口大小
    int width= 2 * GameUtil.OFFSET+GameUtil.MAP_W*GameUtil.SQUARE_LENGTH;
    int height= 4*GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH;

    //创建画布（解决闪动现象）原理是把底层的图像放到画布上，再把顶层元素放到画布上
    Image offScreenImage = null;
    MapButton mapButton=new MapButton();
    MapTop mapTop = new MapTop();
    void launch(){
        //1、设置窗口是否可见
        this.setVisible(true);
//        2、设置窗口大小
        this.setSize(width,height);
        //3、设置窗口位置
        this.setLocationRelativeTo(null);
        //4、设置窗口标题
        this.setTitle("扫雷游戏");
        //5、设置窗口关闭方法
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //鼠标事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch (GameUtil.state){
                    case 0:
                        if (e.getButton()==1){
                            GameUtil.MOUSE_X=e.getX();
                            GameUtil.MOUSE_Y=e.getY();
                            GameUtil.LEFT=true;
                        }
                        if (e.getButton()==3){
                        GameUtil.MOUSE_X=e.getX();
                        GameUtil.MOUSE_Y=e.getY();
                        GameUtil.RIGHT=true;
                        }
                    case 1:
                    case 2:
                        if (e.getButton()==1){
                            if (e.getX()>GameUtil.OFFSET/2+(GameUtil.MAP_W)/2*GameUtil.SQUARE_LENGTH &&
                            e.getX()<GameUtil.OFFSET/2+(GameUtil.MAP_W)/2*GameUtil.SQUARE_LENGTH+GameUtil.SQUARE_LENGTH &&
                            e.getY()>GameUtil.OFFSET &&
                            e.getY()<GameUtil.OFFSET+GameUtil.SQUARE_LENGTH){
                                mapButton.reGame();
                                mapTop.reGame();
                                GameUtil.state=0;
                            }
                        }
                        break;
                    default:

                }
                if (e.getButton()==1){//鼠标左键被点击是1，滚轮被点击是2
                    GameUtil.MOUSE_X=e.getX();
                    GameUtil.MOUSE_Y=e.getY();
                    GameUtil.LEFT=true;
                }
                if (e.getButton()==3){//鼠标右键被点击是3
                    GameUtil.MOUSE_X=e.getX();
                    GameUtil.MOUSE_Y=e.getY();
                    GameUtil.RIGHT=true;
                }
            }
        });

        //添加一个死循环，让其时刻都在绘制
        while (true){
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        //设置背景画布
        offScreenImage = this.createImage(width,height);
        Graphics gImage = offScreenImage.getGraphics();
        mapButton.paintSelf(gImage);
        mapTop.paintSelf(gImage);
        g.drawImage(offScreenImage,0,0,null);
    }

    //调用窗口
    public static void main(String[] args) {
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}
