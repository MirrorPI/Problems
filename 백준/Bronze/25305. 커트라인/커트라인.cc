#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n, k; cin>>n>>k;
    vector<int> point;

    for(int i=0; i<n; i++){
        int temp; cin>>temp;
        point.push_back(temp);
    }
    sort(point.begin(), point.end());
    cout<<point[n-k];
    return 0;
}