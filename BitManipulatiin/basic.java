package BitManipulatiin;

public class basic {

    public static void main(String[] args) {
        System.out.println(evenOrODd(7585252851L));
        System.out.println(getIthBit(55,6));
        System.out.println(setIthBit(6,2));
        System.out.println(clearIthBit(6,1));
        System.out.println(clearILastBits(15,2));
        System.out.println(clearRingeOfBits(10, 2,4));
    }

    private static int clearRingeOfBits(int n, int i, int j) {
        int a = ((~0)<<(j+1));
        int b = (1<<i) -1;
        int mask = a|b;
        return (n & mask);
    }

    private static int clearILastBits(int n, int i) {
        
        return (n&((-1)<<i));
    }

    private static int clearIthBit(int n, int i) {
        return (n &(~(1<<i)));
    }

    private static String evenOrODd(long n) {
        long bitMask = 0001;
        if((n & bitMask) == 1){
            return "Number is odd !";

        }else{
            return "Number is Even";
        }

        
    }

    private static int getIthBit(int n, int i) {
        int bitMask = 1<<i;
        if((n & bitMask) == 0){
            return 0;
        }else{
            return 1;
        }

        
    }

    

    private static int setIthBit(int n, int i) {
        return (n|(1<<i));
    }
    
    
}
