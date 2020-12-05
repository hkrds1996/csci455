// Name: Kangrong
// USC NetID: kangrong
// CSCI 455 PA5
// Fall 2020

// Table.cpp  Table class implementation

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"

//*************************************************************************

Table::Table()
{
    hashSize = Table::HASH_SIZE;
    data = new ListType[hashSize];
    entries = 0;
    longestChain = 0;
    noEmptyBuckets = 0;
}

Table::Table(unsigned int hSize)
{
    hashSize = hSize;
    data = new ListType[hashSize];
    entries = 0;
    longestChain = 0;
    noEmptyBuckets = 0;
}

int *Table::lookup(const string &key)
{
    int theHashCode = hashCode(key);
    return getValue(data[theHashCode],key);
}

bool Table::remove(const string &key)
{
    int theHashCode = hashCode(key);
    bool result = deleteNode(data[theHashCode],key);
    if (result)
    {
        longestChain = 0;
        int listLength = getLength(data[theHashCode]);
        for (int i = 0; i < hashSize; ++i)
        {
            longestChain = longestChain > listLength ? longestChain : listLength;
        }
        if (listLength == 0)
        {
            noEmptyBuckets--;
        }
        entries--;
        return true;
    }
    return false;
}

bool Table::insert(const string &key, int value)
{
    int theHashCode = hashCode(key);
    bool result = insertNode(data[theHashCode], key, value);
    if (result)
    {
        int listLength = getLength(data[theHashCode]);
        longestChain = longestChain > listLength ? longestChain : listLength;
        if (listLength == 1)
        {
            noEmptyBuckets++;
        }
        entries++;
        return true;
    }
    return false;
}

int Table::numEntries() const
{
    return entries;
}

void Table::printAll() const
{
    int printed = 0;
    for (int i = 0; i < hashSize; ++i)
    {
       int listLength = getLength(data[i]);
        if (listLength != 0)
        {
            printList(data[i]);
            printed += listLength;
        }
        if (printed >= entries)
        {
            break;
        }
    }
}

void Table::hashStats(ostream &out) const
{
    cout << "number of buckets: " << hashSize << endl;
    cout << "number of entries: " << entries << endl;
    cout << "number of non-empty buckets: " << noEmptyBuckets << endl;
    cout << "longest chain: " << longestChain << endl;
}

// add definitions for your private methods here
