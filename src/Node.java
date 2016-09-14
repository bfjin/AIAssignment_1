import java.util.Arrays;
import java.util.ArrayList;



public class Node implements Global{
	public String pieceProperty;
	public String playerProperty;
	public int[] coordinate;
	private Node topLeft;
	private Node topRight;
	private Node left;
	private Node right;
	private Node botLeft;
	private Node botRight;
	private Node pointerToRoot;
	
	//constructor 
	public Node(String piecePropertyValue, String playerPropertyValue, int[]coordinateValue){
		pieceProperty = piecePropertyValue;
		playerProperty = playerPropertyValue;
		coordinate = new int[2];
		coordinate[0] = coordinateValue[0];
		coordinate[1] = coordinateValue[1];
		topLeft = null;	
		topRight = null;	
		left = null;	
		right = null;	
		botLeft = null;	
		botRight = null;
		pointerToRoot = this;
	}

	// insert node into an exist tree if they are connected
	// else make itself a new root of a connected tree and add it into existtree
	public void insertNode(String piecePropertyValue, String playerPropertyValue, int[]coordinateValue, 
			ArrayList<Node> existTree, ArrayList<Node> chessBoard){
		int count = 0;
		// loop through all the pieces of the same color on chessboard
		for (Node element: chessBoard){
			// check if the new node is at topright position of a existing piece
			if (this.coordinate[0] + 1 == element.coordinate[0] && this.coordinate[1] == element.coordinate[1]){
				element.topRight = this;
				this.botLeft = element;
				count ++;

			}
			// check if the new node is at right position of a existing piece
			else if (this.coordinate[0] == element.coordinate[0] && this.coordinate[1] - 1 == element.coordinate[1]){
				element.right = this;
				this.left = element;
				count ++;

			}
			// check if the new node is at botright position of a existing piece
			else if (this.coordinate[0] - 1 == element.coordinate[0] && this.coordinate[1] - 1 == element.coordinate[1]){
				element.botRight = this;
				this.topLeft = element;
				count ++;

			}
			// check if the new node is at botleft position of a existing piece
			else if (this.coordinate[0] - 1 == element.coordinate[0] && this.coordinate[1] == element.coordinate[1]){
				element.botLeft = this;
				this.topRight = element;
				count ++;

			}
			// check if the new node is at left position of a existing piece
			else if (this.coordinate[0] == element.coordinate[0] && this.coordinate[1] + 1 == element.coordinate[1]){
				element.left = this;
				this.right = element;
				count ++;

			}
			// check if the new node is at topleft position of a existing piece
			else if (this.coordinate[0] + 1 == element.coordinate[0] && this.coordinate[1] + 1 == element.coordinate[1]){
				element.topLeft = this;
				this.botRight = element;
				count ++;

			}
			else{
				// do nothing
			}
		}
		// if not connected with any existing pieces, make itself a root node and add to existtree
		if (count == 0){
			existTree.add(this);
		}
	}
	
	public int findWin(BoardConfiguration boardInfo){
		//System.out.println(root.coordinate[0]);
		//System.out.println(root.coordinate[1]);
		for (Node element: boardInfo.getExistTreeBlack()){
			
		}
		return 0;
	}
	
	
	public boolean foundNodeOnBoard(int[] coordinate, ArrayList<Node> chessBoard){
		for(Node element: chessBoard){
			if(element.coordinate.equals(coordinate)){
				return true;
			}
		}
		return false;
	}


	

}
