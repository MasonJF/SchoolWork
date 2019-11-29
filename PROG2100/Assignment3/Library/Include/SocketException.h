/*
 * SocketException.h
 *
 *  Created on: 18-Jan-2009
 *  Modified on: 8-Jan-2018
 *      Author: piotr
 */


#ifndef SOCKETEXCEPTION_H_
#define SOCKETEXCEPTION_H_

#include <stdexcept>
#include <string>

using namespace std;

class SocketException : public runtime_error  {

public:
	SocketException ( const string& s )
	:runtime_error( s ) {};
};


#endif /*SOCKETEXCEPTION_H_*/
