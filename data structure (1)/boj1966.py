import sys
from collections import deque

K = int(sys.stdin.readline())

for _ in range(K):
    N, M = map(int, sys.stdin.readline().split())

    priority = 1

    queue = deque(list(map(int, sys.stdin.readline().split())))
    queue_index = deque(i for i in range(0, len(queue)))

    while True:
        if queue[0] == max(queue):
            if queue_index[0] == M:
                print(priority)
                break
            else:
                priority += 1
                queue.popleft()
                queue_index.popleft()
        else:
            queue.rotate(-1)
            queue_index.rotate(-1)
