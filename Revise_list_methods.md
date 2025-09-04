### Convert ArrayList to Array

`list.toArray(new Integer[0])`:
```java
ArrayList<Integer> list = new ArrayList<>();
int[] arr = list.toArray(new int[list.size()]);
int[] arr = list.toArray(int[]::new); 
```
___________________________________________________________________________
### Convert Array to ArrayList

`Arrays.asList()`:
```java
int[] arr = {1, 2, 3};
List<Integer> list = Arrays.asList(arr);
ArrayList<Integer> arrayList = new ArrayList<>(list);
```
## Or
```java
int[] arr = {1, 2, 3};
ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
```
______________________________________________________________________________