class Solution:
    def maxValue(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [0]*n
        stack = []

        for i,v in enumerate(nums):
            curr_max, left, right = v, i , i
            while stack and stack[-1][0] > v:
                top_max, top_left, _ = stack.pop()
                curr_max = max(curr_max, top_max)
                left = top_left
            stack.append([curr_max, left, i])
        
        for comp_max, left, right in stack:
            for i in range(left, right + 1):
                ans[i] = comp_max
        
        return ans