// import java.io.IOException;
// import java.util.Scanner;

// public class BattleshipMain {
//     public static void main(String[]args) throws IOException{
//         Scanner sc = new Scanner(System.in);
//         Captain player1 = new Player("Jo");
//         Captain player2 = new SimpleAI("Bot");
//         boolean gameIsOver = false;

//         while(!gameIsOver){
//             System.out.println(player1.getName() + "'s GRID");
//             player1.getGrid().printGrid();
//             System.out.println(player2.getName() + "'s GRID");
//             player2.getGrid().printGrid();

//             int[] hit1 = player1.target();
//             player2.getGrid().attack(hit1[0], hit1[1]);

//             int[] hit2 = player2.target();
//             player1.getGrid().attack(hit2[0], hit2[1]);

//         }

//     }
// }
