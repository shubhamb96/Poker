import java.util.Arrays;

public class Poker 
{
	int[] ranksInhand = new int[5];
	int[] suitsInhand = new int[5];
	int rankOfpair;
	
	public void PokerGame(String []card)
	{
		char rankOfcard1 = card[0].charAt(0);
		char rankOfcard2 = card[1].charAt(0);
		char rankOfcard3 = card[2].charAt(0);
		char rankOfcard4 = card[3].charAt(0);
		char rankOfcard5 = card[4].charAt(0);
		
		char suitOfcard1 = card[0].charAt(1);
		char suitOfcard2 = card[1].charAt(1);
		char suitOfcard3 = card[2].charAt(1);
		char suitOfcard4 = card[3].charAt(1);
		char suitOfcard5 = card[4].charAt(1);
		
		char[] rank_cards = {rankOfcard1, rankOfcard2, rankOfcard3, rankOfcard4, rankOfcard5};
		char[] suit_cards = {suitOfcard1, suitOfcard2, suitOfcard3, suitOfcard4, suitOfcard5};
		
		for(int i = 0; i<5; i++)
		{
			if((getRank(rank_cards[i]) == 0) || (getSuit(suit_cards[i]) == 0))
			{
				System.out.println("Error: invalid card name "+"'"+rank_cards[i]+suit_cards[i]+"'");
				System.exit(0);
			}
		}
		
		ranksInhand[0] = getRank(rankOfcard1);
		ranksInhand[1] = getRank(rankOfcard2);
		ranksInhand[2] = getRank(rankOfcard3);
		ranksInhand[3] = getRank(rankOfcard4);
		ranksInhand[4] = getRank(rankOfcard5);
		
		Arrays.sort(ranksInhand);
		
		suitsInhand[0] = getSuit(suitOfcard1);
		suitsInhand[1] = getSuit(suitOfcard2);
		suitsInhand[2] = getSuit(suitOfcard3);
		suitsInhand[3] = getSuit(suitOfcard4);
		suitsInhand[4] = getSuit(suitOfcard5);	
	}
		
	public int getSuit(char Suitofcards)
	{
		char y = Character.toLowerCase(Suitofcards);
		if(y == 's')
		{
			return 1;
		}
		else if(y == 'c')
		{
			return 2;
		}
		else if(y == 'h')
		{
			return 3;
		}
		else if(y == 'd')
		{
			return 4;
		}
		else
		{
		return 0;
		}
	}
		
	public int getRank(char CardRank)
	{
		char x = Character.toLowerCase(CardRank);
		if(x == '2')
		{
			return 2;
		}
		else if(x == '3')
		{
			return 3;
		}
		else if(x == '4')
		{
			return 4;
		}
		else if(x == '5')
		{
			return 5;
		}
		else if(x == '6')
		{
			return 6;
		}
		else if(x == '7')
		{
			return 7;
		}
		else if(x == '8')
		{
			return 8;
		}
		else if(x == '9')
		{
			return 9;
		}
		else if(x == 't')
		{
			return 10;
		}
		else if(x == 'j')
		{
			return 11;
		}
		else if(x == 'q')
		{
			return 12;
		}
		else if(x == 'k')
		{
			return 13;
		}
		else if(x == 'a')
		{
			return 14;
		}
		else
		{
			return 0;
		}
	}

	public String Display(int A)
	{
		if(A == 2) 
		{
			String B = "2";
			return B; 
		}
		else if(A == 3) 
		{
			String B = "3";
			return B; 
		}
		else if(A == 4) 
		{
			String B = "4";
			return B; 
		}
		else if(A == 5) 
		{
			String B = "5";
			return B; 
		}
		else if(A == 6) 
		{
			String B = "6";
			return B; 
		}
		else if(A == 7) 
		{
			String B = "7";
			return B; 
		}
		else if(A == 8) 
		{
			String B = "8";
			return B; 
		}
		else if(A == 9) 
		{
			String B = "9";
			return B; 
		}
		else if(A == 10) 
		{
			String B = "10";
			return B; 
		}
		else if(A == 11) 
		{
			String B = "Jack";
			return B; 
		}
		else if(A == 12)
		{
			String B = "Queen";
			return B;
		}
		else if(A == 13)
		{
			String B = "King";
			return B;
		}
		else if(A == 14)
		{
			String B = "Ace";
			return B;
		}
		else
		{
			return null;
		}
	}
	
	public void checkAndDisplay()
	{
		if(StraightFlush())
		{
			System.out.println("Player 1: "+Display(ranksInhand[4])+"-high straight flush");
		}
		else if(fourOfAkind())
		{
			System.out.println("Player 1: Four "+Display(ranksInhand[2])+"s");
		}
		else if(fullHouse())
		{
			if(ranksInhand[2] == ranksInhand[4])
			{
				System.out.println("Player 1: "+Display(ranksInhand[2])+"s full of "+Display(ranksInhand[0])+"s");
			}
			else
			{
				System.out.println("Player 1: "+Display(ranksInhand[2])+"s full of "+Display(ranksInhand[4])+"s");
				
			}
		}
		else if(flush())
		{
			System.out.println("Player 1: "+Display(ranksInhand[4])+"-high flush");
		}
		else if(Straight())
		{
				System.out.println("Player 1: "+Display(ranksInhand[4])+"-high straight");
		}
		else if(threeOfAkind())
		{
				System.out.println("Player 1: Three "+Display(ranksInhand[2])+"s");
		}
		
		else if(twoPair())
		{
			System.out.println("Player 1: "+Display(ranksInhand[3])+"s over "+Display(ranksInhand[1])+"s");
		}
		else if(pair())
		{
				System.out.println("Player 1: Pair of "+Display(rankOfpair)+"s");
		}
		else
		{
			System.out.println("Player 1: "+Display(ranksInhand[4])+"-high");
		}
	}
	
	public boolean StraightFlush()
	{
		int correct = 0;
		int incorrect = 0;
		
		if((suitsInhand[0] == suitsInhand[1]) && (suitsInhand[1] == suitsInhand[2]) && (suitsInhand[3] == suitsInhand[4]))
		{
			correct++;
		}
		else
		{
			incorrect++;
		}
			
		for(int j = 0; j < ranksInhand.length - 1;j++)
		{
			if(ranksInhand[j] + 1 != ranksInhand[j+1])
			{
				incorrect++;
			}
			else
			{
				correct++; //4
			}
		}
		if(correct == 5 && incorrect == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean Straight()
	{
		int correct = 0;
		int incorrect = 0;
			
			for(int j = 0; j < ranksInhand.length - 1;j++)
			{
				if((ranksInhand[j] + 1) != (ranksInhand[j+1]))
				{
					incorrect++;
				}
				else
				{
					correct++; //4
				}
			}
			
			if(correct == 4 && incorrect == 0)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	public boolean flush()
	{
		int correct = 0;
		int incorrect = 0;
		if((suitsInhand[0] == suitsInhand[1]) && (suitsInhand[1] == suitsInhand[2]) && (suitsInhand[3] == suitsInhand[4]))
		{
			correct++; //1
		}
		else 
		{
			incorrect++; //0
		}
		if(correct == 1 && incorrect == 0 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean fourOfAkind()
	{
		boolean condition1, condition2;
		condition1 = (ranksInhand[0] == ranksInhand[1]) && (ranksInhand[1] == ranksInhand[2]) && (ranksInhand[2]==ranksInhand[3]);
		condition2 = (ranksInhand[1] == ranksInhand[2]) && (ranksInhand[2] == ranksInhand[3]) && (ranksInhand[3] == ranksInhand[4]);
		
		if( condition1 == true || condition2 ==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean threeOfAkind()
	{
		boolean condition1, condition2, condition3;
		if((fourOfAkind() == true) || (fullHouse() == true)) 
		{
			return false;
		}
		else
		{
			condition1=(ranksInhand[0] == ranksInhand[1]) && (ranksInhand[1] == ranksInhand[2]); 
			condition2=(ranksInhand[1] == ranksInhand[2]) && (ranksInhand[2] == ranksInhand[3]);
			condition3=(ranksInhand[2] == ranksInhand[3]) && (ranksInhand[3] == ranksInhand[4]);
			
			if(condition1 == true ||  condition2 == true || condition3 == true)
			{
				return true;
			}
			else
			{
				return false;
			}	
		}
	}
	
	public boolean fullHouse()
	{
		boolean condition1, condition2;
		
		condition1 = ((ranksInhand[0] == ranksInhand[1]) && (ranksInhand[1] == ranksInhand[2])) && (ranksInhand[3] == ranksInhand[4]);
		condition2 = (ranksInhand[0] == ranksInhand[1]) && ((ranksInhand[2] == ranksInhand[3]) && (ranksInhand[3] == ranksInhand[4])); 
		
		if((condition1 == true) || (condition2 == true))
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	public boolean pair()
	{
		for(int i = 0; i<ranksInhand.length;i++)
		{
			for(int j = i+1; j<ranksInhand.length;j++)
			{
				if(ranksInhand[i] == ranksInhand[j])
				{
					rankOfpair = ranksInhand[i];
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean twoPair()
	{
		int counter = 0;
		for(int i = 0; i<ranksInhand.length;i++)
			{
				for(int j = i+1; j<ranksInhand.length;j++)
				{
					if(ranksInhand[i] == ranksInhand[j])
					{
						counter++;
					}
				}
			}
		if(counter == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String []args)
	{
		if(args.length == 5)
		{
		Poker obj = new Poker();
		obj.PokerGame(args);
		obj.checkAndDisplay();
		}
		else if(args.length > 5)
		{
			System.out.println("NOT UNDERTAKEN");
		}
		else
		{
			System.out.println("Error: wrong number of arguments; must be a multiple of 5");
		}
	}
}