/**
 * 解题思路: 花费使用小根堆, 利润使用大根堆, 然后每次将小根堆中花费小于资金W的项目加入到利润大根堆中, 然后资金加上利润大根堆堆顶的元素
 */
public class Solution {
    static class Node {
        int cost;
        int profit;

        public Node(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
				// 开销小根堆
        PriorityQueue<Node> minCostQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
				// 利润大根堆
        PriorityQueue<Node> maxProfitQueue = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);
        for (int i = 0; i < Profits.length; i++) {
            minCostQueue.add(new Node(Capital[i], Profits[i]));
        }
        for(int i = 0; i < k; i++) {
						// 将开销小于本金的都添加到利润大根堆
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost <= W) {
                maxProfitQueue.add(minCostQueue.poll());
            }
						// 如果利润大根堆为空, 也就是本金不足, 直接返回
            if (maxProfitQueue.isEmpty()) return W;

						// 本金加上利润大根堆中堆顶元素
            W += maxProfitQueue.poll().profit;
        }
        return W;
    }
}
 
