import java.util.Scanner;

public class Connect4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] array = new char[6][7];
        for (int row = 0; row < array.length; row++){
            for (int col = 0; col < array[0].length; col++){
                array[row][col] = ' ';
            }
        }
        int turn = 1;
        char player = 'R';
        boolean winner = false;

        while (winner == false && turn <= 42){
            boolean validPlay;
            int play;
            do {
                display(array);
                System.out.print("Player " + player + ", what column do you want to put your piece: ");
                play = in.nextInt();
                validPlay = validate(play,array);
            }while (validPlay == false);
            for (int row = array.length-1; row >= 0; row--){
                if(array[row][play] == ' '){
                    array[row][play] = player;
                    break;
                }
            }
            winner = isWinner(player,array);
            if (player == 'R'){
                player = 'Y';
            }else{
                player = 'R';
            }
            turn++;
        }
        display(array);
        if (winner){
            if (player=='R'){
                System.out.println("Yellow won");
            }else{
                System.out.println("Red won");
            }
        }else{
            System.out.println("Tie game");
        }
    }
    public static void display(char[][] array){
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (int row = 0; row < array.length; row++){
            System.out.print("|");
            for (int col = 0; col < array[0].length; col++){
                System.out.print(array[row][col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println();
    }
    public static boolean validate(int column, char[][] array){
        if (column < 0 || column > array[0].length){
            return false;
        }
        if (array[0][column] != ' '){
            return false;
        }
        return true;
    }
    public static boolean isWinner(char player, char[][] array){
        for(int row = 0; row<array.length; row++){
            for (int col = 0;col < array[0].length - 3;col++){
                if (array[row][col] == player   &&
                        array[row][col+1] == player &&
                        array[row][col+2] == player &&
                        array[row][col+3] == player){
                    return true;
                }
            }
        }
        for(int row = 0; row < array.length - 3; row++){
            for(int col = 0; col < array[0].length; col++){
                if (array[row][col] == player   &&
                        array[row+1][col] == player &&
                        array[row+2][col] == player &&
                        array[row+3][col] == player){
                    return true;
                }
            }
        }
        for(int row = 3; row < array.length; row++){
            for(int col = 0; col < array[0].length - 3; col++){
                if (array[row][col] == player   &&
                        array[row-1][col+1] == player &&
                        array[row-2][col+2] == player &&
                        array[row-3][col+3] == player){
                    return true;
                }
            }
        }
        for(int row = 0; row < array.length - 3; row++){
            for(int col = 0; col < array[0].length - 3; col++){
                if (array[row][col] == player   &&
                        array[row+1][col+1] == player &&
                        array[row+2][col+2] == player &&
                        array[row+3][col+3] == player){
                    return true;
                }
            }
        }
        return false;
    }
}
