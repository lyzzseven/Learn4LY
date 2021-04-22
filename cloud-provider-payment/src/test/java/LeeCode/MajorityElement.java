package LeeCode;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 */
public class MajorityElement {
    public static int majorityElement(int[] nums){
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0){
                major = nums[i];
                count ++;
            }else if (major == nums[i]){
                count ++;
            }else {
                count --;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int nums[] = {2,2,3,3,2,2,2,2,4,4,5};
        System.out.println(majorityElement(nums));
    }
}
