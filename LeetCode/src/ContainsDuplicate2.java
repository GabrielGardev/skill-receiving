import java.util.HashMap;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (map.containsKey(current) && i - map.get(current) <= k){
                return true;
            }else {
                map.put(current, i);
            }
        }
        return false;
    }
}
