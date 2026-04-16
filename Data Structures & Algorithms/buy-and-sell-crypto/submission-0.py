class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        hold_price = 2**31-1
        res = 0

        for price in prices:
            if price > hold_price:
                res = max(res, price-hold_price)
            
            hold_price = min(hold_price, price)

        return res
            
        