/*
 * ClientSocket.cpp
 *
 *  Created on: 18-Jan-2009
 *  Modified on: 8-Jan-2018
 *      Author: piotr
 */



#include "Include/ClientSocket.h"


ClientSocket::ClientSocket ( string host, int port )
{
	if ( ! Socket::create() )
      throw SocketException ( "Failed to create client socket." );

	if ( ! Socket::connect ( host, port ) )
      throw SocketException ( "Connect to port failed." );

}


const ClientSocket& ClientSocket::operator << ( const string& s ) const
{
	if ( ! Socket::send ( s ) )
		throw SocketException ( "Write to socket failed." );

  return *this;
}


const ClientSocket& ClientSocket::operator >> ( string& s ) const
{
	if ( ! Socket::recv ( s ) )
		throw SocketException ( "Could not read from socket." );

  return *this;
}
