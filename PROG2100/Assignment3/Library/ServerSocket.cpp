/*
 * ServerSocket.cpp
 *
 *  Created on: 18-Jan-2009
 *  Modified on: 8-Jan-2018
 *      Author: piotr
 */


#include "Include/ServerSocket.h"



ServerSocket::ServerSocket ( int port )
{
	if ( ! Socket::create() )
      throw SocketException ( "Failed to create server socket." );

	if ( ! Socket::bind ( port ) )
		throw SocketException ( "Bind to port failed" );

	if ( ! Socket::listen() )
		throw SocketException ( "Listen failed." );

}

ServerSocket::~ServerSocket()
{
}


const ServerSocket& ServerSocket::operator << ( const string& s ) const
{
	if ( ! Socket::send ( s ) )
		throw SocketException ( "Write to socket failed." );

	return *this;

}


const ServerSocket& ServerSocket::operator >> (string& s ) const
{
	if ( ! Socket::recv ( s ) )
		throw SocketException ( "Read from socket failed." );

  return *this;
}

void ServerSocket::accept ( ServerSocket& s )
{
	if ( ! Socket::accept ( s ) )
		throw SocketException ( "Accept failed." );
}
