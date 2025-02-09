package _concepts.hashing_and_counting;

public class count_bad_pairs {

    public long countBadPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mapi = new HashMap<>(); // count of `i - nums[i]`

        for (int i=0; i<n; i++) {
            int xi = i - nums[i];
            mapi.put(xi, mapi.getOrDefault(xi,0)+1);
        }
        long goodPairs = 0;
        for (int cnt: mapi.values()) {
            goodPairs += (long)cnt*(cnt-1) / 2; // nCp -> [cnt]C[2]
        }
        long totalPairs = (long)n*(n-1) / 2; // nCp -> [n]C[2]
        
        return totalPairs - goodPairs;
    }
}