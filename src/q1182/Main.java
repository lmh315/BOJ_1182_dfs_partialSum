package q1182;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int T, S, result = 0;
	static int[] input;
	static int[] index;

	public static void dfs(int v, int cur_cnt, int cnt) {
		int i, sum = 0;

		if (cur_cnt == cnt) {
			for(i=0;i<cnt;i++) {
				sum += input[index[i]];
			}
			if (sum == S) result++;
			return;
		}

		for (i = v; i < T; i++) {
			index[cur_cnt] = i;
			cur_cnt++;
			dfs(i + 1, cur_cnt, cnt);
			cur_cnt--;
		}

	}

	public static void main(String[] args) throws IOException {
		int i;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());

		T = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		index = new int[T];
		input = new int[T];
		
		st = new StringTokenizer(in.readLine());
		
		for(i=0;i<T;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		for (i = 1; i <= T; i++) {
			dfs(0, 0, i);
		}

		out.write(String.valueOf(result));
		out.flush();

		in.close();
		out.close();
	}
}
