import java.util.Random;
import java.math.BigInteger;

public class FermatPrimality {

    private final static Random rand = new Random();

    private static BigInteger generateBase(BigInteger p)
    {
        while (true)
        {
            final BigInteger a = new BigInteger (p.bitLength(), rand);
            
            if (BigInteger.ONE.compareTo(a) < 0 && a.compareTo(p) < 0)
            {
                return a; // 1 < a < p
            }
        }
    }

    public static String checkPrimality(BigInteger p, int numberOfIterations)
    {
        if (p.equals(BigInteger.ONE)) //p = 1
            return "is composite";
        if (p.equals(new BigInteger("2"))) //p = 2
        	return "is composite";

        for (int i = 0; i < numberOfIterations; i++)
        {
            BigInteger a = generateBase(p);
            a = a.modPow(p.subtract(BigInteger.ONE), p); //a = a^(p-1) mod p

            if (!a.equals(BigInteger.ONE))
                return "is composite";
        }
        return "is probably prime";
    }

    public static void main(String[] args)
    {
	    System.out.println("Fermat test:");
	    System.out.println("");
	    BigInteger p = new BigInteger(args[0]);
    	String numberOfIterations = new String(args[1]);
    	int k = Integer.valueOf(numberOfIterations);
	    System.out.println("Number: " + p);
	    System.out.println("Number of iterations: " + k);
    	long start = System.nanoTime();
        System.out.println("Output: " + checkPrimality(p , k));
        float time = System.nanoTime() - start;
	    System.out.println("Time: " + (long) time + " nanoseconds");
	    time = (float) (time / Math.pow(10, 9));
	    System.out.println("Time: " + time + " seconds");
    }
}