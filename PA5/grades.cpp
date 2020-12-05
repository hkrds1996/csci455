// Name: Kangrong
// USC NetID: kangrong
// CSCI 455 PA5
// Fall 2020

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>
#include <sstream>
#include <iostream>
#include <string>

using namespace std;

int main(int argc, char *argv[])
{

    // gets the hash table size from the command line

    int hashSize = Table::HASH_SIZE;

    Table *grades; // Table is dynamically allocated below, so we can call
    // different constructors depending on input from the user.

    if (argc > 1)
    {
        hashSize = atoi(argv[1]); // atoi converts c-string to int

        if (hashSize < 1)
        {
            cout << "Command line argument (hashSize) must be a positive number"
                 << endl;
            return 1;
        }

        grades = new Table(hashSize);
    }
    else
    { // no command line args given -- use default table size
        grades = new Table();
    }

    grades->hashStats(cout);

    // add more code here
    // Reminder: use -> when calling Table methods, since grades is type Table*
    bool processString(Table * &table, ostream & out, stringstream & ss, const string &s);
    string s;
    stringstream ss;
    string command;

    while (true)
    {
        cout << "cmd>";

        getline(cin, s);
        ss.clear();
        ss << s;
        command = "";
        ss >> command;
        if (!processString(grades, cout, ss, command))
        {
            break;
        }
    }
    return 0;
}

// insert someone's score
// args:
//     table: the hashtable that we want to operate.
//     ss: user' input with command string and contains arguments.
//     out: the ostream
// if someone is already in the hashtable, we will notify the user.
void insterData(Table *&table, stringstream &ss, ostream &out)
{
    std::string key;
    int score;
    ss >> key;
    ss >> score;
    bool result = table->insert(key, score);
    if (!result)
    {
        out << "Name was already present" << endl;
    }
}

// change someone's score
// args:
//     table: the hashtable that we want to operate.
//     ss: user' input with command string and contains arguments.
//     out: the ostream
// if someone's score doesn't in the hashtable, we will notify the user.
void changeData(Table *&table, stringstream &ss, ostream &out)
{
    std::string key;
    int newscore;
    ss >> key;
    ss >> newscore;
    int *result = table->lookup(key);
    if (result == NULL)
    {
        out << "Name isn't present" << endl;
    }
    else
    {
        *result = newscore;
    }
}

// function show someone's score
// args:
//     table: the hashtable that we want to operate.
//     ss: user' input with command string and contains arguments.
//     out: the ostream
// if someone's score doesn't in the hashtable, we will notify the user.
void lookupName(Table *&table, stringstream &ss, ostream &out)
{
    std::string key;
    ss >> key;
    int *result = table->lookup(key);
    if (result == NULL)
    {
        out << "Name isn't present" << endl;
    }
    else
    {
        out << *result << endl;
    }
}

// remove someone's score
// args:
//     table: the hashtable that we want to operate.
//     ss: user' input with command string and contains arguments.
//     out: the ostream
// if someone's score doesn't in the hashtable, we will notify the user.
void remove(Table *&table, stringstream &ss, ostream &out)
{
    std::string key;
    ss >> key;
    bool result = table->remove(key);
    if (!result)
    {
        out << "Name doesn't in the table" << endl;
    }
}

// show all the students information in the table.
// args:
//     table: the hashtable that we want to operate.
void print(Table *&table)
{
    table->printAll();
}

// show size of our hashtable
// args:
//     table: the hashtable that we want to operate.
void size(Table *&table)
{
    table->numEntries();
}

// show information about this commands
// args:
//     table: the hashtable that we want to operate.
//     out: the lostream
void stats(Table *&table, ostream &out)
{
    table->hashStats(out);
}

// return information about this commands
// args:
//     out: the lostream
void help(ostream &out)
{
    out << "insert name score : insert a name and score into table." << endl;
    out << "change name newscore : change someone's score, if we input a wrong score." << endl;
    out << "lookup name : returen someone's score." << endl;
    out << "remove name : remove someone's score." << endl;
    out << "print : Print out everyone's scores" << endl;
    out << "size : print how many people in the table" << endl;
    out << "stats : print statistics about our table." << endl;
    out << "help : command sumamry." << endl;
    out << "quit : quit the program" << endl;
}

// processString string read from terminal
// args:
//     table: the hashtable that we want to operate.
//     out: the ostream.
//     ss: the input stream without command string.
//     s: the command string.
// return false when user input "quit".
bool processString(Table *&table, ostream &out, stringstream &ss, const string &s)
{
    if (s == "insert")
    {
        insterData(table, ss, out);
    }
    else if (s == "change")
    {
        changeData(table, ss, out);
    }
    else if (s == "lookup")
    {
        lookupName(table, ss, out);
    }
    else if (s == "remove")
    {
        remove(table, ss, out);
    }
    else if (s == "print")
    {
        print(table);
    }
    else if (s == "stats")
    {
        stats(table, out);
    }
    else if (s == "help")
    {
        help(out);
    }
    else if (s == "quit")
    {
        return false;
    }
    return true;
}