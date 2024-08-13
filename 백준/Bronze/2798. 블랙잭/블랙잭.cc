#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int N, M; cin>>N>>M;
    vector<int> v;

    int permutation = N*(N-1)*(N-2)/6;
    vector <int> difference;
    int black = -300000;
    int count=0;

    for(int i=0; i<N; ++i){
        int input; cin>>input;
        v.push_back(input);
    }
    for(int i=0; i<v.size()-2; ++i){
        for(int j=i+1; j<v.size()-1; ++j){
            for(int k=j+1; k<v.size(); ++k){
                difference.push_back(-M+(v[i]+v[j]+v[k]));
            }
        }
    }
    for(int i=0; i<permutation; ++i){
        if(difference[i]==0){
            cout<<M;
            return 0;
        }
        else if(difference[i]>0){
            continue;
        }
        else{
            if(black < difference[i]){
                black = difference[i];

            }
        }
    }
    cout<<black+M;

    return 0;


}