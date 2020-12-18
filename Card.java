
public class Card {
	
	private int number;
	private String mark;
	
	public Card(int i) {
		setNumber(i);
		setMark(i);
	}
	
	//1～52までの数が、13で割ったあまりを利用してカードの数字を決める
	public void setNumber(int i) {
		if(i%13==0) {
			this.number=13;
		}else {
			this.number=i%13;
		}
	}
	
	//1～52までの数が、13で割った商が４つのグループに分かれるということを利用して
	//ハートなどのマークを決める。
	public void setMark(int i) {
		if(i/13==0||i==13) {
			this.mark="H";
			
		}else if(i/13==1||i==26) {
			this.mark="S";
			
		}else if(i/13==2||i==39) {
			this.mark="D";
			
		}else if(i/13==3||i==52) {
			this.mark="C";
		}
		
	}
	
	
	public int getNumber() {
		if(number>=10) {
			return 10;
		}else {
			return number; 
		}
	}
	public String getMark() {
		return mark;
	}
}
