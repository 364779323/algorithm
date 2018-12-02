import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String x = input.next();
        int i;
        //找到 x[i] < x[i+1] 的位置
        for(i=x.length()-2;i>=-1;i--){
            if(i==-1)break;
            if(x.charAt(i)<x.charAt(i+1)){
                break;
            }
        }

        //当没有找到 x[i] < x[i+1]位置的时候
        //因为可能是0位置小于 1 位置，所以 用-1 代表找不到
        if(i==-1){
            System.out.println(x);
        }else{
            //反转 x[i+1] ~ len
            StringBuffer s2 = new StringBuffer(x.substring(i+1));
            s2 = s2.reverse();

            //插入 第二个位置 x[i];
            s2.insert(1,x.charAt(i));

            //合并 s1 s2
            s2.insert(0,x.substring(0,i));

            System.out.println(s2);
        }

    }
}
