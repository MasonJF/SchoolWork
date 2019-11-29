/*
 * ClientSocket.h
 *
 *  Created on: 18-Jan-2009
 *  Modified on: 8-Jan-2018
 *      Author: piotr
 */


#ifndef CLIENTSOCKET_H_
#define CLIENTSOCKET_H_

#include "Socket.h"
#include "SocketException.h"

class ClientSocket : private Socket   {
public:

	ClientSocket ( string host, int port );
	virtual ~ClientSocket(){ };

	const ClientSocket& operator << ( const string& ) const;
	const ClientSocket& operator >> ( string& ) const;

};

#endif /*CLIENTSOCKET_H_*/
