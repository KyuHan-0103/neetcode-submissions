class Solution:
    def isValid(self, s: str) -> bool:
        para_list = []
        for char in s:
            if char == '(' or char == '[' or char == '{':
                para_list.append(char)
            elif char == ')':
                if not para_list or para_list.pop() != '(':
                    return False
            elif char == ']':
                if not para_list or para_list.pop() != '[':
                    return False
            else:
                if not para_list or para_list.pop() != '{':
                    return False
        return len(para_list) == 0