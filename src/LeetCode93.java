import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * https://leetcode.com/problems/restore-ip-addresses/
 * 思路没有问题，但是在写的时候要注意"010010"这种输入，中间的"0"的处理
 * 判断逻辑参见43、44行
 */
public class LeetCode93 {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) {
            return result;
        }
        getIpAdd(s, 0, 0, new ArrayList<>());
        return result;
    }

    private void getIpAdd(String s, int start, int ippos, List<Integer> list) {
        int len = s.length() - start, ipstep = 4 - ippos;
        if (len > ipstep * 3 || len < ipstep) {
            return;
        }
        if (ippos == 4 && start == s.length()) {
            StringBuilder builder = new StringBuilder();
            for (Integer i : list) {
                builder.append(i + ".");
            }
            result.add(builder.substring(0, builder.length() - 1));
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (start + i + 1 > s.length()) {
                break;
            }
            int ip = Integer.parseInt(s.substring(start, start + i + 1));
            if (ip >= 0 && ip <= 255) {
                list.add(ip);
                getIpAdd(s, start + i + 1, ippos + 1, list);
                list.remove(list.size() - 1);
                if (ip == 0) {
                    break;
                }
            } else {
                break;
            }
        }
    }
}
