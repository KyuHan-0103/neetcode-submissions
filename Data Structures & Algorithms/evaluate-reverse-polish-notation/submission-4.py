class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        num_stack = []
        for val in tokens:
            if val != '+' and val != '-' and val != '*' and val != '/':
                num_stack.append(int(val))
            elif val == '+':
                first = num_stack.pop()
                second = num_stack.pop()
                num_stack.append(second + first)
            elif val == '-':
                first = num_stack.pop()
                second = num_stack.pop()
                num_stack.append(second - first)
            elif val == '*':
                first = num_stack.pop()
                second = num_stack.pop()
                num_stack.append(second * first)
            else:
                first = num_stack.pop()
                second = num_stack.pop()
                num_stack.append(int(second / first))
        return num_stack[0]
