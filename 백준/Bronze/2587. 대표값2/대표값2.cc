#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    vector<int> vec;
    int sum = 0;
    for(int i=0; i<5; i++){
        int temp; cin>>temp;
        sum+=temp;
        vec.push_back(temp);
    }
    
    sort(vec.begin(), vec.end());

    cout<<sum/5<<endl;
    cout<<vec[2];

    return 0;
}