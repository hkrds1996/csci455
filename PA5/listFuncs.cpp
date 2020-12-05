// Name: Kangrong
// USC NetID: kangrong
// CSCI 455 PA5
// Fall 2020

#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue)
{
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n)
{
   key = theKey;
   value = theValue;
   next = n;
}

//*************************************************************************
// put the function definitions for your list functions below

int getLength(ListType list)
{
   int length = 0;
   while (list != NULL)
   {
      length++;
      list = list->next;
   }
   return length;
}

bool deleteNode(ListType &list, const std::string &theKey)
{
   if (list == NULL)
   {
      return false;
   }

   if (list->key == theKey)
   {
      ListType temp = list;
      list = list->next;
      delete temp;
      return true;
   }
   ListType listLterator = list->next;
   ListType acientNode = list;
   while (listLterator != NULL)
   {
      if (listLterator->key == theKey)
      {
         acientNode->next = listLterator->next;
         delete listLterator;
         return true;
      }
      else
      {
         acientNode = listLterator;
         listLterator = acientNode->next;
      }
   }
   return false;
}

bool insertNode(ListType &list, const std::string &theKey, int theValue)
{
   ListType listLterator = list;
   while (listLterator != NULL)
   {
      if (listLterator->key == theKey)
      {
         return false;
      }
      else
      {
         listLterator = listLterator->next;
      }
   }
   list = new Node(theKey, theValue, list);
   return true;
}

int *getValue(ListType &list, const std::string &theKey)
{
   ListType listLterator = list;
   int *result = NULL;
   while (listLterator != NULL)
   {
      if (listLterator->key == theKey)
      {
         result = &listLterator->value;
         return result;
      }
      else
      {
         listLterator = listLterator->next;
      }
   }
   return result;
}

void printList(ListType list){
   while(list != NULL){
      cout << list -> key <<" " << list->value<<endl;
      list = list -> next;
   }
}