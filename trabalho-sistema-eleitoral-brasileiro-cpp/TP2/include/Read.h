#ifndef READ_H_
#define READ_H_

#include <fstream>
#include <string>
#include <iostream>
#include <vector>
#include <exception>
#include "Person.h"
#include "Candidate.h"
#include "PoliticParty.h"
#include "Tokenizer.h"
#include "StringUtils.h"
using namespace std;

/**
 * @brief Reads a file with datas about all politic parties in election.
 * @param fileName Name of file.
 * @return Vector with pointers to all politic parties in election. 
 */
vector<PoliticParty*> read_politic_party(const string& fileName);

/**
 * @brief Reads a file with datas about all candidates in electon.
 * @param fileName Name of file.
 * @return Vector with pointers to all candidates in electon. 
 */
vector<Candidate*> read_candidate(const string& fileName);

#endif
