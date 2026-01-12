#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n;
    cin >> n;
    
    vector<int> a(n), b(n), c(n), d(n);
    
    for (int i = 0; i < n; i++) {
        cin >> a[i] >> b[i] >> c[i] >> d[i];
    }
    
    unordered_map<int, int> ab;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            ab[a[i] + b[j]]++;
        }
    }
    
    long long result = 0;  // int 오버플로우 방지
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int sum = c[i] + d[j];
            if (ab.find(-sum) != ab.end()) {
                result += ab[-sum];
            }
        }
    }
    
    cout << result << '\n';
    
    return 0;
}