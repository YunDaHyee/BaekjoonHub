import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Main{
	static List<int[]>[] adjList = null;	// 하나의 정점에 대해 연결된 정점과 가중치를 저장
	static int[] shortestPaths = null;		// 시작점과 다른 정점 i 간의 최단경로
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] raws = br.readLine().split(" ");
		int	V = Integer.parseInt(raws[0]),				// 정점 개수
			E = Integer.parseInt(raws[1]),				// 간선 개수
			start = Integer.parseInt(br.readLine());	// 시작 정점
		
		shortestPaths = new int[V+1];
		adjList = new ArrayList[V+1];
		
		// 인접리스트 초기화
		for( int i=1;i<=V;i++ ){
			adjList[i] = new ArrayList<>();
			shortestPaths[i] = Integer.MAX_VALUE;		// 최소값 찾을거니까 최대값으로 설정
		}
		
		// 그래프 값 초기화
		for( int i=1;i<=E;i++ ){
			raws = br.readLine().split(" ");
			int u = Integer.parseInt(raws[0]),
				v = Integer.parseInt(raws[1]),
				w = Integer.parseInt(raws[2]);
			adjList[u].add(new int[] {v, w});
			// 방향그래프라서 단방향임
		}
		
		DIJKSTRA( start );
		
		for( int i=1;i<shortestPaths.length;i++ ){
			int shortestPath = shortestPaths[i];
			if( shortestPath==Integer.MAX_VALUE ){ // 바뀌지 않은 것은 경로가 없다는 것
				System.out.println("INF");
				continue;
			}
			System.out.println( shortestPath );
		}
	}
	
	private static void DIJKSTRA( int start ) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		shortestPaths[start] = 0;			// 시작점에 대해 최단거리 초기화
		queue.offer( new Node(start,0) );	// 시작점과 가중치. 시작점에 대한 가중치는 0이다.
		while( !queue.isEmpty() ){
			Node current = queue.poll();	// 연결 노드
			int currentV = current.vertex,	// 연결된 노드의 현재 정점
				currentW = current.weight;	// 연결된 노드의 현재 가중치
			
			if( shortestPaths[currentV] < currentW ) { // 현재 가중치가 더 크면 넘김
				continue;
			}
			
			for( int[] connected : adjList[currentV] ){ // 갈 수 있는 길이 여러개일 때 더 작은 길을 선택해야함
				int connectedV = connected[0],
					connectedW = connected[1] + currentW;	   // 현재 가중치를 더해줌
				if( shortestPaths[connectedV] > connectedW ){  // 연결되어있는 가중치가 더 최단경로이면 갱신함
					shortestPaths[connectedV] = connectedW;
					queue.offer( new Node(connectedV, connectedW) );
				}
			}
		}
	}

	// 우선순위 큐에 넣으려면 Comparable 클래스 구현체여야함.
    private static class Node implements Comparable<Node> { //우선순위큐로 성능개선(안하면 시간초과뜸)
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}