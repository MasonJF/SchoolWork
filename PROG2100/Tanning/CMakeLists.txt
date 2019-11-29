cmake_minimum_required(VERSION 3.15)
project(Tanning)

set(CMAKE_CXX_STANDARD 14)

include_directories(src)

add_executable(Tanning
        src/Bed.cpp
        src/Bed.h
        src/Salon.cpp
        src/Salon.h src/main.cpp)
