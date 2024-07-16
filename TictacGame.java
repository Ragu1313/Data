import java.util.Scanner;

public class Tictacgame{
    public static  void print(char [][] m){
        int j;
        System.out.println();
        for(int i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(m[i][j]+" |");
            }
            System.out.println();
            for(j=0;j<10;j++)
                System.out.print('—');
            System.out.println();
        }
        // for(int i=0;i<3;i++){
        //     for(j=0;j<3;j++){
        //         System.out.print(m[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        System.out.println();
    }
    public static void main(String[] args) {
        char [][] m = new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                m[i][j]=' ';
            }
        }
        char ch = 'X';
        boolean endGame = false;
        System.out.println("Game starts from X");
        try (Scanner s = new Scanner(System.in)) {
            while(!endGame){
                System.out.println("Enter the index of the element to place i and j");
                int i = s.nextInt();
                int j = s.nextInt();
                if(m[i][j]!=' '){
                    System.out.println("Invalid move");
                    endGame = true;
                    break;
                }
                else{
                    m[i][j] = ch;
                    print(m);
                    boolean check = checkWin(m,ch,i,j);
                    if(check){
                        System.out.println();
                        System.out.println(ch+" win the game");
                        endGame = true;
                        return ;
                    }
                    if(isDraw(m)){
                        System.out.println();
                        System.out.println("Game Tied");
                    }
                    ch = ch=='X'?'O':'X';
                    
                }
            }
        }
        print(m);
        System.out.println("GameOver");
    }
    private static boolean isDraw(char[][] m) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(m[i][j]==' ')
                    return false;
            }
        }
        return true;
    }
    private static boolean checkWin(char [][] m,char ch,int i,int j) {
        int count1=0,count2=0;
        for(int k=0;k<3;k++){
            if(m[i][k]==ch )
                count1++;
            if(m[k][j]==ch)
                count2++;
        }
        if(count1==3 || count2==3)
            return true;
        count1=0;count2=0;
        for(int k=0;k<3;k++){
            if(m[k][k]==ch)
                count1++;
            if(m[k][3-k-1]==ch)
                count2++;
        }
        if(count1==3 || count2==3)
            return true;
        return false;
    }
}
