package oop;

class card{
	cardsuit suit ;
	int value;
	faceCard face_card;
	
	public card(cardsuit suit, int value, faceCard card){
		this.suit = suit;
		this.value = value;
		this.face_card = card;
	}
}

class blackJackCard extends card{
	public blackJackCard(cardsuit suit, int value, faceCard card){
		super(suit,value,card);
		
		if(face_card == null){
			
		}
	}
}

enum cardsuit {dimond,heart,club,spade}
enum faceCard {jack,queen,king,ace}

public class DeckOfCards {
	
	

}
