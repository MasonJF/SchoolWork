/*
 * Socket.cpp
 *
 *  Created on: 18-Jan-2009
 *  Modified on: 8-Jan-2018
 *      Author: piotr
 */


#include "Include/Socket.h"
#include <cstring>
#include <errno.h>
#include <fcntl.h>



Socket::Socket()
:socketFD_ ( -1 )
{
	memset ( &socketAddr_, 0, sizeof ( socketAddr_ ) );
}

Socket::~Socket()
{
	if ( isValid() )
		::close ( socketFD_ );
}

bool Socket::create()
{
	socketFD_ = socket ( AF_INET, SOCK_STREAM, 0 );

	if ( ! isValid() )
		return false;

	// Allow reuse of local addresses (see "socket" in man Section 7)
	int on = 1;
	if ( setsockopt ( socketFD_, SOL_SOCKET, SO_REUSEADDR, ( const char* ) &on, sizeof ( on ) ) == -1 )
		return false;
	// Feel free to experiment ;)

	return true;

}


bool Socket::bind ( const int port )
{

	if ( ! isValid() )
		return false;

	socketAddr_.sin_family = AF_INET;
	socketAddr_.sin_addr.s_addr = INADDR_ANY;
	socketAddr_.sin_port = htons ( port );

	int bind_return = ::bind ( socketFD_, ( struct sockaddr * ) &socketAddr_, sizeof ( socketAddr_ ) );


	if ( bind_return == -1 )
			return false;

	return true;
}

bool Socket::listen() const
{
	if ( ! isValid() )
		return false;

	int listen_return = ::listen ( socketFD_, MAXCONNECTIONS );


	if ( listen_return == -1 )
		return false;

	return true;
}


bool Socket::accept ( Socket& new_socket ) const
{
	int addr_length = sizeof ( socketAddr_ );
	new_socket.socketFD_ = ::accept ( socketFD_, ( sockaddr * ) &socketAddr_, ( socklen_t * ) &addr_length );

	if ( new_socket.socketFD_ <= 0 )
		return false;

	return true;
}


bool Socket::send ( const string s ) const
{
	int status = ::send ( socketFD_, s.c_str(), s.size(), MSG_NOSIGNAL );
	if ( status == -1 )
		return false;

	return true;

}


int Socket::recv ( string& s ) const
{
	char buf [ MAXRECV + 1 ];

	s = "";

	memset ( buf, 0, MAXRECV + 1 );

	int status = ::recv ( socketFD_, buf, MAXRECV, 0 );

	if ( status == -1 )
	{
		std::cout << "status == -1   errno == " << errno << "  in Socket::recv\n";
		return 0;
	}
	else if ( status == 0 )
				return 0;
	else
    {
      s = buf;
      return status;
    }
}



bool Socket::connect ( const std::string host, const int port )
{
	if ( ! isValid() ) return false;

	socketAddr_.sin_family = AF_INET;
	socketAddr_.sin_port = htons ( port );

	int status = inet_pton ( AF_INET, host.c_str(), &socketAddr_.sin_addr );

	if ( errno == EAFNOSUPPORT ) return false;

	status = ::connect ( socketFD_, ( sockaddr * ) &socketAddr_, sizeof ( socketAddr_ ) );

	if ( status == 0 )
		return true;

	return false;
}

void Socket::set_non_blocking ( const bool b )
{
	int opts;

	opts = fcntl ( socketFD_, F_GETFL );

	if ( opts < 0 )
		return;

	if ( b )
		opts = ( opts | O_NONBLOCK );
	else
		opts = ( opts & ~O_NONBLOCK );

	fcntl ( socketFD_, F_SETFL, opts );

}
