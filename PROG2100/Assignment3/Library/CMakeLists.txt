cmake_minimum_required(VERSION 3.10.2)
project(Library)

set(CMAKE_CXX_STANDARD 11)

set(lib_sources ClientSocket.cpp ServerSocket.cpp Socket.cpp Include/ClientSocket.h Include/Socket.h Include/ServerSocket.h
        Include/SocketException.h)

add_Library(Library SHARED ${lib_sources})

# path to include files(header files)
include_directories(../Library/Include)

set (sock "sock-NOTFOUND")
# (Variable to store to, Library name excluding the lib prefix, (HINT)Classifier for next variable, Directory to libraries ex .so files)
find_library(sock Library HINT ../Library/cmake-build-debug)

# (Project Name, Bash Variable from above)
target_link_libraries(MainProject ${sock})