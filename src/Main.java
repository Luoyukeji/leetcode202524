public class Main {

    public static void main(String[] args) {

        Main sol = new Main();

        int  [] nums1 ={1,2,3,4};
        int  [] nums2 ={2,3,4,8,10};

        double medianSortedArrays = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        //保证nums1是较短的数组

        if(nums1.length> nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // 边界处理：如果 partitionX == 0，表示左侧没有元素，设为负无穷
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            // 边界处理：如果 partitionY == 0，表示左侧没有元素，设为负无穷
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // 满足条件，找到中位数
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // 奇数个元素，返回左侧最大的值
                if ((x + y) % 2 == 1) {
                    return Math.max(maxLeftX, maxLeftY);
                }
                // 偶数个元素，返回两个中间数的平均值
                return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
            }
            // 需要向左移动
            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            }
            // 需要向右移动
            else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("输入数组不满足条件");

    }
}