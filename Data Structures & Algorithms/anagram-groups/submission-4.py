class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_dict = {}
        for string in strs:
            arr = [0] * 26
            for char in string:
                arr[ord(char) - ord('a')] += 1
            tuple_arr = tuple(arr)
            if tuple_arr in anagram_dict:
                anagram_dict[tuple_arr].append(string)
            else:
                anagram_dict[tuple_arr] = [string]
        res = []
        for _, value in anagram_dict.items():
            res.append(value)
        return res 