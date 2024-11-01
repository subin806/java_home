package ex_241028;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubinVoca extends JFrame {

	private JTextField wordField;// 영어단어 입력 필드
	private JTextField meaningField;// 영어 뜻 입력 필드
	private JPanel wordPanel;// 단어 표시할 필드

	// 단어를 임시로 저장할 Map -> HashMap
	// UI, 화면에 표시할 라벨
	private Map<String, JLabel> wordLabelMap;
	// 영어의 뜻을 저장하는 임시공간
	private Map<String, String> wordMeaningLabelMap;
	// 랜덤으로 단어 퀴즈 형식처럼 출력하기 위한 도구
	private Random random;

	// 생성자 이용해서, UI를 그리고, 임시 메모리 Map 공간에 단어를 입력받고, 출력하고, 랜덤출력

	public SubinVoca() {
		// 윈도우 창과 -> 최상위 프레임 필요. 부모 클래스로부터 상속받아서
		// 그리기 도구 장착
		// 창 제목
		setTitle("단어프로그램 Void 1.0.0");
		// 창 사이즈
		setSize(400, 300);
		// 창 닫기를 클릭시 정상 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 임시 저장소 Map, 전역으로 선언한 인스턴스를, 생성자에서 촉화 작업을 함
		// 다른 곳에서 사용 가능
		wordLabelMap = new HashMap<>();
		wordMeaningLabelMap = new HashMap<String, String>();

		// random 도구 초기화
		random = new Random();

		// 배치 관리자 이용해서, 입력 공간은 북, 단어 표시 공간, 중간에 표기
		setLayout(new BorderLayout());

		// UI생성하기
		// 상단 패널- 단어를 입력하는 공간, 뜻을 입력하는 공간
		// 인스턴스 당 하나의 입력 공간
		// 최상위 프레임 창위에 패널을 붙이는 역할 -> 패널 위에 JLabel 붙일예정
		JPanel inputPanel = new JPanel();
		// inputPanel -> 배치 관리자, flex, FlowLayout 나란히 배치
		inputPanel.setLayout(new FlowLayout());

		// 패널에 붙이는 입력 공간
		// 영어 단어를 입력하는 1)라벨 2)입력란
		// 1.라벨 붙이기, 화면, 이벤트 핸들러, 보통 1회용 사용
		inputPanel.add(new JLabel("단어:  "));
		// 2.입력 공간 붙이기
		inputPanel.add(new JTextField(10));

		// 영어 뜻 입력하는 1)라벨 2)입력란
		inputPanel.add(new JLabel("뜻:  "));
		inputPanel.add(new JTextField(10));

		// 단어를 추가하는 버튼
		inputPanel.add(new JButton("단어추가"));

		// 랜덤으로 출력해주는 버튼
		JButton addButton = new JButton("랜덤 단어 표시");
		inputPanel.add(addButton);

		// 단어 출력 해주는 UI
		wordPanel = new JPanel();
		// wordPanel 에서 배치 관리자, flex 처럼 나란히 배치 FlowLayout 이용.
		wordPanel.setLayout(new FlowLayout());

		// 최상위 프레임 창에
		// 단어를 입력하는 패널을, 북쪽에 붙이기 작업.
		add(inputPanel, BorderLayout.NORTH);
		// 단어를 출력하는 패널을, 가운데 붙이기 작업.
		add(wordPanel, BorderLayout.CENTER);

		// ==================================================
		// 각 버튼에 이벤트 핸들러(리스너) 붙이기 작업.
		// addActionListener , 함수형 인터페이스 : 추상 메서드를 하나만 가짐.
		// 그래서, 람다식(화살표 함수) 표현 가능.
		// 이벤트 파라미터를 받아서, addWord() 메서드 이용해서, 추가하는 로직.
		// 맵에 추가할 예정.
		addButton.addActionListener(e -> addWord());

		setVisible(true);

	}

	

	// Map 에 단어를 추가하는 로직. 
		// 입력란에 입력된 내용을 추가하는 로직. 
		private void addWord() {
			// 입력된 단어 가져오기. 
			// 전역으로 설정된, 단어 입력란 참조형 변수를 이용해서 가지고 올 예정.
			//1
			String word = wordField.getText();
			
			// 입력된 뜻 가져오기.
			//2
			String meaning = meaningField.getText();
			
			// 기본 유효성 체크, 단어와 뜻에 입력이 된 경우만 로직을 진행.
			//3
			if(!word.isEmpty() && !meaning.isEmpty()) {
				// 임시로 출력할 JLabel를 만들어서, 여기에 단어를 붙이는 과정. 
				// 임시 라벨 생성. 
				JLabel wordLabel = new JLabel(word);
				// 마우스 커서를 손 모양으로 변경하는 기능. 옵션, 
				wordLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
				// 이벤트 리스너 추가하기. , 마우스 클릭시 뜻을 보여주는 기능.
				// addMouseListener , 함수형 인터페이스가 아님. 간단히 추상 메서드가 2개이상. 
				// 인터페이스 그냥 구현하면, 사용 안하는 추상메서드 모두를  일단 재정의
				// 조금 더 간편히 하기 위해서, 어댑터 클래스 이용하면, 사용할 추상 메서드만,
				// 이용 가능함. 
				// 익명 클래스로 구현. 
				// new 부모 클래스의(인터페이스, 클래스) {}
				wordLabel.addMouseListener(new MouseAdapter() {
					// 상태 변수, 설정, 뜻을 보여주는 상태. 
					private boolean showMeaning = false;
					@Override
					public void mouseClicked(MouseEvent e) {
						if (!showMeaning) {
							wordLabel.setText("뜻 : " + meaning);
							showMeaning = true;
						} else {
							wordLabel.setText(word);
							showMeaning = false;
						}
					}
				});
				// Map 메모리에 저장하는 로직. 
				wordLabelMap.put(word, wordLabel);
				wordMeaningLabelMap.put(word, meaning);
				
				// 패널에 라벨 추가. 
				wordPanel.add(wordLabel);
				// 레이아웃 업데이트 
				wordPanel.revalidate();
				
			} // if
			// 유효성 통과 안될 때, 경고창 보여주기. 
			else {
				
			}
			
		}
		
		public static void main(String[] args) {
			new SubinVoca();
		} // main
		
		
		
	}// class