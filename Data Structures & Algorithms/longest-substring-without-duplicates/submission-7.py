class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #Brute force
        #Check every single possible substring with two loops
        #Once we find a duplicate we stop and max that length with our previous maxes
        #Two pointers:
        #Initialize an empty set, add right pointer's chracter. On every step take the max of our current length and our previous max
        #If we run into a duplicate, we remove l's character and increment l
        seen = set()
        l = r = 0
        max_len = 0
        while r < len(s):
            if s[r] not in seen:
                seen.add(s[r])
                max_len = max(max_len, r - l + 1)
                r += 1
            else:
                while s[r] in seen:
                    seen.remove(s[l])
                    l += 1
                seen.add(s[r])
                max_len = max(max_len, r - l)
                r += 1
        return max_len