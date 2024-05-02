package Bubble.test.ex02;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x;
	private int y;
	private ImageIcon playerR, playerL;

	// 플레이어 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;
	
	// setter
	public void setLeft(boolean left) {
		this.left = left;
	}
	public void setRight(boolean right) {
		this.right = right;
	}

	public Player() {
		initData();
		setInitLayout();
	}

	private void initData() {
		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 처음 실행 시 초기값 세팅
		x = 55;
		y = 535;

		// 플레이어가 가만히 멈춤 상태
		left = false;
		right = false;
		up = false;
		down = false;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		left = true;
		setIcon(playerL);
		// <- <- <-
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					x = x - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}// end of left

	@Override
	public void right() {
		right = true;
		setIcon(playerR);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

	}// end of right

	@Override
	public void up() {
		System.out.println("점프");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
		}
		
		
	}

	@Override
	public void down() {
		System.out.println("다운");
	}

}
