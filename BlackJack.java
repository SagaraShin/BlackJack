import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("ブラックジャックを開始します");
		Player player=new Player(false);
		Player dealer=new Player(true);
		
		
		ArrayList<Card> deck=new ArrayList<Card>();
		for(int i=1;i<=52; i++) {
			deck.add(new Card(i));
		}
		Collections.shuffle(deck);
		
		
		System.out.println("手札を配ります");
		for(int i=0; i<2; i++) {
			player.drawCard(deck.get(0));
			deck.remove(0);
			
			dealer.drawCard(deck.get(0));
			deck.remove(0);
		}
		
		player.setTotalScore();
		dealer.setTotalScore();
		
		System.out.print("ディーラーの手札は");
		dealer.dealerFirstOpenHand();
		
		System.out.print(player.getName()+"の手札は");
		player.openHand();
		
		System.out.println(player.getName()+"がカードを引く番です");
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("引く場合：Y  引かない場合：Nを入力してください");
			String drawJudge=scan.nextLine();
			if(drawJudge.equals("Y")) {
				player.drawCard(deck.get(0));
				deck.remove(0);
				player.setTotalScore();
				player.openHand();
			}else if(drawJudge.equals("N")) {
				break;
			}
		}
		
		System.out.println("ディーラーが引く番です");
		while(dealer.getTotalScore()<17) {
			dealer.drawCard(deck.get(0));
			deck.remove(0);
			dealer.setTotalScore();
		}
		
		System.out.println("ディーラーが引き終わりました");
		System.out.println();
		
		System.out.println("結果発表をします");
		System.out.print("ディーラーの手札");
		dealer.openHand();
		System.out.println("スコアは"+dealer.getTotalScore());
		
		System.out.println();
		
		System.out.print(player.getName()+"の手札");
		player.openHand();
		System.out.println("スコアは"+player.getTotalScore());
		
		System.out.println();
		
		int dealerScore=dealer.getTotalScore();
		int playerScore=player.getTotalScore();
		
		if(playerScore>21) {
			System.out.println("ディーラーの勝ちです");
			
		}else if(dealerScore>21) {
			System.out.println(player.getName()+"の勝ちです");
			
		}else if(dealerScore>playerScore) {
			System.out.println("ディーラーの勝ちです");
			
		}else if(playerScore>dealerScore) {
			System.out.println(player.getName()+"の勝ちです");
			
		}else {
			System.out.println("引き分けです");
		}
			
		
	}

}
