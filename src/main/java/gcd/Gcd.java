package gcd;

/**
 * @author gongzhao
 * @description 
 * @Date 12:132018/9/11
 */
public class Gcd {

    /**
     *@author gongzhao
     *@param 
     *@return
     *@Date 16:47 2018/12/17
     */
    static int gcd(int m, int n) {
        int max = 0;
        int min = 0;
        if (m == n) {
            return m;
        } else if (m > n) {
            max = m;
            min = n;
        } else {
            max = n;
            min = m;
        }
        while (min != 0) {
            int residue = max % min;
            max = min;
            min = residue;
        }
        return max;
    }

//    /**
//     *@author gongzhao
//     *@param
//     *@return
//     *@Date 11:08 2018/12/19
//     */
//    public static void main(String[] ar) {
//        System.out.println(gcd(50, 15));
//        System.out.println(gcd(100, 70));
//    }

}
