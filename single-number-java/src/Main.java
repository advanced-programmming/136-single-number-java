
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] nums = getCases();
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) res ^= i;
        return res;
    }

    private static int singleNumber1(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        IntStream.of(nums).forEach(i -> {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        });

        return map.entrySet().stream().filter((v) -> v.getValue().equals(1)).findFirst().get().getKey();
    }

    private static int[] getCases() {
        return new int[] {4,1,2,1,2};
        //return new int[] {2,2,1};
    }
}