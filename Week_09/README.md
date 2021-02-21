学习笔记

#### 不同路径 2的状态转移方程。
```
dp[i][j] = 0 subject to obstacleGrid[i][j] == 1
dp[i][j] = dp[i - 1][j] + dp[i][j - 1] subject to obstacleGrid[i][j] == 0
```
