import sys
num = int(sys.stdin.readline())
stack = []
for _ in range(num):
    inst = sys.stdin.readline().split()
    if inst[0] == 'push':
        stack.append(inst[1])
    elif inst[0] == 'pop':
        print(stack.pop() if len(stack) != 0 else -1)
    elif inst[0] == 'top':
        print(stack[-1] if len(stack) != 0 else -1)
    elif inst[0] == 'empty':
        print('1' if len(stack) == 0 else '0')
    elif inst[0] == 'size':
        print(len(stack))
