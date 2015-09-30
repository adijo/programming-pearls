class Solution:
    # @param A : list of list of integers
    # @return the same list modified

    def is_valid(self, A, i, j):
        return 0 <= i < len(A) and 0 <= j < len(A[0])
    
    def transpose_helper(self, A, i, j):
        while self.is_valid(A, i, j):
            A[i][j], A[j][i] = A[j][i], A[i][j]
            i += 1
    
    def transpose(self, A):
        i = 0
        j = 0
        while self.is_valid(A, i, j):
            self.transpose_helper(A, i, j)
            i += 1
            j += 1
    def rotate(self, A):
        self.transpose(A)
        return map(lambda x : x[::-1], A)
        
s = Solution()
A = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print s.rotate(A)