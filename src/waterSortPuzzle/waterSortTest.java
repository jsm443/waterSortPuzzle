package waterSortPuzzle;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class waterSortTest {

    public Game game= new Game();

    public Vial vial1= new Vial('g', 'b', 'G', 'P');
    public Vial vial2= new Vial('o', 'e', 'r', 'O');
    public Vial vial3= new Vial('a', 'e', 'e', 'P');
    public Vial vial4= new Vial('o', 'G', 'O', 'O');
    public Vial vial5= new Vial('Y', 'p', 'B', 'G');
    public Vial vial6= new Vial('b', 'B', 'b', 'O');
    public Vial vial7= new Vial('Y', 'o', 'R', 'G');
    public Vial vial8= new Vial('P', 'G', 'g', 'p');
    public Vial vial9= new Vial('p', 'B', 'Y', 'e');
    public Vial vial10= new Vial('P', 'R', 'a', 'g');
    public Vial vial11= new Vial('b', 'Y', 'B', 'o');
    public Vial vial12= new Vial('a', 'p', 'a', 'R');
    public Vial vial13= new Vial();
    public Vial vial14= new Vial();

    @Test
    void test() {
        assertEquals(game.pour(vial1, vial13), true);// tests that vile can be poored into empty
                                                     // vile
        assertEquals(game.pour(vial1, vial11), false);// tests that vial can't be poured into full
                                                      // vile

    }

    @Test
    void testCombination() {
        game.pour(vial7, vial13);
        game.pour(vial5, vial13);
        assertEquals("YYzz", vial13.statement());// test poor on empty and combine
        game.pour(vial2, vial13);
        assertEquals("YYzz", vial13.statement());// tests no poor on full
    }

    @Test
    void poorMultipe() {
        game.pour(vial7, vial14);
        game.pour(vial4, vial13);
        game.pour(vial2, vial7);
        assertEquals("GRoo", vial7.statement());
        game.pour(vial7, vial13);
        assertEquals("oooz", vial13.statement());
    }

//    @Test
//    void testResultTester() {
//        for (int c= 0; c < 13; c++ ) {
//            result[0]= "T";
//            if (!gamestate[c].isComplete(gamestate[c])) {
//                result[0]= "T";
//            }
//        }
//    }

}
