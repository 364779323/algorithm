import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
    static int maxn;
    public static void main(String[] args) {
        InputReader input = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int n=input.nextInt();
        int r=input.nextInt();
        int q=input.nextInt();
        maxn=2*n+1;
        xuanshou[] arr=new xuanshou[maxn];
        for(int i=1;i<maxn;i++){
            arr[i]=new xuanshou();
            arr[i].no=i;
            arr[i].fenshu=input.nextInt();
        }
        for(int i=1;i<maxn;i++)
            arr[i].shili=input.nextInt();
//        for(int i=1;i<maxn;i++)
//            System.out.println(arr[i].no+" "+arr[i].fenshu+" "+arr[i].shili);
        mergesort(arr,1,maxn-1);
        for(int i=1;i<maxn;i++)
            System.out.println(arr[i].no+" "+arr[i].fenshu+" "+arr[i].shili);

        out.close();
    }

    public static void mergesort(xuanshou[] arr,int left,int right){
        if(left==right) return;
        else{
            int mid=(left+right)>>1;
            mergesort(arr,left,mid);
            mergesort(arr,mid+1,right);
        }
    }
    public static void merge(xuanshou[] arr,int left , int mid,int right){
        xuanshou[] temp=new xuanshou[right-left+1];
        for(int i=0;i<temp.length;i++)
            temp[i]=new xuanshou();
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=right){
            if(arr[i].shili>arr[j].shili) temp[k++]=arr[i++];
//            if(arr[i].shili==arr[j].shili){
//                if(arr[i].no<arr[j].no) temp[k++]=arr[i++];
//                else
//                    temp[k++]=arr[j++];
//            }
            else
                temp[k++]=arr[j++];
        }

        while(i<=mid) temp[k++]=arr[i++];
        while(j<=right) temp[k++]=arr[j++];
        
        for(int x=0;x<temp.length;x++)
            arr[x+left]=temp[x];


        temp=null;
    }


}
class xuanshou{
    int no;
    int fenshu;
    int shili;
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
