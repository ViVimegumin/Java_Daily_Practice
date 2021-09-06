public class BottomRay {
    //存放坐标,地雷的坐标是一个二维数组，因为地雷的二维坐标是整数，所以用相邻两个一维数组存放坐标
    int[] rays = new int[GameUtil.RAY_MAX*2];
    //地雷坐标
    int x,y;
    //是否放置 true表示可以放置，false表示不可放置
    boolean isPlace = true;

    //生成雷
    void newRay(){
        //生成坐标
        for (int i = 0; i <GameUtil.RAY_MAX*2; i=i+2) {
            x= (int) (Math.random()*GameUtil.MAP_W+1);//1-12,左闭右开，只取1-11的整数
            y= (int) (Math.random()*GameUtil.MAP_H+1);
            //判断坐标是否存在
            for (int j = 0; j < i ; j=j+2) {
                if (x==rays[j] && y==rays[j+1]){
                    //回退
                    i=i-2;
                    isPlace = false;
                    break;
                }
            }
            //将坐标放入数组
            if (isPlace){
                rays[i]=x;
                rays[i+1]=y;
            }
            //释放状态，无论是否可以放置，
            isPlace = true;
        }
        for (int i = 0; i <GameUtil.RAY_MAX*2 ; i=i+2) {
            GameUtil.DATA_BUTTON[rays[i]][rays[i+1]]=-1;
        }
    }
}
