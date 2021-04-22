package LeeCode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumber {
    public static int singleNum(int[] nums){
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num^nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,2,3,2};
        System.out.println(singleNum(nums));
    }
}
