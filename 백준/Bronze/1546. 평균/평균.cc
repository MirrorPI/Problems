#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int N;
    scanf("%d",&N);
    int point[N];


    for(int i=0; i<N; i++){
        scanf("%d", &point[i]);
    }
    int max = *max_element(point, point + N);
    // printf("%d\n", max);
    double newPoint;
    for(int i=0; i<N; i++){
        newPoint += (static_cast<double>(point[i]))/(static_cast<double>(max))*100.0;
        // printf("%lf\n",newPoint);
    }
    printf("%lf",newPoint/N );
    return 0;
}