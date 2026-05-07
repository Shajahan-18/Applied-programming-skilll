/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0, 0});

        while(!q.isEmpty()) {

            Object[] arr = q.poll();

            TreeNode node = (TreeNode)arr[0];
            int x = (int)arr[1];
            int y = (int)arr[2];

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            if(node.left != null)
                q.offer(new Object[]{node.left, x - 1, y + 1});

            if(node.right != null)
                q.offer(new Object[]{node.right, x + 1, y + 1});
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {

            List<Integer> list = new ArrayList<>();

            for(PriorityQueue<Integer> pq : ys.values()) {
                while(!pq.isEmpty())
                    list.add(pq.poll());
            }

            ans.add(list);
        }

        return ans;
    }
}