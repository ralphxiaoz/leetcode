/*
 * A matrix
 * [1] [2] [3] [4]
 * [12] [13] [14] [5]
 * [11] [16] [15] [6]
 * [10] [9] [8] [7]
 * output in sequence of: 1,2,3,...16
 * 
 * Here I consider all elements in matrix are positive integers.
 * This solution doesn't care if the matrix is N*N. Could have random rows/columns.
 * */
public class EpicMatrix {
	
	public static void main(String[] args){
		int[][] matrix= {{1,2,3,4}, {12,13,14,5}, {11,16,15,6}, {10,9,8,7}};
		int vertical=0;
		int horizontal = 0;
		String direction = "";
		while (true) {
			direction = whereToGO(vertical, horizontal, matrix);
			System.out.println(matrix[vertical][horizontal]);
			
			// set current value to -1, then go up/down/left/right. break out of the loop when end.
			if (direction.equals("up")) {
				matrix[vertical][horizontal] = -1;
				vertical--;
			}
			if (direction.equals("down")) {
				matrix[vertical][horizontal] = -1;
				vertical++;
			}
			if (direction.equals("left")) {
				matrix[vertical][horizontal] = -1;
				horizontal--;
			}
			if (direction.equals("right")) {
				matrix[vertical][horizontal] = -1;
				horizontal++;
			}
			if (direction.equals("end")) {
				break;
			}
		}
	}
	
	/*
	 * this method determines which direction to go next. 
	 * if  4 directions are blocked, return "end";
	 * if 3 directions are blocked, return the 4th one;
	 * if 2 directions are blocked, return the chosen one; 
	 * */
	public static String whereToGO(int vertical, int horizontal, int[][] matrix ){
		boolean upBlocked = false;
		boolean downBlocked = false; 
		boolean leftBlocked = false;
		boolean rightBlocked = false;
		
		// exception means out of boundary of the matrix
		try {
			if (matrix[vertical-1][horizontal] == -1)
				upBlocked = true;
		} catch (ArrayIndexOutOfBoundsException e) {
			upBlocked = true;
		}
		try {
			if (matrix[vertical+1][horizontal] == -1)
				downBlocked = true;
		} catch (ArrayIndexOutOfBoundsException e) {
			downBlocked = true;
		}
		try {
			if (matrix[vertical][horizontal-1] == -1)
				leftBlocked = true;
		} catch (ArrayIndexOutOfBoundsException e) {
			leftBlocked = true;
		}
		try {
			if (matrix[vertical][horizontal+1] == -1)
				rightBlocked = true;
		} catch (ArrayIndexOutOfBoundsException e) {
			rightBlocked = true;
		}
		
		// 4 directions blocked
		if (rightBlocked && leftBlocked && upBlocked && downBlocked) {
			return "end";
		}

		// 3 directions blocked
		if (rightBlocked && upBlocked && downBlocked) {
			return "left";
		}else if (rightBlocked && leftBlocked && upBlocked) {
			return "down";
		}else if (rightBlocked && leftBlocked && downBlocked) {
			return "up";
		}else if (downBlocked && leftBlocked && upBlocked) {
			return "right";
		}
		
		// 2 directions blocked
		if (rightBlocked && upBlocked) {
			return "down";
		}else if (rightBlocked && downBlocked) {
			return "left";
		}else if (leftBlocked && upBlocked) {
			return "right";
		}else if (leftBlocked && downBlocked) {
			return "up";
		}else {
			return "";
		}
	}
	
}
