#include <iostream>
#include <vector>
using namespace std;

enum Act {ADD, REMOVE, CHECK, TOGGLE, ALL, EMPTY};
vector<int> set(20, 0);
int actCheck(string action);
void add(int x);
void remove(int x);
void check(int x);
void toggle(int x);
void all();
void empty();

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int M;
    cin>>M;

    for(int i=0; i<M; i++){
        string action;
        int x;
        cin>>action;
        if(action != "all" && action != "empty"){

            cin>>x;
        }

        switch (actCheck(action))
        {
        case ADD:
            add(x);
            break;
        case REMOVE:
            remove(x);
            break;
        case CHECK:
            check(x);
            break;
        case TOGGLE:
            toggle(x);
            break;
        case ALL:
            all();
            break;
        case EMPTY:
            empty();
            break;
        default:
            cout<<"잘못입력됨"<<"\n";
            return 0;
        }
    }


    return 0;
}

int actCheck(string act){
    if(act == "add"){
        return ADD;
    }
    else if(act == "remove"){
        return REMOVE;
    }
    else if(act == "check"){
        return CHECK;
    }
    else if(act == "toggle"){
        return TOGGLE;
    }
    else if(act == "all"){
        return ALL;
    }
    else if(act == "empty"){
        return EMPTY;
    }
    else{
        return -1;
    }
}

void add(int x){
    if(set[x-1] != 0){
        return;
    }
    set[x-1] = x;
}

void remove(int x){
    if(set[x-1] == 0){
        return;
    }
    set[x-1] = 0;
}

void check(int x){
    if(set[x-1] != 0){
        cout<<1<<"\n";
    }
    else{
        cout<<0<<"\n";
    }
}
void toggle(int x){
    if(set[x-1] != 0){
        set[x-1] = 0;
    }
    else{
        set[x-1] = x;
    }
}
void all(){
    for(int i=0; i<20; i++){
        if(set[i] != 0){
            continue;
        }
        set[i] = i+1;
    }
}
void empty(){
    for(int i=0; i<20; i++){
        if(set[i] == 0){
            continue;
        }
        set[i] = 0;
    }
}