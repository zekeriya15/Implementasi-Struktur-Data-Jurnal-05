import java.util.Scanner;

public class PostfixTester {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Masukkan operasi: ");
        String infix = s.nextLine();

        // PostfixEval infixToPostfix = new PostfixEval(infix);

        
        System.out.println("Hasil perubahan ke postfix: ");
        PostfixEval infixToPostfix = new PostfixEval(infix);


        
    }
}
