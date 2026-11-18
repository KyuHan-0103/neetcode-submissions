class RandomizedSet:

    def __init__(self):
        self._dict = {}
        self._nums = []

    def insert(self, val: int) -> bool:
        if val in self._dict:
            return False
        self._dict[val] = len(self._nums)
        self._nums.append(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self._dict:
            return False
        index = self._dict[val]
        last_val = self._nums[-1]
        self._nums[index] = last_val
        self._dict[last_val] = index
        self._nums.pop()
        del self._dict[val]
        return True

    def getRandom(self) -> int:
        return random.choice(self._nums)


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()