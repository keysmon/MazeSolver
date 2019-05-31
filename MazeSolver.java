/*
 * MazeSolver.java
 *
 * UVic CSC 115, Spring 2017
 *
 * Purpose:
 *   class that contains a single public static method called
 *   "findPath". To involve the method one must have already created
 *   an instance of Maze. The method must return a path through the
 *   maze (if it exists) in the format shown within the Assignment #3
 *   description.
 *
 * Note: You are free to add to this class whatever other methods will
 * help you in writing a solution to A#3 part 2.
 */

public class MazeSolver {
	
	
    public static String findPath(Maze maze) {
    	
    	StackRefBased<MazeLocation> stack;
    	MazeLocation currentLocation;
    	boolean [][] location;
    	stack = new StackRefBased<MazeLocation>();
        String result = "";
        stack.push(maze.getEntry());
        location = new boolean[maze.getNumRows()][maze.getNumCols()];
        
        try{// while the stack is not empty and it hasn't reach the exit
        	while (!stack.isEmpty() && !stack.peek().equals(maze.getExit()) ){
        		currentLocation = stack.peek();
        		location[currentLocation.getRow()][currentLocation.getCol()] = true;
        		// check if it can move to the left if it's not on the first column
        		if (currentLocation.getCol()!=0 && location[currentLocation.getRow()][currentLocation.getCol()-1]==false&& !maze.isWall(currentLocation.getRow(), currentLocation.getCol()-1)) {
        			stack.push(new MazeLocation(currentLocation.getRow(), currentLocation.getCol()-1));
        			
        		// check if it can move to the right if it's not on the last column
        		}else if(currentLocation.getCol()!=maze.getNumCols()-1 && location[currentLocation.getRow()][currentLocation.getCol()+1]==false && !maze.isWall(currentLocation.getRow(), currentLocation.getCol()+1)) {
        			stack.push(new MazeLocation(currentLocation.getRow(), currentLocation.getCol()+1));
        			
        		// check if it can move up if it's not on the first row
        		}else if(currentLocation.getRow()!=0 && location[currentLocation.getRow()-1][currentLocation.getCol()]==false&&  !maze.isWall(currentLocation.getRow()-1, currentLocation.getCol())) {
        			stack.push(new MazeLocation(currentLocation.getRow()-1, currentLocation.getCol()));
        			
        		// check if it can move down if it's not on the last row
        		}else if(currentLocation.getRow()!=maze.getNumRows()-1 && location[currentLocation.getRow()+1][currentLocation.getCol()]==false&&  !maze.isWall(currentLocation.getRow()+1, currentLocation.getCol())) {
        			stack.push(new MazeLocation(currentLocation.getRow()+1, currentLocation.getCol()));
        			
        		// pop the current location if there's no where to go
        		}else {
        			stack.pop();
        			
        		}	
        		
        	}
        }catch(StackEmptyException a) {
        	a.printStackTrace();
        }
        //return the stack
        if (stack.isEmpty()) {
        	return "";
        }else {
        	result = stack.toString();
        }
        
        return result.trim();
        
    }
    
}
