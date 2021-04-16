/**
 * 解题思路: 最大堆 + 哈希表
 */
public class Solution {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            hashMap.merge(c, 1, Integer::sum);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> hashMap.get(o2) - hashMap.get(o1));
        queue.addAll(hashMap.keySet());
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            stringBuilder.append(String.valueOf(c).repeat(hashMap.get(c)));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
