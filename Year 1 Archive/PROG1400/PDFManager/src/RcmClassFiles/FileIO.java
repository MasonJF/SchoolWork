package RcmClassFiles;

import java.io.*;

class FileIO {

    static void fileWrite(String data, String fileName) {

        //File Generation, writes data to file
        try {
            BufferedWriter generateOut = new BufferedWriter(new FileWriter(fileName));
            generateOut.write(data);
            generateOut.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    static String fileRead(String fileName) {
        //Reads the data from a file, places it in a char array.

        StringBuilder data = new StringBuilder();
        try {
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            char[] cbuf = new char[1];
            while(read.read(cbuf) != -1) { //Checking for the end of the file.
                data.append(cbuf[0]);
            }
            read.close(); // Clearing the memory
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return data.toString();
    }


}
