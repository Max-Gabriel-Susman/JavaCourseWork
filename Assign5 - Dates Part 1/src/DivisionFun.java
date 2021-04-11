public class DivisionFun {
    public static void main(String[] args) {
        try {
            System.out.println("unborked");
            int valueOne = 123;  // 1
            int valueTwo = 0;    // 2
            int result = divideNumbers(valueOne, valueTwo);  // 3
            System.out.println("it borks after exception");
            System.out.println("Result: " + result);         // 4
        }
        catch (ArithmeticException e) {
            System.out.println("Attempted divide by 0 - shame!");  // 5
        }

        System.out.println("Leaving main...");  // 6
    }

    public static int divideNumbers(int first, int second) {
        return first / second;
    }
}