package LeeCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 *
 * 已知存在楼层 f ，满足0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 *
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 */
public class SuperEggDrop {
    Map<Integer,Integer> map = new HashMap<>();
    public int superEggDrop(int k, int n) {
        if(map.containsKey(n*100+k))
            return map.get(n*100+k);
        int ans = 0;
        if(n == 0)
            ans = 0;
        else if (k == 1)
            ans = n;
        else {
            int l = 1, r = n;
            while (l + 1 < r){
                int mid = (l + r)/2;
                int t1 = superEggDrop(k - 1,mid - 1);
                int t2 = superEggDrop(k,n - mid);
                if (t1 < t2)
                    l = mid;
                else if (t1 > t2)
                    r = mid;
                else {
                    l = r = mid;
                }
                ans = 1 + Math.min(Math.max(superEggDrop(k-1,l-1),superEggDrop(k,n-l)),Math.max(superEggDrop(k-1,r-1),superEggDrop(k,n-r)));
            }
            map.put(n*100+k,ans);
        }
        return ans;
    }


    public static void main(String[] args) {
        int superEggDrop = new SuperEggDrop().superEggDrop(3, 14);
        System.out.println(superEggDrop);
    }
}
