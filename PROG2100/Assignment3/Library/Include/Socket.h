/*
 * Socket.h
 *
 *  Created on: 19-Jan-2009
 *  Modified on: 8-Jan-2018
 *      Author: piotr
 */

#ifndef SOCKET_H_
#define SOCKET_H_

#include <iostream>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <unistd.h>
#include <string>
#include <arpa/inet.h>

using namespace std;

const int MAXHOSTNAME = 100;
const int MAXCONNECTIONS = 5;
const int MAXRECV = 512;

class Socket {
public:
	Socket();
	virtual ~Socket();

	// Server initialization
	bool create();
	bool bind ( const int port );
	bool listen() const;
	bool accept ( Socket& ) const;

	// Client initialization
	bool connect ( const string host, const int port );

	// Data Transmission
	bool send ( const string ) const;
	int recv ( string& ) const;

	void set_non_blocking ( const bool );
	bool isValid() const { return socketFD_ != -1; }

private:
	int socketFD_;
	sockaddr_in socketAddr_;

};

#endif /*SOCKET_H_*/
