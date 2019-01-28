/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 * 开始时间总是超过，技巧是在32行计算result的时候，不用pow(x, abs / 2)*pow(x, abs / 2)，而是计算出来存在变量里，可以省一半时间
 * todo 技巧是32和33行, 同时注意Integer.MinValue转正时的溢出，所以都减了1
 * 虽然过了，但是效率不高，还有些计算技巧 48行n<0可以倒转x，n为奇数，可以改变result的初始赋值，这样更优雅
 */
public class LeetCode50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        if (x == 1) {
            return 1;
        }
        if (n > 0) {
            return pow(x, n - 1) * x;
        } else {
            return 1 / (pow(x, -(n + 1)) * x);
        }

    }

    public double pow(double x, int abs) {
        if (abs == 0) {
            return 1;
        } else if (abs == 1) {
            return x;
        }
        double result = pow(x, abs / 2);
        result = result * result;
        if (abs % 2 == 0) {
            return result;
        } else {
            return result * x;
        }
    }
}

/*class Solution {
    public double myPow(double x, int N) {
        if (N == 0) return 1.0;
        if (N == 1) return x;
        Long n = (long) N;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double curProd = x;
        double result = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= curProd;
            }
            curProd *= curProd;
            n /= 2;

        }
        return result;

    }
}*/
