import sys
num = int(sys.stdin.readline())
for _ in range(num):
    str = list(sys.stdin.readline())
    correct = 0
    for i in str:
        if i == '(':
            correct += 1
        elif i == ')':
            correct -= 1
        if correct < 0:
            print('NO')
            break
    if correct == 0:
        print('YES')
    elif correct > 0:
        print('NO')
        
