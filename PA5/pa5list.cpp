// Name: Kangrong
// USC NetID: kangrong
// CSCI 455 PA5
// Fall 2020

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {
   ListType nodeList = NULL;
   cout << getLength(nodeList) << endl;
   insertNode(nodeList, "str1", 120);
   insertNode(nodeList, "str2", 120);
   insertNode(nodeList, "str3", 120);
   insertNode(nodeList, "str4", 120);
   insertNode(nodeList, "str5", 120);
   printList(nodeList);
   deleteNode(nodeList, "str5");
   deleteNode(nodeList, "str4");
   deleteNode(nodeList, "str3");
   cout << getLength(nodeList) << endl;
   printList(nodeList);
   cout << *(getValue(nodeList, "str1")) <<endl;
   deleteNode(nodeList, "str2");
   deleteNode(nodeList, "str1");
   deleteNode(nodeList, "str5");
   cout << getLength(nodeList) << endl;
   cout << *(getValue(nodeList, "str4")) <<endl;
   printList(nodeList);
   return 0;
}
