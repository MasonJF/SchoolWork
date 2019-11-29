
cmake_minimum_required(VERSION 3.14)
project(A1)

set(CMAKE_CXX_STANDARD 11)

add_executable(A1 main.cpp Queue.h Plane.cpp Plane.h Queue.cpp Timer.h Timer.cpp
        Runway.cpp Runway.h PlaneGenerator.cpp PlaneGenerator.h Dispatcher.cpp Dispatcher.h Delay.cpp Delay.h
        Rand.cpp Rand.h Airport.cpp Airport.h)