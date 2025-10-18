class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        set1.retainAll(Arrays.stream(nums2).boxed().collect(Collectors.toSet()));
        return set1.stream().mapToInt(i -> i).toArray();
    }
}