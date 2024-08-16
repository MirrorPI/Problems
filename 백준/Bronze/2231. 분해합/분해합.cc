// #include <iostream>
// using namespace std;

// int main(){
//     int N; cin>>N;
//     int M;

//     if(N<10){
//         if(N%2 == 0){
//             M = N/2;
//         }
//         else{
//             M = 0;
//         }
//     }
//     else if(N<100){
//         for(int i=18; i<=1; ++i){
//             M = N - i;
//             if(N == M + (M/100) + ((M%100)/10) + ((M%100)%10)){
//                 break;
//             }
//         }
//     }
//     else if(N<1000){
//         for(int i=27; i<=1; ++i){
//             M = N - i;
//             if(N == M + (M/1000) + ((M%1000)/100) + ((M%1000)%100)/10 + ((M%1000)%100)%10 )
//         }
//     }
//     else if(N<10000){

//     }
//     else if(N<100000){

//     }
//     else if(N<1000000){

//     }
//     else{

//     }
// }



#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int N; cin>>N; 
    int M;

    bool isIt = false;
    for(int i=54; i>=1; --i){

        M = N - i;
        if(M <= 0){

            continue;
        }

        int temp = M;
        int sum = 0;
        while((temp / 10)!=0){
            sum += temp%10;
            temp /= 10;
        }
        sum += temp;
        if(sum != i){

            continue;

        }
        isIt = true;
        break;
    }

    if(isIt == false){
        cout<<0;
        return 0;
    }
    cout<<M;
    return 0;  
}