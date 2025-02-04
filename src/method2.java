import java.util.Arrays;

// 两个正序数组合并再求中位数

class method2 {

    public static void main(String[] args) {
        method2 method2 = new method2();
        int arr1 [] = { 1,4};
        int arr2 [] = {5,6};
        double medianSortedArrays = method2.findMedianSortedArrays(arr2, arr1);
        System.out.println(medianSortedArrays);

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并两个数组
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length); // 把 nums1 复制到 merged
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length); // 把 nums2 复制到 merged

        // 排序合并后的数组
        Arrays.sort(merged);

        // 获取中位数
        int length = merged.length;
        if (length % 2 == 1) {
            // 如果长度是奇数，直接返回中间的元素
            return merged[length / 2];
        } else {
            // 如果长度是偶数，返回中间两个元素的平均值
            return (merged[length / 2 - 1] + merged[length / 2]) / 2.0;
        }
    }
}
