#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using std::cin;
using std::cout;
using std::vector;
using std::string;


vector<int> readVals();
void printVals( vector<int> v );


int main(){
    printVals(readVals());
    return 0;
}

std::vector<int> readVals(){
    std::string s;
    std::getline(std::cin, s);
    std::stringstream ss;
    std::vector<int> v;
    ss << s;
    int i = 0;
    while(ss >> i){        
        v.push_back(i);
    }
    return v;
}

void printVals( vector<int> v ){
    int size = v.size();
    for(int i = 0; i < size -1; ++i){
        cout << v[i] << " ";
    }
    if(size != 0){
        cout << v[size - 1];
    }
    cout << "\n";    
}
