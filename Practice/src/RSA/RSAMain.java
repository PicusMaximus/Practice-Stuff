package RSA;

import java.math.BigDecimal;
import java.math.BigInteger;
import usefullstuff.UserInput;


public class RSAMain {

    public static void main(String args[])
    {
        int primeOne, primeTwo, n, z, d = 0, e, i;

        UserInput input = new UserInput();

        int msg = input.read("enter your message: ");
        double c;
        BigInteger msgback;


        primeOne = input.read("coose your first prime: ");
        primeTwo = input.read("coose your second prime: ");

        n = primeOne * primeTwo;
        z = (primeOne - 1) * (primeTwo - 1);
        System.out.println("the value of z = " + z);

        for (e = 2; e < z; e++) {

            // e is for public key exponent
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("the value of e = " + e);
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);

            // d is for private key exponent
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("the value of d = " + d);
        c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is : " + c);

        // converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);

        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : "
                + msgback);
    }

    static int gcd(int e, int z)
    {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
}
