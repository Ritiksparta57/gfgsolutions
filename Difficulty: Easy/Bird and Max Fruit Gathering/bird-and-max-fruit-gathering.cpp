class Solution {
  public:
    int maxFruits(vector<int>& arr, int m) {
        // code here
        int n = arr.size();
        vector<int> pref(2 * n , 0);
        pref[0] = arr[0];
        for(int i = 1; i < n; i++){
            pref[i] = arr[i] + pref[i - 1];
        }
        for(int i = n; i < 2 * n; i++){
            pref[i] = arr[i % n] + pref[i - 1];
        }
        
        int ans = pref[m - 1];
        int start = 0;
        for(int i = m; i < n + m - 1; i++){
            ans = max(ans  , pref[i] - pref[start]);
            start++;
        }
        return ans;
    }
};

