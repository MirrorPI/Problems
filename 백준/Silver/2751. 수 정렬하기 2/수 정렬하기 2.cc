#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n; cin>>n;
    vector<int> vec;
    for(int i=0; i<n; i++){
        int temp; cin>>temp;
        vec.push_back(temp);
    }
    sort(vec.begin(), vec.end());
    for(int num: vec){
        cout<<num<<"\n";
    }
    return 0;
}