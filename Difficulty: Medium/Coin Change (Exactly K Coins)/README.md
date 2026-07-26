<h2><a href="https://www.geeksforgeeks.org/problems/another-coin-change-problem--170647/1">Coin Change (Exactly K Coins)</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18px;">Given two integers<strong> k</strong> and <strong>target</strong>, and an array <strong>coins[]</strong>, determine whether it is possible to make a sum equal to target using an infinite supply of each coin such that the total number of coins used is exactly k.</span></p>
<p><strong><span style="font-size: 18px;">Examples:</span></strong></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>k = 3, target = 11, coins = [1, 10, 5, 8, 6]</span>
<span style="font-size: 18px;"><strong>Output:</strong> true</span>
<span style="font-size: 18px;"><strong>Explanation: </strong>2 coins of 5 and 1 coins of 1 can be used to make change of 11 i.e. 11 =&gt; 5+5+1.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>k = 5, target = 25, coins = [7, 2, 4]</span>
<span style="font-size: 18px;"><strong>Output: </strong>true</span>
<span style="font-size: 18px;"><strong>Explanation: </strong>3 coins 7, 2 coins of 2 can be used to make change of 25 i.e. 25 =&gt; 7+7+7+2+2.</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ k, coins[i] ≤ 100<br>1 ≤ target ≤ 1000</span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;