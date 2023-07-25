import sys

N, K = map(int, sys.stdin.readline().split())

table = list(range(1, N + 1))
result = []
pos = 0

while N > 0:
    pos += K - 1
    pos %= N

    result.append(table.pop(pos))
    N -= 1

print('<' + ', '.join(str(i) for i in result) + '>')
