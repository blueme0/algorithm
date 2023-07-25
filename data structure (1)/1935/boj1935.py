import sys
from collections import deque

N = int(input())
str = sys.stdin.readline().split()[0]
numbers = []
for _ in range(N):
    numbers.append(int(sys.stdin.readline().split()[0]))
queue = deque()

for a in str:
    if a == '+':
        queue.append(queue.pop() + queue.pop())
    elif a == '-':
        first = queue.pop()
        second = queue.pop()
        queue.append(second - first)
    elif a == '*':
        queue.append(queue.pop() * queue.pop())
    elif a == '/':
        first = queue.pop()
        second = queue.pop()
        queue.append(second / first)
    else:
        queue.append(numbers[ord(a) - ord('A')])
print("{:.2f}".format(queue[0]))