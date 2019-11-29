cmake_minimum_required(VERSION 3.13)
project(Fancy_Functions C)

set(CMAKE_C_STANDARD 11)
set(CMAKE_C_STANDARD_LIBRARIES -lm)

add_executable(Fancy_Functions main.c)