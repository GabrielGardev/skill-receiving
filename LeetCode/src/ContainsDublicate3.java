import java.util.TreeSet;

public class ContainsDublicate3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1};
        int k = 1;
        int t = 2;
        System.out.println(containsNearbyDuplicate(nums, k, t));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i]);
            if (floor != null && nums[i] - floor <= t){
                return true;
            }

            Long ceiling = set.ceiling((long) nums[i]);
            if (ceiling != null && ceiling - nums[i] <= t){
                return true;
            }

            set.add((long) nums[i]);
            if (set.size() > k){
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
