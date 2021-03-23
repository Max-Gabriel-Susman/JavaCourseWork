import java.util.Scanner;

public class Pyramid2 {
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");
        
        int numberOfLines = input.nextInt();

        // set column width
        int columnWidth = Integer.toString((int)Math.pow(2, numberOfLines - 1)).length() + 1;

        // iterate 'numberOfLines' times
        for(int lineNumber = 1; lineNumber <= numberOfLines; lineNumber ++)
        {
            Boolean firstColumn = true;

            // print left offset and columns from left to center
            for(int numberOfColumns = 0; numberOfColumns < lineNumber; numberOfColumns ++)
            {
                int fieldWidth = columnWidth;
                
                // check against first column value
                if(firstColumn)
                {
                    // reset field width for column
                    fieldWidth = ((numberOfLines - lineNumber) * columnWidth) + columnWidth;

                    firstColumn = false;
                }

                int columnValue = (int)Math.pow(2, numberOfColumns - 1);
                
                String format = String.format("%%%dd", fieldWidth);

                System.out.printf(format, (int)Math.pow(2, numberOfColumns));   
            }
            
            // print columns right of center
            for(int numberOfColumnsLeft = lineNumber - 2; numberOfColumnsLeft >= 0; numberOfColumnsLeft --)
            {
                String format = String.format("%%%dd", columnWidth);

                System.out.printf(format, (int)Math.pow(2, numberOfColumnsLeft));   
            }
            
            // carriage return
            System.out.println();
        }
    }
}
