package edu.basic.preparation.dynamic;

public class DynamicProblem {

    // 1) 0/1 knapsack problem wt= 7, wts = 1(1), 3(4), 4(5), 5(7)
    // 2) longest common sub sequence in two strings s1 = abcdaf, s2= acbcf
    // 3) longest common substring in two strings, s1= abcdaf, s2=zbcdf
    // 4) subset sum problem, is there subset in array which forms given sum, sum= 11 nos={2,3,7,8,10}
    // https://www.youtube.com/watch?v=s6FhG--P7z0&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=4
    // 5) can we form sum from given coins
    //    you can use subset sum problem logic where you can select a coin just once.
    // 6) given set of coin find minimum number of coins required to form sum problem(5)
    //    you can select coins n number of times total= 11, coins=1,5,6,8
    // https://www.youtube.com/watch?v=Y0ZqKpToTic&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=5
    // 7) longest increasing sub sequence  {3,4,-1,0,6,2,3}
    // 7 a) Bitonic sequence: increase to a point and then decrease.
    // build two arrays and get longest increasing sub sequence from left and then from right.
    // a[pos] = (left[pos] +right[pos] - 1) bz pos is considered twice
    // https://www.youtube.com/watch?v=TWHytKnOPaQ
    // 8) maximum sum of increasing subsequence {3,4,-1,0,6,2,3}, {4,6,1,3,8,4,6}
    // very similar to find maximum length of increasing subsequence problem and weighted job
    // scheduling
    // 8 a) maximum sum of increasing contagious array {3,4,-1,0,6,2,3}, {4,6,1,3,8,4,6}
    // very similar to find maximum length of increasing subsequence problem and weighted job
    // scheduling
    // just look one step behind to find if (prev < curr) then sum(curr) = sum(prev) + curr
    //https://www.youtube.com/watch?v=99ssGWhLPUE&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=30
    // 9) Minimum jump to reach end of the array {2,3,1,1,2,4,2,0,1,1}
    // 10) cutting rod to maximize profit. very similar to 0/1 knapsack problem l=5, vals =1(2), 2(5),3(7),4(8)
    // 11) total number of ways to go from top left to bottom right of the matrix
    //https://www.youtube.com/watch?v=GO5QHC_BmvM&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=36
    // 12) minimum cost required to reach bottom right of the matrix from top left
    //https://www.youtube.com/watch?v=lBRtnuxg-gU&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=22
    // 13) weighted job scheduling problem to maximum profit
    // 14) Maximum Sub Square Matrix Dynamic Programming
    //https://www.youtube.com/watch?v=_Lf1looyJMU&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=29
    // 15) longest palindromic subsequence in a string (refer image in github)
    // 16) longest palindromic substring in a string, (refer image in github)
    // use matrix with boolean value O(n^2)
    // 17) minimum edit distance between two string (insert, replace , delete operations)
    //https://www.youtube.com/watch?v=We3YDTzNXEk&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=6
    // s1= abcdef s2= azced
}
