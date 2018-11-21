import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

class test {
    static int[] arr=new int[200005];
    public static void main(String[] args) {
        InputReader input = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
            int n=input.nextInt();
            int m=input.nextInt();
            for(int i=1;i<n+1;i++)
                arr[i]=i;
            while(m-->0){
                int act=input.nextInt();
                int a=input.nextInt();
                int b=input.nextInt();
                if(act==2){
                    if(find(a)==find(b)) out.println("Y");
                    else out.println("N");
                }
                else if(act==1){
                    arr[find(a)]=find(b);
                }

            }



        out.close();
    }
    static int  find(int k){
        if(arr[k]==k) return k;
        else return arr[k]=find(arr[k]);
    }


}

class InputReader {
    BufferedReader buf;
    StringTokenizer tok;

    InputReader() {
        buf = new BufferedReader(new InputStreamReader(System.in));
    }

    boolean hasNext() {
        while (tok == null || !tok.hasMoreElements()) {
            try {
                tok = new StringTokenizer(buf.readLine());
            } catch (Exception e) {
                return false;
            }

        }
        return true;
    }

    String next() {
        if (hasNext())
            return tok.nextToken();
        return null;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    BigDecimal nextBigDecimal() {
        return new BigDecimal(next());
    }
}


