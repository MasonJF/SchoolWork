# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.10

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Library.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Library.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Library.dir/flags.make

CMakeFiles/Library.dir/ClientSocket.cpp.o: CMakeFiles/Library.dir/flags.make
CMakeFiles/Library.dir/ClientSocket.cpp.o: ../ClientSocket.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Library.dir/ClientSocket.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/Library.dir/ClientSocket.cpp.o -c /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/ClientSocket.cpp

CMakeFiles/Library.dir/ClientSocket.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Library.dir/ClientSocket.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/ClientSocket.cpp > CMakeFiles/Library.dir/ClientSocket.cpp.i

CMakeFiles/Library.dir/ClientSocket.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Library.dir/ClientSocket.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/ClientSocket.cpp -o CMakeFiles/Library.dir/ClientSocket.cpp.s

CMakeFiles/Library.dir/ClientSocket.cpp.o.requires:

.PHONY : CMakeFiles/Library.dir/ClientSocket.cpp.o.requires

CMakeFiles/Library.dir/ClientSocket.cpp.o.provides: CMakeFiles/Library.dir/ClientSocket.cpp.o.requires
	$(MAKE) -f CMakeFiles/Library.dir/build.make CMakeFiles/Library.dir/ClientSocket.cpp.o.provides.build
.PHONY : CMakeFiles/Library.dir/ClientSocket.cpp.o.provides

CMakeFiles/Library.dir/ClientSocket.cpp.o.provides.build: CMakeFiles/Library.dir/ClientSocket.cpp.o


CMakeFiles/Library.dir/ServerSocket.cpp.o: CMakeFiles/Library.dir/flags.make
CMakeFiles/Library.dir/ServerSocket.cpp.o: ../ServerSocket.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/Library.dir/ServerSocket.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/Library.dir/ServerSocket.cpp.o -c /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/ServerSocket.cpp

CMakeFiles/Library.dir/ServerSocket.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Library.dir/ServerSocket.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/ServerSocket.cpp > CMakeFiles/Library.dir/ServerSocket.cpp.i

CMakeFiles/Library.dir/ServerSocket.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Library.dir/ServerSocket.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/ServerSocket.cpp -o CMakeFiles/Library.dir/ServerSocket.cpp.s

CMakeFiles/Library.dir/ServerSocket.cpp.o.requires:

.PHONY : CMakeFiles/Library.dir/ServerSocket.cpp.o.requires

CMakeFiles/Library.dir/ServerSocket.cpp.o.provides: CMakeFiles/Library.dir/ServerSocket.cpp.o.requires
	$(MAKE) -f CMakeFiles/Library.dir/build.make CMakeFiles/Library.dir/ServerSocket.cpp.o.provides.build
.PHONY : CMakeFiles/Library.dir/ServerSocket.cpp.o.provides

CMakeFiles/Library.dir/ServerSocket.cpp.o.provides.build: CMakeFiles/Library.dir/ServerSocket.cpp.o


CMakeFiles/Library.dir/Socket.cpp.o: CMakeFiles/Library.dir/flags.make
CMakeFiles/Library.dir/Socket.cpp.o: ../Socket.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/Library.dir/Socket.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/Library.dir/Socket.cpp.o -c /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/Socket.cpp

CMakeFiles/Library.dir/Socket.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Library.dir/Socket.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/Socket.cpp > CMakeFiles/Library.dir/Socket.cpp.i

CMakeFiles/Library.dir/Socket.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Library.dir/Socket.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/Socket.cpp -o CMakeFiles/Library.dir/Socket.cpp.s

CMakeFiles/Library.dir/Socket.cpp.o.requires:

.PHONY : CMakeFiles/Library.dir/Socket.cpp.o.requires

CMakeFiles/Library.dir/Socket.cpp.o.provides: CMakeFiles/Library.dir/Socket.cpp.o.requires
	$(MAKE) -f CMakeFiles/Library.dir/build.make CMakeFiles/Library.dir/Socket.cpp.o.provides.build
.PHONY : CMakeFiles/Library.dir/Socket.cpp.o.provides

CMakeFiles/Library.dir/Socket.cpp.o.provides.build: CMakeFiles/Library.dir/Socket.cpp.o


# Object files for target Library
Library_OBJECTS = \
"CMakeFiles/Library.dir/ClientSocket.cpp.o" \
"CMakeFiles/Library.dir/ServerSocket.cpp.o" \
"CMakeFiles/Library.dir/Socket.cpp.o"

# External object files for target Library
Library_EXTERNAL_OBJECTS =

libLibrary.so: CMakeFiles/Library.dir/ClientSocket.cpp.o
libLibrary.so: CMakeFiles/Library.dir/ServerSocket.cpp.o
libLibrary.so: CMakeFiles/Library.dir/Socket.cpp.o
libLibrary.so: CMakeFiles/Library.dir/build.make
libLibrary.so: CMakeFiles/Library.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Linking CXX shared library libLibrary.so"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/Library.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Library.dir/build: libLibrary.so

.PHONY : CMakeFiles/Library.dir/build

CMakeFiles/Library.dir/requires: CMakeFiles/Library.dir/ClientSocket.cpp.o.requires
CMakeFiles/Library.dir/requires: CMakeFiles/Library.dir/ServerSocket.cpp.o.requires
CMakeFiles/Library.dir/requires: CMakeFiles/Library.dir/Socket.cpp.o.requires

.PHONY : CMakeFiles/Library.dir/requires

CMakeFiles/Library.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/Library.dir/cmake_clean.cmake
.PHONY : CMakeFiles/Library.dir/clean

CMakeFiles/Library.dir/depend:
	cd /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/cmake-build-debug /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/cmake-build-debug /mnt/c/GIT/w0422681/PROG2100/Assignment3/Library/cmake-build-debug/CMakeFiles/Library.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Library.dir/depend

