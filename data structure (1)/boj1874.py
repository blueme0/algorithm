import sys
from collections import deque

N = int(input())
arr = list(i for i in range(1, N + 1))
stack = deque()
list = []

index = 0
try:
    for _ in range(N):
        num = int(sys.stdin.readline().split()[0])
        while index < N and arr[index] <= num:
            stack.append(arr[index])
            index += 1
            list.append('+')
        if stack and stack[-1] == num:
            stack.pop()
            list.append('-')
        else:
            raise IndexError
except IndexError:
    print('NO')
else:
    for i in range(len(list)):
        print(list[i])
