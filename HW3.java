import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here
 * Try to write some comments for your codes (methods, 10 points)
 * B0444109林奕銜
 * 1.首先在card class中新增一個enum來記錄花色，並把class constructor塞入之參數改為Suit和int
 * 2.再來在Deck class新增usedCard的arraylist來儲存已發出的牌，新增nUsed來記錄發牌次數，新增ran來取亂數
 * 3.新增shuffle()來洗牌:首先先把nUsed歸零，再來並把UsedCard中的元素權移入cards中，最後做一個跟
 *   cards.size()次數一樣的for迴圈，從頭到尾讓每一格的值跟任意一格交換
 * 4.新增getOneCard()來發牌，先判斷莊家是否還有牌如果沒有的話先進行洗牌，再來把cards中的第一個
 *   元素拿出且迴傳，每做一次nUsed加一
 * 5.在Deck constructor最後呼叫shuffle()來進行洗牌
 */
public class HW3 {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("input N(deck of cards):");
		//String testn= sc.nextLine(); 
		int nDeck=1;
		//TODO: please add new fields and methods to Deck class (35)
		//usedCard (5 points)
		//nUsed (5 points)
		//getOneCard (10 points)
		//shuffle (10 points)
		//constructor (5 points)
		Deck deck=new Deck(nDeck);
		
		//TODO: please check your output, make sure that you print newCard and newCard2 on your screen  (10 points)
		//TODO: please add new fields and methods to Card class (25)
		//Use enumerated type in Card (10 points)
		//Constructor (5 points)
		//printCard (5 points)
		//getSuit (5 points)
		Card newCard=deck.getOneCard();
		newCard.printCard();
		Card newCard2=deck.getOneCard();
		newCard2.printCard();
		deck.shuffle();
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			if(!isShuffleWorking(deck,newCard,newCard2)){
				System.out.println("All Card: Well done! But shufller is not working");
			}else{
				System.out.println("Well done!");
			}
			
		}else{
			System.out.println("All Card: Error, please check your sourse code");
		}

	}
	/**
	 * This method is used for checking your result, not a part of your HW3
	 */
	private static boolean isShuffleWorking(Deck deck,Card newCard,Card newCard2){
		deck.shuffle();
		boolean isCorrect=true;
		if(newCard.getSuit().equals(newCard2.getSuit()) &&
				newCard.getRank()==newCard2.getRank()){
					isCorrect=false;
					return isCorrect;
		}
		for(int i=0;i<53;i++){
			deck.getOneCard();
		}
		if(deck.nUsed!=1){
			isCorrect=false;
		}
		return isCorrect;
	}
	
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			Card.Suit suit= card.getSuit();
			int rank = card.getRank();
			if(rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52||checkHash.keySet().size()==50){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
