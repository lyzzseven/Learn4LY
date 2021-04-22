package LeeCode;

import java.util.Arrays;

/**
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 *
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 */
public class Merge {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;
        int end = 0;
        while (i < m &&j < n){
            if (nums1[i] < nums2[j]){
                temp[end++] = nums1[i++];
            }else {
                temp[end++] = nums2[j++];
            }
        }
        for (;i < m;){
            temp[end++] = nums1[i++];
        }
        for (;j < n;){
            temp[end++] = nums2[j++];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] num1 = {2,0};
        int m = 1;
        int[] num2 = {1};
        int n = 1;
        System.out.println(Arrays.toString(merge(num1,m,num2,n)));
    }
}
