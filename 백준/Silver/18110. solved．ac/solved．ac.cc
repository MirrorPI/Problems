#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

void arrSort(vector<int>& vec){
    sort(vec.begin(), vec.end());
}

int main(){
    int n;
    cin>>n;
    if(n == 0){
        cout<<0;
        return 0;
    }

    vector<int> levels(n);
    for(int i=0; i<n; i++){
        cin>>levels[i];
    }
    arrSort(levels);

    int cutNum = static_cast<int>(round(0.15*n));
    int calNum = n - 2*cutNum;
    int sum = 0;
    for(int i = cutNum; i<n-cutNum; i++){
        sum += levels[i];
    }

    int average = static_cast<int>(round(static_cast<double>(sum)/calNum));
    cout<<average;

    return 0;
}
