import java.awt.*;
import javax.swing.*;
public class BallGame2 extends JFrame{
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
    double x=100;//小球的横坐标
    double y=100;//小球的纵坐标
    double degree=3.14/3;//弧度 此处就是60度 pi/3
    //画窗口方法
    public void paint(Graphics g) {
    	g.drawImage(desk, 0, 0, null);
    	g.drawImage(ball, (int)x, (int)y, null);
    	
    	x=x+10*Math.cos(degree);
    	y=y+10*Math.sin(degree);
    	
    	if(y>500-40-30 || y<40+40) {//500是窗口高度 40是桌子边框 30是球直径 最后40是标题栏高度
    		degree=-degree;
    	}
    	//碰到左右边界
    	if(x<40 || x>856-40-30) {
    		degree=3.14-degree;
    	}
    }
	//窗口加载
    void launchFrame(){
        setSize(856,500);
        setLocation(50,50);
        setVisible(true);
        
        //重画窗口
        while(true) {
        	repaint();
        	try {
				Thread.sleep(40);//40ms 1s画20次窗口
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	//main方法是程序执行的入口
	public static void main(String[] args) {
		BallGame2 game = new BallGame2();
        game.launchFrame();
	}
}
