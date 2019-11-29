/*
 * ServerSocket.h
 *
 *  Created on: 18-Jan-2009
 *  Modified on: 8-Jan-2018
 *      Author: piotr
 */

#ifndef SERVERSOCKET_H_
#define SERVERSOCKET_H_

#include "Socket.h"
#include "SocketException.h"


class ServerSocket : private Socket  {
public:

	ServerSocket ( int port ) ;
	ServerSocket (){}
	virtual ~ServerSocket();

	const ServerSocket& operator << ( const std::string& ) const ;
	const ServerSocket& operator >> ( std::string& ) const ;

	void accept ( ServerSocket& ) ;

};


#endif /*SERVERSOCKET_H_*/
