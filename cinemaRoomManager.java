package cinema;

import java.util.Scanner;

 class Cinema {


    /**
     *
     *  rows
     *  seats
     *  room
     * Creates the empty cinema room when none of the seats are taken. S represents empty seats.
     */
    public static void fillEmptyCinemaRoom(int rows, int seats, char[][] room) {
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0 && j == 0) {
                    room[i][j] = ' ';
                } else if (i == 0) {
                    room[i][j] = (char) ('0' + j);
                } else if (j == 0) {
                    room[i][j] = (char) ('0' + i);
                } else {
                    room[i][j] = 'S';
                }
            }
        }
    }

    /**
     *
     *  rows
     *  seats
     *  room
     * Shows the actual cinema room. B represent taken seats, S represents free seats.
     */
    public static void showTheSeats(int rows, int seats, char[][] room){
        System.out.printf("%nCinema:%n");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     *  rows
     *  seats
     *  room
     * Asks for a row and seat number then gives the price of that seat.
     * Changes the taken seat symbol from S to B.
     */
    public static void buyTicket(int rows, int seats, char[][] room) {
        Scanner sc = new Scanner(System.in);
        int firstRows = rows / 2;
        boolean bigRoom = rows * seats > 60;
        boolean validInput = false;

        System.out.printf("%nEnter a row number:%n");
        int xRow = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int xSeat = sc.nextInt();

        do {

            if (xRow > rows || xRow < 1 || xSeat > seats || xSeat < 1) {
                System.out.println("Wrong input!");
                System.out.printf("%nEnter a row number:%n");
                xRow = sc.nextInt();
                System.out.println("Enter a seat number in that row:");
                xSeat = sc.nextInt();
            } else if (room[xRow][xSeat] == 'B') {
                System.out.println("That ticket has already been purchased!");
                System.out.printf("%nEnter a row number:%n");
                xRow = sc.nextInt();
                System.out.println("Enter a seat number in that row:");
                xSeat = sc.nextInt();
            } else {
                room[xRow][xSeat] = 'B';
                validInput = true;
            }
        } while (!validInput);


        int ticketPrice = 10;
        if (bigRoom && xRow > firstRows) {
            ticketPrice = 8;
        }
        System.out.printf("%nTicket price: $%d%n", ticketPrice);
    }

    public static void statistics(int rows, int seats, char[][] room) {
        int taken = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        boolean bigRoom = rows * seats > 60;

        int firstSeats = rows / 2;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= seats; j++) {
                if (room[i][j] == 'B') {
                    taken++;
                    if (bigRoom) {
                        if(i <= firstSeats) {
                            currentIncome += 10;
                        } else {
                            currentIncome += 8;
                        }
                    } else {
                        currentIncome += 10;
                    }
                }
                if (bigRoom) {
                    if(i <= firstSeats) {
                        totalIncome += 10;
                    } else {
                        totalIncome += 8;
                    }
                } else {
                    totalIncome += 10;
                }
            }
        }

        System.out.println("Number of purchased tickets: " + taken);
        double percentage = (double) taken / (rows * seats) * 100;
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", totalIncome);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        char[][] room = new char[rows + 1][seats + 1];

        fillEmptyCinemaRoom(rows, seats, room);

        boolean reservationInProgress = true;

        while (reservationInProgress) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int whatToDo = sc.nextInt();

            switch (whatToDo) {
                case 1: showTheSeats(rows, seats, room);
                    break;
                case 2: buyTicket(rows, seats, room);
                    break;
                case 3: statistics(rows, seats, room);
                    break;
                case 0: reservationInProgress = false;
                    break;
            }
        }
    }
}