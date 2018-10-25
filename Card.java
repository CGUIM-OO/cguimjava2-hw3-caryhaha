public class Card{
	private Suit suit;
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	enum Suit {Club,Diamond,Heart,Spade};
	public Card(Suit s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace	
				System.out.println(getSuit()+","+getRank());
		}

	public Suit getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
