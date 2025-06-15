
import java.util.Arrays;
import java.util.Stack;

class Solution {
    boolean[] visited;

    public void route(int count, Stack<String> route, String[][] tickets, int len, String from) {

        if (count == len) {
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!this.visited[i] && tickets[i][0].equals(from)) {
                from = tickets[i][1];
                this.visited[i] = true;
                route.add(from);
                this.route(count + 1, route, tickets, len, from);
                if (route.size() < len) {
                    this.visited[i] = false;
                    from = tickets[i][0];
                    route.pop();
                }
            }
        }
    }

    public String[] solution(String[][] tickets) {
        Stack<String> route = new Stack<>();
        String from = "ICN";
        int len = tickets.length;
        visited = new boolean[len];

        route.add(from);
        Arrays.sort(tickets, (next, cur) -> {
            if (cur[0].equals(next[0])) {
                return next[1].compareTo(cur[1]);
            }
            return next[0].compareTo(cur[0]);
        });
        route(0, route, tickets, len, from);

        return route.toArray(String[]::new);
    }
}