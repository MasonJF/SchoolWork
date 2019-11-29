package Main;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        int cnt = 0;
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Weapon> weapons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            vehicles.add(LandVehicle.makeRandomVehicle());
            vehicles.add(AirVehicle.makeRandomAirVehicle());
        }
        while(true){
            for (Vehicle veh: vehicles) {
                veh.run();
//                veh.print();

                if(cnt == 10) {
                    System.out.println("\n\n");
                    for (Vehicle nudge : vehicles) {
                        nudge.nudge();
                        weapons.add(nudge.fireWeapon());
                    }
                    cnt = 0;
                }
            }
            for (Weapon test: weapons) {
                System.out.println(test.damage + " " + test.size + " " + "y=" + test.position [1]);
                test.update();
                for (Vehicle veh: vehicles) {
                    if (veh.position[0] == test.position[0] && veh.position[1] == test.position[1]) {
                        System.out.println("BANG!!");
                        veh.onHit(test.damage);
//                        weapons.remove(test);
                    }
                }
            }




            mySleep();
            cnt++;
        }
    }

    private static void mySleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
