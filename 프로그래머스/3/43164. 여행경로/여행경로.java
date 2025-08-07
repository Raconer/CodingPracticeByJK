
import java.util.*;

class Solution {
     boolean[] visited;
    int ticketLen = 0;

    public void findPath(ArrayDeque<String> stack, String[][] tickets, String start){
        if(stack.size() == ticketLen + 1){
            return;
        }

        for(int i = 0; i < ticketLen; i++){
            if(!this.visited[i] && tickets[i][0].equals(start)){
                start = tickets[i][1];
                visited[i] = true;
                stack.add(start);
                this.findPath(stack, tickets, start);
                if(stack.size() < ticketLen + 1){
                    this.visited[i] = false;
                    start = tickets[i][0];
                    stack.pollLast();
                }
            }

        }


    }

    public String[] solution(String[][] tickets) {
        // 정렬
        ticketLen = tickets.length;

        Arrays.sort(tickets, (next, cur) -> {
            if(cur[0].equals(next[0])) {
                return next[1].compareTo(cur[1]);
            }

            return next[0].compareTo(cur[0]);
        });

        visited  = new boolean[ticketLen];
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.add("ICN");
        this.findPath(stack, tickets, "ICN");

        return stack.toArray(String[]::new);
    }

}