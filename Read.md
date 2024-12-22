custom comparators - greedy 
valid paranthesis ((*))) - greedy/easy



arrays.sort()
collections.sort() for arraylist etc
list = Arrays.asList(val1, val2, val3); 


Direct way:
HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet :: new));


find . -type f | wc -l      ---- total number of files
ls | wc -l                       folders i think



weird Problems:
- two-pointers/ medium / 05  ~~~ strings/medium/ 05

- cnt of subArr with sum k
- cnt of subStr with K unique chars


_Arrays_

-> return Arrays.stream(prev).min().getAsInt(); ---- to find min value and return as int.