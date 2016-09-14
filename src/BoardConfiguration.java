import java.util.ArrayList;



public class BoardConfiguration implements Piece {

	private ArrayList<Node> existTreeBlack;
	private ArrayList<Node> existTreeWhite;
	private ArrayList<Node> chessBoardBlack;
	private ArrayList<Node> chessBoardWhite;
	private int[][] chessBoard;
	private ArrayList<Node> path;
	private ArrayList<Node> tripod;

	
	
	public BoardConfiguration(int n){
		existTreeBlack = new ArrayList<Node>(5);
		existTreeWhite = new ArrayList<Node>(5);
		chessBoardBlack = new ArrayList<Node>(n/2 + 1);
		chessBoardWhite = new ArrayList<Node>(n/2 + 1);
		path = new ArrayList<Node>(n/2 + 1);
		tripod = new ArrayList<Node>(3);
		chessBoard = new int[2*n-2][2*n-2];
		int lowerBoundary = 0;
		int upperBoundary = 2*n - 2;
		for (int i = 0; i < 2 * n - 2; i ++){
			for (int j = 0; j < 2 * n - 2; j ++){
				if( i < lowerBoundary || i > upperBoundary || j < lowerBoundary){
					chessBoard[i][j] = INVALID;
				}
				else if(i < n - 1 && j > ((2 * n - 2) - (n - 1 - i))){
					chessBoard[i][j] = INVALID;
				}
				else if(i >= n - 1 && j > (2 * n - 2)){
					chessBoard[i][j] = INVALID;
				}
				else{
					chessBoard[i][j] = EMPTY;
				}
				
			}			
		}
	}
	

	public ArrayList<Node> getExistTreeBlack() {
		return existTreeBlack;
	}

	public void setExistTreeBlack(ArrayList<Node> existTreeBlack) {
		this.existTreeBlack = existTreeBlack;
	}

	public ArrayList<Node> getExistTreeWhite() {
		return existTreeWhite;
	}

	public void setExistTreeWhite(ArrayList<Node> existTreeWhite) {
		this.existTreeWhite = existTreeWhite;
	}

	public ArrayList<Node> getChessBoardBlack() {
		return chessBoardBlack;
	}

	public void setChessBoardBlack(ArrayList<Node> chessBoardBlack) {
		this.chessBoardBlack = chessBoardBlack;
	}

	public ArrayList<Node> getChessBoardWhite() {
		return chessBoardWhite;
	}

	public void setChessBoardWhite(ArrayList<Node> chessBoardWhite) {
		this.chessBoardWhite = chessBoardWhite;
	}
	
	public int[][] getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(int[][] chessBoard) {
		this.chessBoard = chessBoard;
	}

	public ArrayList<Node> getPath() {
		return path;
	}

	public void setPath(ArrayList<Node> path) {
		this.path = path;
	}

	public ArrayList<Node> getTripod() {
		return tripod;
	}

	public void setTripod(ArrayList<Node> tripod) {
		this.tripod = tripod;
	}
	
}