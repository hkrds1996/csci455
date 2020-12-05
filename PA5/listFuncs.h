// Name: Kangrong
// USC NetID: kangrong
// CSCI 455 PA5
// Fall 2020

//*************************************************************************
// Node class definition
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in *header* files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H

struct Node
{
   std::string key;
   int value;
   Node *next;
   Node(const std::string &theKey, int theValue);
   Node(const std::string &theKey, int theValue, Node *n);
};

typedef Node *ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

// a function that inserts a node into the List
// args:
//     list: the list that we want to operate.
//     theKey: the new node's key.
//     theValue: the new node's value.
// return false when this key is already in the list. return ture when success.
bool insertNode(ListType &list, const std::string &theKey, int theValue);

// a function that delets a node in the List
// args:
//     list: the list that we want to operate.
//     theKey: the node's key.
// return false when this key is not in the list. return ture when success.
bool deleteNode(ListType &list, const std::string &theKey);

// a function that return the values' address in the node.
// args:
//     list: the list that we want to operate.
//     theKey: the new node's key.
// return NULL when this key is not in the list. return value's address when success.
int *getValue(ListType &list, const std::string &theKey);

// a function that returns the list' size
// args:
//     list: the list that we want to operate.
// return the length of the list
int getLength(ListType list);

// a function that output value in the list
// args:
//     list: the list that we want to operate.
void printList(ListType list);

// keep the following line at the end of the file
#endif
