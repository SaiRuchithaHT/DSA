class Solution {
    class Pair {
        char c;
        int count;
        int itr;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
            this.itr = 0;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[26];
        int itr = 1;

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> {
            if (b.count == a.count)
                return a.itr - b.itr;
            else
                return b.count - a.count;
        });

        for (char c : tasks) {
            chars[c - 'A']++;
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (chars[c - 'A'] > 0)
                queue.offer(new Pair(c, chars[c - 'A']));
        }

        Arrays.fill(chars, 0);
        Queue<Pair> waitQueue = new LinkedList<>();

        while (!queue.isEmpty() || !waitQueue.isEmpty()) {
            if (!waitQueue.isEmpty() && (itr - waitQueue.peek().itr - 1) >= n) {
                queue.offer(waitQueue.poll());
            }

            if (!queue.isEmpty()) {
                Pair p = queue.poll();
                System.out.println(p.c + " " + itr + " itr");
                p.count--;
                p.itr = itr++;
                if (p.count > 0) {
                    waitQueue.offer(p);
                }
            } else {
                System.out.println("idle " + itr);
                itr++;
            }
        }

        return itr - 1;
    }
}
