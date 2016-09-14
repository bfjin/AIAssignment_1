import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class AI_Test {
	public static void main(String[] args){
		Scanner inputStream = null;
		try{
			//input.txt is provided on lms, make sure it is the same directory of the java file
			inputStream = new Scanner(new FileInputStream("input.txt"));
		}
		catch(FileNotFoundException e){
			System.out.println("File was not found or could not be opened.");
			System.exit(0);
		}
			
		// the size of the chessboard
		int n = inputStream.nextInt();
		
		// debugging code 
		System.out.println("N is " + n);
		
		// assigning properties of each piece
		String symbol = null;
		int[] coordinate = new int[2];
		int x = 0;
		int y = 0;
		String playerProperty;
		String pieceProperty = "";
		
		BoardConfiguration boardInfo = new BoardConfiguration(n);
		
		// existtree is an array of nodes that is the root node of a connected piece
		// chessboard is an array of nodes that is currently presented on the chessboard
		ArrayList<Node> existTreeBlack = new ArrayList<Node>(5);
		ArrayList<Node> existTreeWhite = new ArrayList<Node>(5);
		ArrayList<Node> chessBoardBlack = new ArrayList<Node>(30);
		ArrayList<Node> chessBoardWhite = new ArrayList<Node>(30);
		ArrayList<Node> path = new ArrayList<Node>(30);
		ArrayList<Node> tripod = new ArrayList<Node>(3);
		
		// reading input, analyzing and doing some math to calculate its coordinate and pieceproperty
		// start reading input
		while(inputStream.hasNext()){			
			symbol = inputStream.next();		
			if(x == 0 && y == 0){
				coordinate[0] = y;
				coordinate[1] = x;
				x ++;
				pieceProperty = "Corner";
			}
			else{
				if(y <= n - 1){
					if ((x - y) != (n - 1)){
						coordinate[0] = y;
						coordinate[1] = x;
						if( y == 0){
							pieceProperty = "Top";
						}
						else if ( x == 0 && y != n -1){
							pieceProperty = "TopLeft";
						}
						else if ( x == 0 && y == n -1){
							pieceProperty = "Corner";
						}
						else{
							pieceProperty = "Middle";
						}
						x ++;
					}
					else{
						coordinate[0] = y;
						coordinate[1] = x;
						if (y == 0){
							pieceProperty = "Corner";
						}
						else if (x == 2*n - 2 && y == n - 1){
							pieceProperty = "Corner";
						}
						else{
							pieceProperty = "TopRight";
						}
						x = 0;
						y ++;
					}
				}
				else{
					if(y == n && x == 0){
						x ++;
					}
					if ( x < 2*n - 2){
						coordinate[0] = y;
						coordinate[1] = x;
						if (y == 2*n - 2 && x != n - 1){
							pieceProperty = "Bot";
						}
						else if (y == 2*n - 2 && x == n - 1){
							pieceProperty = "Corner";
						}
						else if(y - x == n - 1){
							pieceProperty = "BotLeft";
						}
						else{
							pieceProperty = "Middle";
						}
						x ++;
					}
					else{
						coordinate[0] = y;
						coordinate[1] = x;
						if( x == 2*n -2){
							pieceProperty = "Corner";
						}
						else{
							pieceProperty = "BotRight";
						}
						y ++;
						x = y - n + 1;						
					}
				}
			
			}

			if(symbol.equals("B")){
				playerProperty = "B";
			}
			else if(symbol.equals("W")){
				playerProperty = "W";
			}
			else{
				playerProperty = "E";
			}
			// end reading input
			
			// make a new node
			Node newNode = new Node (pieceProperty, playerProperty, coordinate);
			
			if(newNode.playerProperty == "B"){	
				// add the first node into the array
				if (existTreeBlack.isEmpty()){
					existTreeBlack.add(newNode);
					chessBoardBlack.add(newNode);
				}		
				else{
					// if it's is not the first node, check if that node is connected with existing trees
					newNode.insertNode(pieceProperty, playerProperty, coordinate, existTreeBlack, chessBoardBlack);
					// connected or not the piece will be added into the chessboard array as it's representing the current board state
					chessBoardBlack.add(newNode);
				}

			}
			// same for white pieces, making black and white pieces separated is for later easier analyze win and lose condition
			else if(newNode.playerProperty == "W"){				
				if (existTreeWhite.isEmpty()){
					existTreeWhite.add(newNode);
					chessBoardWhite.add(newNode);
				}		
				else{
					newNode.insertNode(pieceProperty, playerProperty, coordinate, existTreeWhite, chessBoardWhite);
					chessBoardWhite.add(newNode);
				}
			}
			else{
				// do nothing if empty
			}
			
		}

		// debugging code
		for (Node element: chessBoardWhite){
			System.out.println("y " + element.coordinate[0]);
			System.out.println("x " + element.coordinate[1]);
		}
		
	}
}
