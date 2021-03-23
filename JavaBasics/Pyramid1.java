import java.util.Scanner;

class Pyramid1 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");
        
        int numberOfLines = input.nextInt();

        // set column width
        int columnWidth = Integer.toString(numberOfLines).length() + 1;

        // iterate 'numberOfLines' times
        for(int lineNumber = 1; lineNumber <= numberOfLines; lineNumber ++)
        {
            Boolean firstColumn = true;

            // print left offset and columns from left to center
            for(int numberOfColumns = lineNumber; numberOfColumns > 0; numberOfColumns --)
            {
                int fieldWidth = columnWidth;
                
                // check against first column value
                if(firstColumn)
                {
                    // reset field width for column
                    fieldWidth = ((numberOfLines - numberOfColumns) * columnWidth) + columnWidth;

                    firstColumn = false;
                }
                
                String format = String.format("%%%dd", fieldWidth);

                System.out.printf(format, numberOfColumns);   
            }

            // print columns right of center
            for(int numberOfColumnsLeft = 2; numberOfColumnsLeft <= lineNumber; numberOfColumnsLeft ++)
            {
                String format = String.format("%%%dd", columnWidth);

                System.out.printf(format, numberOfColumnsLeft);   
            }
            
            // carriage return
            System.out.println();
        }
    }
}