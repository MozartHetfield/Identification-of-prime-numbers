import java.math.BigInteger;

public class MillerRabinPrimality {
	  public static void main(String[] args) {
		System.out.println("Miller-Rabin test:");
		System.out.println("");
		BigInteger p = new BigInteger(args[0]);
	    int k = Integer.parseInt(args[1]);
		System.out.println("Number: " + p);
		System.out.println("Number of iterations: " + k);
	    long start = System.nanoTime();
	    System.out.println("Output: " + (p.isProbablePrime(k) ? "probably prime" : "composite"));
        float time = System.nanoTime() - start;
	    System.out.println("Time: " + (long) time + " nanoseconds");
	    time = (float) (time / Math.pow(10, 9));
	    System.out.println("Time: " + time + " seconds");
	  }
	}