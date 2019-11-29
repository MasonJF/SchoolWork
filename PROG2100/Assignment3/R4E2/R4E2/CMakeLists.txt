#cmake_minimum_required(VERSION 3.10)
#project(R4E2)
#
#set(CMAKE_CXX_STANDARD 14)
#
#include_directories(R4E2/src)
#
#add_executable(R4E2
#        R4E2/src/Autonomous.cpp
#        R4E2/src/Autonomous.h
#        R4E2/src/ClientHandler.cpp
#        R4E2/src/ClientHandler.h
#        R4E2/src/Entity.cpp
#        R4E2/src/Entity.h
#        R4E2/src/Environment.cpp
#        R4E2/src/Environment.h
#        R4E2/src/Factory.cpp
#        R4E2/src/Factory.h
#        R4E2/src/GoTo.cpp
#        R4E2/src/GoTo.h
#        R4E2/src/Immovable.cpp
#        R4E2/src/Immovable.h
#        R4E2/src/mainR4E2.cpp
#        R4E2/src/Mission.h
#        R4E2/src/Movable.cpp
#        R4E2/src/Movable.h
#        R4E2/src/Nap.cpp
#        R4E2/src/Nap.h
#        R4E2/src/Step.cpp
#        R4E2/src/Step.h
#        R4E2/src/Terminate.cpp
#        R4E2/src/Terminate.h)

cmake_minimum_required(VERSION 3.10.2)
project(R4E2)

set(CMAKE_CXX_STANDARD 11)

#include_directories(R4E2/src)

add_executable(R4E2
        Autonomous.cpp     Environment.cpp  Immovable.cpp  Nap.cpp
        ClientHandler.cpp  Factory.cpp      mainR4E2.cpp   Step.cpp
        Entity.cpp         GoTo.cpp         Movable.cpp    Terminate.cpp
        )

## path to include files(header files)
include_directories(../../Library/Include)
#
set (sock "sock-NOTFOUND")
# (Variable to store to, Library name excluding the lib prefix, (HINT)Classifier for next variable, Directory to libraries ex .so files)
find_library(sock Library HINT ../../Library/cmake-build-debug)

# (Project Name, Bash Variable from above)
target_link_libraries(R4E2 ${sock} pthread)