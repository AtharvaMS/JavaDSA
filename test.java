class test {
    public static void main(String[] args) {

        findPrimeNumber(282589933);
        
        System.out.println();

    }

    public static void printNumber(boolean req) {
        if (req == true) {
            System.out.println("Number is prime");
        } else {
            System.out.println("Number is composite");
        }
    }

    private static boolean findPrimeNumber(int number) {
        int i = 2;
        if (number < 0) {
            System.out.println("Number is not vaild for prime or not!");
        }
        if (number == 1 || number == 0) {
            System.out.println("Neighter prime nor composite");
        }
        while (i <= Math.sqrt(number)) {
            if (number % i == 0) {
                System.out.println("Factor found! : " + i);
                printNumber(false);
                return false;

            }
            i++;

        }
        printNumber(true);
        return true;

    }

}