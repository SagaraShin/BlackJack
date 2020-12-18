import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private String name;
	private int totalScore;
	private ArrayList<Card> hand=new ArrayList<Card>();
	
	public Player(boolean dealerJudge) {
		if(dealerJudge) {
			name="ディーラー";
		}else {
			System.out.println("名前を入力してください");
			Scanner scan=new Scanner(System.in);
			String scanName=scan.nextLine();
			setName(scanName);
		}
	}
	
	
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setTotalScore() {
		int sum=0;
		for(int i=0; i<hand.size(); i++) {
			sum+=hand.get(i).getNumber();
		}
		totalScore=sum;
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	public String getName() {
		return name;
	}
	
	public void drawCard(Card card) {
		this.hand.add(card);
		
	}
	
	public void openHand() {
		for(int i=0; i<hand.size(); i++) {
			System.out.print(hand.get(i).getMark());
			System.out.print(hand.get(i).getNumber()+" ");
		}
		System.out.println();
	}
	//ディーラーが一枚だけ手札を公開するときに使う
	public void dealerFirstOpenHand() {
		for(int i=0; i<hand.size(); i++) {
			if(i==0) {
				System.out.print(hand.get(i).getMark());
				System.out.print(hand.get(i).getNumber()+" ");
			}else {
				System.out.println("?? ");
			}
		}
	}
	
}
