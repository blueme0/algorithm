#include<iostream>
#include <algorithm>
#include <vector>
#include <queue>

#define _CRT_SECURE_NO_WARNINGS

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    int N, K;

    int cnt[1001];
    int answer[1001];
    int times[1001];

    

    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> N >> K;
        
        vector<int> arr[1001];
        queue<int> zeros;
        
        fill(answer, answer + N + 1, 0);
        fill(cnt, cnt + N + 1, 0);
        
        for (int n = 1; n <= N; n++) {
            cin >> times[n];
            answer[n] = times[n];
        }

        for (int k = 1; k <= K; k++) {
            int x, y; cin >> x >> y;

            cnt[y]++;
            arr[x].push_back(y);
        }

        int W; cin >> W;

        for (int n = 1; n <= N; n++) {
            if (cnt[n] == 0) zeros.push(n);
        }

        while (!zeros.empty()) {
            int cur = zeros.front(); zeros.pop();
            if (cur == W) break;

            for (auto i : arr[cur]) {
                answer[i] = max(answer[i], answer[cur] + times[i]);
                cnt[i]--;
                if (cnt[i] == 0) zeros.push(i);
            }
        }

        cout << answer[W]<< "\n";
    }
        
   return 0;
}