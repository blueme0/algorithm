import sys
from collections import deque

N = int(input())
queue = deque(list(map(int, sys.stdin.readline().split())))
queue_index = deque(i for i in range(1, len(queue) + 1))
order = []

while N > 0:
    balloon = queue.popleft()
    order.append(queue_index.popleft())
    if balloon > 0:
        balloon = (balloon - 1) * (-1)
    else:
        balloon *= -1
    queue.rotate(balloon)
    queue_index.rotate(balloon)
    N -= 1

print(' '.join(str(i) for i in order))