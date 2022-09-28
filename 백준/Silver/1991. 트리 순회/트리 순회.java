import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class NODE {
	public String left;
	public String right;
}

class Main {
    static NODE[] nodes;// NODE 클래스를 담을 리스트
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		
		nodes = new NODE[N]; // 초기화
		
		// 트리 저장 - NODE 객체에 값 넣기
		for( int i=0;i<N;i++ ){
			String[] info = br.readLine().split(" ");
			NODE temp = new NODE();
			temp.left = info[1];
			temp.right = info[2]; 
			nodes[info[0].charAt(0)-'A'] = temp;
		}
		
		// 트리 순회
		DFS("A", "PRE");
		System.out.println();
		DFS("A", "IN");
		System.out.println();
		DFS("A", "POST");
        
        br.close();
	}
    
    private static void DFS(String currentNode, String order) {
		if( currentNode.equals(".") ){
			return;
		}
		
        NODE pair = nodes[currentNode.charAt(0)-'A']; // 현재 노드의 왼,오 쌍
		
		switch (order) {
			case "PRE":
				System.out.print(currentNode);
				DFS(pair.left, "PRE");
				DFS(pair.right, "PRE");
				break;
			case "IN":
				DFS(pair.left, "IN");
				System.out.print(currentNode);
				DFS(pair.right, "IN");
				break;
			case "POST":
				DFS(pair.left, "POST");
				DFS(pair.right, "POST");
				System.out.print(currentNode);
				break;
		}
	}
}