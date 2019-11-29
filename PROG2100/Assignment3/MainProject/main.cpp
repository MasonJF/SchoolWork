#include <iostream>
#include <ServerSocket.h>
#include <ClientSocket.h>

int main() {
    std::cout << "Hello, World!" << std::endl;
    ServerSocket sock {8080};
    return 0;
}