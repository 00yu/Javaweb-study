import java.awt.*;
import javax.swing.*;
public class BallGame extends JFrame{
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
    double x=100;//小球的横坐标
    double y=100;//小球的纵坐标
    boolean right=true;//方向
    //画窗口方法
    public void paint(Graphics g) {
    	g.drawImage(desk, 0, 0, null);
    	g.drawImage(ball, (int)x, (int)y, null);
    	if(right) {
    		x+=10;
    	}else {
    		x-=10;
    	}
    	if(x>856-40-30) {//30是小球直径，40是桌子边框长度
    		right=false;
    	}
    	if(x<40) {
    		right=true;
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
		BallGame game = new BallGame();
        game.launchFrame();
	}
}
