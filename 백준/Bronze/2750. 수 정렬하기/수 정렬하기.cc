// #include <iostream>
// #include <vector>
// using namespace std;

// int main(){
//     int N; cin>>N;
//     vector <int> vec;
//     for(int i=0; i<N; i++){
//         int temp; cin>>temp;
//         vec.push_back(temp);
//     }
//     vec.
// }


#include <iostream>
#include <vector>
using namespace std;

void BubbleSort(vector<int>& arr){
    int n = arr.size();
    for(int i=0; i<n-1; i++){
        for(int j=0; j<n-1-i; j++){
            if(arr[j] > arr[j+1]){
                swap(arr[j], arr[j+1]);
            }
        }
    }
}

int main(){
    int N; cin>>N;
    vector<int> arr;
    for(int i=0; i<N; i++){
        int num; cin>>num;
        arr.push_back(num);
    }
    BubbleSort(arr);
    for(int n: arr){
        cout<<n<<endl;
    }
    return 0;
}
