package waterSortPuzzle;

public class Game {

    Vial[] gameState;
    boolean isComplete;

    public Game(Vial[] gameStateIn) {
        gameState= gameStateIn;
    }

    public Vial[] getVials() {
        return gameState;
    }

    /** @param curGame the game object to check for completion
     * @return true if the game is completed and false if not */
    public boolean isDone() {
        for (Vial v : gameState) {
            if (!v.isComplete(v)) {
                isComplete= false;
                return false;
            }
        }
        isComplete= true;
        return isComplete;
    }

    /** @return the number of viles in the game. */
    public int numViles() {
        return gameState.length;
    }

    /** Updates the vials based on the pours
     *
     * @param pourer   the Vial object that is being poured
     * @param reciever the Vial object that is recieving the pourer
     * @return true if the poor is possible and false if not */
    public boolean pour(Vial pourer, Vial reciever) {
        int pouredNumber= pourer.getNumStuff();
        if (pouredNumber == 0 | reciever.isIsfull()) { return false; }
        char pouring= 'z'; // default sets the character to z which is nothing.
        int recievedNumber= reciever.getNumStuff(); // defines the how full the recieving vial is
        int numPoor= 1; // defines the number of blocks to poor

        // sets the pouring character. and num poor character;
        if (pouredNumber == 4) {
            pouring= pourer.getTop();
            if (pourer.getUpper() == pouring) {
                numPoor= 2;
                if (pourer.getLower() == pouring) {
                    numPoor= 3;
                    if (pourer.getBottom() == pouring) {
                        numPoor= 4;
                    }
                }
            }
        } else if (pouredNumber == 3) {
            pouring= pourer.getUpper();
            if (pourer.getLower() == pouring) {
                numPoor= 2;
                if (pourer.getBottom() == pouring) {
                    numPoor= 3;
                }
            }
        } else if (pouredNumber == 2) {
            pouring= pourer.getLower();
            if (pourer.getBottom() == pouring) {
                numPoor= 2;
            }
        } else if (pouredNumber == 1) {
            pouring= pourer.getBottom();
        }

        if (recievedNumber == 3) {
            if (reciever.getUpper() != pouring) return false;
            reciever.setTop(pouring);
            reciever.setNumStuff(4);
            reciever.setIsfull(true);
            if (pourer.getNumStuff() == 4) {
                pourer.setTop('z');
                pourer.setNumStuff(3);
                pourer.setIsfull(false);
            } else if (pourer.getNumStuff() == 3) {
                pourer.setUpper('z');
                pourer.setNumStuff(2);
            } else if (pourer.getNumStuff() == 2) {
                pourer.setLower('z');
                pourer.setNumStuff(1);
            }
        } else if (recievedNumber == 2) {
            if (reciever.getLower() != pouring) return false;
            reciever.setUpper(pouring);
            reciever.setNumStuff(3);
            if (pourer.getNumStuff() == 4) {
                pourer.setTop('z');
                pourer.setNumStuff(3);
                pourer.setIsfull(false);
            } else if (pourer.getNumStuff() == 3) {
                pourer.setUpper('z');
                pourer.setNumStuff(2);
            } else if (pourer.getNumStuff() == 2) {
                pourer.setLower('z');
                pourer.setNumStuff(1);
            }
        } else if (recievedNumber == 1) {
            if (reciever.getBottom() != pouring) return false;
            reciever.setLower(pouring);
            reciever.setNumStuff(2);
            if (pourer.getNumStuff() == 4) {
                pourer.setTop('z');
                pourer.setNumStuff(3);
                pourer.setIsfull(false);
            } else if (pourer.getNumStuff() == 3) {
                pourer.setUpper('z');
                pourer.setNumStuff(2);
            } else if (pourer.getNumStuff() == 2) {
                pourer.setLower('z');
                pourer.setNumStuff(1);
            }
        } else if (recievedNumber == 0) {
            reciever.setBottom(pouring);
            reciever.setNumStuff(1);
            if (pourer.getNumStuff() == 4) {
                pourer.setTop('z');
                pourer.setNumStuff(3);
                pourer.setIsfull(false);
            } else if (pourer.getNumStuff() == 3) {
                pourer.setUpper('z');
                pourer.setNumStuff(2);
            } else if (pourer.getNumStuff() == 2) {
                pourer.setLower('z');
                pourer.setNumStuff(1);
            }
        }

        if (numPoor > 1) {
            pour(pourer, reciever);
        }

        return true;

    }
}
