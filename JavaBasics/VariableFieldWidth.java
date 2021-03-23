import java.util.Scanner;

public class VariableFieldWidth 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a field width: ");
        int fieldWidth = input.nextInt();
        
        //String format = String.format("%%%dd", fieldWidth);
        String format = String.format("%%%dd, %%%dd, %%%dd, %%%dd", fieldWidth, fieldWidth, fieldWidth, fieldWidth);
        //System.out.println(format);
        System.out.printf(format, 1, 2, 8, 123);
    }
}
