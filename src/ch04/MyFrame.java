package ch04;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * JLabel 을 이용해서 이미지를 다룰 수 있다.
 * JLabel.add(); 메서드를 통해서 이미지를 겹칠 수 있다.
 * 좌표 기준으로 이미지를 세팅하려면
 * 배치관리자를 null 값으로 세팅해야 한다.
 */
public class MyFrame extends JFrame{
	
	private JLabel backgroundMap;
	private JLabel player;
	
	public MyFrame() {
		initData();
		setInitLayout();
	}
	
	public void initData() {
		setTitle("JLabel을 활용한 이미지 사용 연습");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Icon icon = new ImageIcon("img/background1.jpg");
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(500, 500);
		backgroundMap.setLocation(0, 0);
		
		player = new JLabel(new ImageIcon("img/resizeimage2.png"));
		player.setSize(94, 94);
		player.setLocation(300, 100);
	}
	
	public void setInitLayout() {
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(player);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		new MyFrame();
		
	}// end of main

}
