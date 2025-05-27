class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        div = []
        nondiv = []
        for i in range(1,n+1):
            if i % m == 0:
                div.append(i)
            else:
                nondiv.append(i)
        
        return sum(nondiv) - sum(div)