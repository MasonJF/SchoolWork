package Perfection;

import com.sun.prism.image.Coords;

import java.io.*;
import java.util.HashMap;

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
            e.printStackTrace();
        }
        return data.toString();
    }

    static int[][] parseCoords(String fileDir) {

        // Hashmap to manipulate data from a string into something usable.

        HashMap<Integer, int[]> HashValues = new HashMap<Integer, int[]>();
        String CoordData = FileIO.fileRead(fileDir);
        String[] lines = CoordData.split("\n");
        int[][] intArray = new int[lines.length][];
        for(int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(";");
            intArray[i] = new int[]{Integer.parseInt(line[0]),Integer.parseInt(line[1]),Integer.parseInt(line[2])};
        }
//        String[] tempHolder = new String[]{"","",""};
//        int isX = 0; //Using an int to determine what position the value is, either x or y depending on if is true or false.
//        for (int i = 0; i < CoordData.length(); i++){
//            if(CoordData.charAt(i) != ';') {
//                if(CoordData.charAt(i) == '\n') {
//                    HashValues.put(HashValues.size(), new int[] {
//                            Integer.valueOf(tempHolder[0]),
//                            Integer.valueOf(tempHolder[1]),
//                            Integer.valueOf(tempHolder[2])
//                    });
//                    tempHolder[0] = "";
//                    tempHolder[1] = "";
//                    tempHolder[2] = "";
//                    isX = 0;
//                }else{
//                    tempHolder[isX] += CoordData.charAt(i);
//                }
//            }else{
//                isX = 1;
//            }
//        }
        return intArray;
    }
}
