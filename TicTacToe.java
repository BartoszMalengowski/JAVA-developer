package four;

import java.util.Scanner;

class Test {
    static String cellc;
    static boolean xMove = true;
    static boolean oMove = true;
    static int firstCoordinate;
    static int secondCoordinate;
    static char[] grids;
    static boolean gameFinished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cellc = "         ";
        grids = cellc.toCharArray();
        System.out.println("---------");
        System.out.println("| " + cellc.charAt(0) + " " + cellc.charAt(1) + " " + cellc.charAt(2) + " |");
        System.out.println("| " + cellc.charAt(3) + " " + cellc.charAt(4) + " " + cellc.charAt(5) + " |");
        System.out.println("| " + cellc.charAt(6) + " " + cellc.charAt(7) + " " + cellc.charAt(8) + " |");
        System.out.println("---------");
        reply();

    }

    static void reply() {
        while (!gameFinished) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the coordinates: ");
            try {
                firstCoordinate = scanner.nextInt();
                secondCoordinate = scanner.nextInt();
                if (firstCoordinate > 3 || secondCoordinate > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    reply();
                }

                if (xMove) {
                    if (firstCoordinate == 1 && secondCoordinate == 1 && grids[0] == ' ') {
                        grids[0] = 'X';
                    } else if (firstCoordinate == 1 && secondCoordinate == 2 && grids[1] == ' ') {
                        grids[1] = 'X';
                    } else if (firstCoordinate == 1 && secondCoordinate == 3 && grids[2] == ' ') {
                        grids[2] = 'X';
                    } else if (firstCoordinate == 2 && secondCoordinate == 1 && grids[3] == ' ') {
                        grids[3] = 'X';
                    } else if (firstCoordinate == 2 && secondCoordinate == 2 && grids[4] == ' ') {
                        grids[4] = 'X';
                    } else if (firstCoordinate == 2 && secondCoordinate == 3 && grids[5] == ' ') {
                        grids[5] = 'X';
                    } else if (firstCoordinate == 3 && secondCoordinate == 1 && grids[6] == ' ') {
                        grids[6] = 'X';
                    } else if (firstCoordinate == 3 && secondCoordinate == 2 && grids[7] == ' ') {
                        grids[7] = 'X';
                    } else if (firstCoordinate == 3 && secondCoordinate == 3 && grids[8] == ' ') {
                        grids[8] = 'X';
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        reply();
                    }
                    oMove = true;
                    xMove = false;
                    answer();
                }
                else if (oMove) {
                    if (firstCoordinate == 1 && secondCoordinate == 1 && grids[0] == ' ') {
                        grids[0] = 'O';
                    } else if (firstCoordinate == 1 && secondCoordinate == 2 && grids[1] == ' ') {
                        grids[1] = 'O';
                    } else if (firstCoordinate == 1 && secondCoordinate == 3 && grids[2] == ' ') {
                        grids[2] = 'O';
                    } else if (firstCoordinate == 2 && secondCoordinate == 1 && grids[3] == ' ') {
                        grids[3] = 'O';
                    } else if (firstCoordinate == 2 && secondCoordinate == 2 && grids[4] == ' ') {
                        grids[4] = 'O';
                    } else if (firstCoordinate == 2 && secondCoordinate == 3 && grids[5] == ' ') {
                        grids[5] = 'O';
                    } else if (firstCoordinate == 3 && secondCoordinate == 1 && grids[6] == ' ') {
                        grids[6] = 'O';
                    } else if (firstCoordinate == 3 && secondCoordinate == 2 && grids[7] == ' ') {
                        grids[7] = 'O';
                    } else if (firstCoordinate == 3 && secondCoordinate == 3 && grids[8] == ' ') {
                        grids[8] = 'O';
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        reply();
                    }
                    xMove = true;
                    oMove = false;
                    answer();
                }



            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                reply();
            }

        }
    }
    static void answer () {
        System.out.println("---------");
        System.out.println("| " + grids[0] + " " + grids[1] + " " + grids[2] + " |");
        System.out.println("| " + grids[3] + " " + grids[4] + " " + grids[5] + " |");
        System.out.println("| " + grids[6] + " " + grids[7] + " " + grids[8] + " |");
        System.out.println("---------");
        check();
        reply();
    }




    static void check() {
        boolean xWinner = false;
        boolean oWinner = false;
        boolean draw = false;
        boolean impossible =false;
        int xCounter = 0;
        int oCounter = 0;

        //Row
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                xCounter = 0;
                oCounter = 0;
            }

            if (grids[i] == 'X') {
                xCounter++;
            } else if (grids[i] == 'O') {
                oCounter++;
            }

            if (xCounter == 3) {
                xWinner = true;
            }
            if (oCounter == 3) {
                oWinner = true;
            }
        }


        //column
        for (int j = 0; j < 9 - 3; j++) {
            if (grids[0] == 'X' && grids[3] == 'X' && grids[6] == 'X' ||
                    grids[1] == 'X' && grids[4] == 'X' && grids[7] == 'X' ||
                    grids[2] == 'X' && grids[5] == 'X' && grids[8] == 'X'){
                xCounter++;
            }
            if (grids[0] == 'O' && grids[3] == 'O' && grids[6] == 'O' ||
                    grids[1] == 'O' && grids[4] == 'O' && grids[7] == 'O' ||
                    grids[2] == 'O' && grids[5] == 'O' && grids[8] == 'O') {
                oCounter++;
            }
            if (xCounter == 3) {
                xWinner = true;
            }
            if (oCounter == 3) {
                oWinner = true;
            }
        }

        //diagonal
        for (int k = 0; k < 9; k++) {
            if (grids[0] == 'X' && grids[4] == 'X' && grids[8] == 'X' ||
                    grids[2] == 'X' && grids[4] == 'X' && grids[6] == 'X') {
                xCounter++;
            }
            if (grids[0] == 'O' && grids[4]== 'O' && grids[8]== 'O' ||
                    grids[2]== 'O' && grids[4]== 'O' && grids[6]== 'O') {
                oCounter++;
            }
            if (xCounter == 3) {
                xWinner = true;
            }
            if (oCounter == 3) {
                oWinner = true;
            }
        }


        xCounter = 0;
        oCounter = 0;

        for (int m = 0; m < 9; m++) {
            if (grids[m] == 'X') {
                xCounter++;
            }
            if (grids[m] == 'O') {
                oCounter++;
            }

            if (oCounter + xCounter == 9) {
                draw = true;
            }
        }


        if (xWinner && oWinner) {
            System.out.println("Impossible");
            gameFinished = true;
        } else if (xWinner) {
            System.out.println("X wins");
            gameFinished = true;
        } else if (oWinner) {
            System.out.println("O wins");
            gameFinished = true;
        } else if (draw) {
            System.out.println("Draw");
            gameFinished = true;
        }
    }
}