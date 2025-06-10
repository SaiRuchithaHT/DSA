class Solution {
    class Pair{
        int position;
        int speed;
        double time;
        Pair(int position, int speed, double time){
            this.position = position;
            this.speed = speed;
            this.time = time;
        }
    } 
    public int carFleet(int target, int[] position, int[] speed) {
        // 10 8 5 3 0
        // 1  1 7 3 12

        // 4 2 0
        // 96 49 25 

        // 10   8   5  3   0
        // 0.5 0.75 6 2.67 11

        Stack<Double> stack = new Stack<>();
        List<Pair> pairs = new ArrayList<>();
        for(int i=0; i<position.length; i++){
            pairs.add(new Pair(position[i], speed[i], (target-position[i])/(double)speed[i]));
        }
        pairs.sort((a, b) -> (b.position-a.position));
        for(Pair p : pairs){
            // System.out.println(p.time);
            if(stack.isEmpty() || p.time > stack.peek())
                stack.push(p.time);
        }
        return stack.size();
    }
}