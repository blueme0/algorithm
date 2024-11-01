#include<iostream>
#include<vector>
#include <queue>
#include <algorithm>

#define _CRT_SECURE_NO_WARNINGS

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    int times[N + 1] = { };
    vector<int> arr[N + 1];
    queue<int> zeros;
    int cnt[N + 1] = { };
    int answer[N + 1] = { };

    int cur;
    for (int i = 1; i <= N; i++) {
        cin >> cur;
        times[i] = cur;

        cin >> cur;
        while (cur != -1) {
            arr[cur].push_back(i);
            cnt[i]++;
            
            cin >> cur;
        }

        if (cnt[i] == 0) zeros.push(i);
    }

    while (!zeros.empty()) {
        int zero = zeros.front(); zeros.pop();

        for (auto i : arr[zero]) {
            answer[i] = max(answer[i], answer[zero] + times[zero]);
            
            cnt[i]--;
            if (cnt[i] == 0) zeros.push(i);
        }
    }

    for (int i = 1; i <= N; i++) {
        cout << answer[i] + times[i] << "\n";
    }
    
   return 0;
}