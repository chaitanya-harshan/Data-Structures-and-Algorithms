package Tree.traversals;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class treeSet {

    class NumberContainers {
        Map<Integer,Integer> idx_map = new HashMap<>();
        Map<Integer, TreeSet<Integer>> num_map = new HashMap<>();

        public NumberContainers() {}
        
        public void change(int index, int number) {
            if (idx_map.containsKey(index)) {
                int prevNum = idx_map.get(index);
                TreeSet<Integer> set = num_map.get(prevNum);
                set.remove(index);
                if (set.isEmpty()) num_map.remove(prevNum);
            }

            idx_map.put(index, number);
            // if (num_map.containsKey(number)) {
            //     num_map.get(number).add(index);
            // }
            // else {
            //     TreeSet<Integer> temp = new TreeSet<>();
            //     temp.add(index);
            //     num_map.put(number, temp);
            // }
            num_map.computeIfAbsent(number, _ -> new TreeSet<>()).add(index);
        }
        
        public int find(int number) {
            return num_map.containsKey(number) ? num_map.get(number).first() : -1;
        }
    }

    /**
     * Your NumberContainers object will be instantiated and called as such:
     * NumberContainers obj = new NumberContainers();
     * obj.change(index,number);
     * int param_2 = obj.find(number);
     */
}