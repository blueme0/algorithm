import sys
from collections import deque

N = int(sys.stdin.readline())

card = deque(range(1, N + 1))

while N > 1:
    card.popleft()
    card.append(card.popleft())
    N -= 1

print(card[0])