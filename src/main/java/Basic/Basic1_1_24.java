package Basic;

import sun.security.util.ECUtil;

public class Basic1_1_24 {
    public static int Euclid(int a,int b) {
        if(a < b) {
            return Euclid(b, a);
        }
        System.out.printf("a:%d,b:%d\n",a , b);
        if(a%b == 0) {
            return b;
        }
        return Euclid(b, a % b);
    }
    public static void main(String[] args) {
        System.out.println(Euclid(462,1071));
        System.out.println(Euclid(1111111,1234567));
    }

}
