package waterSortPuzzle;

public class Runner {

    Vial vial1= new Vial('G', 'E', 'g', 'p');
    Vial vial2= new Vial('O', 'O', 'G', 'N');
    Vial vial3= new Vial('g', 'G', 'R', 'E');
    Vial vial4= new Vial('G', 'P', 'N', 'N');
    Vial vial5= new Vial('S', 'B', 'E', 'E');
    Vial vial6= new Vial('S', 'S', 'P', 'P');
    Vial vial7= new Vial('R', 'b', 'B', 'g');
    Vial vial8= new Vial('Y', 'b', 'g', 'O');
    Vial vial9= new Vial('Y', 'B', 'R', 'b');
    Vial vial10= new Vial('p', 'p', 'B', 'b');
    Vial vial11= new Vial('O', 'Y', 'R', 'N');
    Vial vial12= new Vial('Y', 'p', 'S', 'P');
    Vial vial13= new Vial();
    Vial vial14= new Vial();
    public Vial[] Level337Start= { vial1, vial2, vial3, vial4, vial5, vial6, vial7, vial8, vial9,
            vial10,
            vial11, vial12, vial13, vial14 };

    public Game level337= new Game(Level337Start);

    public static void main(String[] args) {
        System.out.println("pass");

    }

    int stepLimit= 100;

    /** recursive function to solve a game
     *
     * @param toSolve
     * @param steps:  the current list of steps that have been taken to solve the puzzle.
     * @return a list of steps taken to solve the puzzle */
    public String[] solve(Game toSolve, String[] steps) {
        if (toSolve.isDone()) {
            return steps;
        } else if (steps.length > stepLimit) {
            String[] limitMessage= { "limit reached" };// ToDO change this to a break of some sort
            return limitMessage;
        } else {
            int numViles= toSolve.numViles();
            for (int i= 0; i < numViles; i++ ) {
                for (int j= 0; j < numViles; j++ ) {
                    Game gameState= toSolve;
                    Vial[] vials= gameState.getVials();
                    if (gameState.pour(vials[i], vials[j])) {
                        String[] stepsToReturn= { "pour vial " + i + "into vial " + j };
                        String[] result= solve(gameState, stepsToReturn);// TODO: append instead of
                                                                         // replace
                        if (!result[0].equals("limit reached")) { return result; }
                    }
                }
            }
            String[] unsolved= { "unsolved" };
            return unsolved;
        }

    }

}
