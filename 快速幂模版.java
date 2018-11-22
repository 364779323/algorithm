import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            long  a=input.nextLong();
            long b=input.nextLong();
            long mod=input.nextLong();
            long ans=1;
            long ya=a;
            long yb=b;
            while(b>0){
                if((b&1)==1)//判断是否为奇数
                    ans=(ans*a)%mod;
                b>>=1;//b/2
                a=(a*a)%mod;
            }
            System.out.println(ya+"^"+yb+" mod "+mod+"="+(ans%mod));
        }
    }

}
