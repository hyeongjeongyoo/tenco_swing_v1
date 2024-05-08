package Bubble.test.ex09;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
	
	// 컨텍스트를  생성하는 방법 (셀프 참조)
	BubbleFrame mContext = this;

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initData();
		setInitLayout();
		addEvenListener();

		// Player 백그라운드 서비스 시작

		new Thread(new BackgroundPlayerService(player)).start();
	}

	private void initData() {
		// todo 이미지 변경
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));

		// backgroundMap = new JLabel(new ImageIcon("img/test.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Frame -> root Panal
		setContentPane(backgroundMap); // add 처리
		setSize(1000, 640);

		// mContext -> 참조 타입() -> 주소값의 크기는 기본 4byte 이다.
		player = new Player(mContext);
	}

	private void setInitLayout() {
		// 좌표 값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 조절 불가
		setLocationRelativeTo(null); // JFrame 여러분 모니터 가운데 자동 배치
		setVisible(true);

		add(player);
	}

	private void addEvenListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getExtendedKeyCode());

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 구현

					// 왼쪽으로 방향키 누르고 있다면
					// key 이벤트가 계속 <- <- <- <- <-
					// 왼쪽이 상태가 아니라면
					// 왼쪽 벽에 충돌한 게 아니라면
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					player.up();
					break;
				case KeyEvent.VK_SPACE:
					// add(new Bubble(player));
					player.attack();
					// 프레임의 컴포넌트 add 동작은 누구? JFrame -> add() 메서드 이다.
					// 버블 실행시에 끊김 현상이 발생하는 이유는 ?
				default:
					break;

				}
			}// end of keyPressed

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 구현
					// 왼쪽으로 가는 상태 멈춤
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가는 상태 멈춤
					player.setRight(false);
					break;
				default:
					break;
				}
			} // end of KeyReleased

		});
	}

	// getter
	public Player getPlayer() {
		return player;
	}
	
	// 코드 테스트
	public static void main(String[] args) {
		// main 함수를 가지고 있는 클래스는 하위에 생성된 모든 객체들의
		// 주소값을 알고 있다. (중요! 중요! 중요!)
		
		new BubbleFrame();
	}// end of main

}
