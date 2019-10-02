import java.util.ArrayList;
import java.util.Random;



public class Main {

    public static void main(String[] args) {
        int cnt = 0;
        ArrayList<LandVehicle> landVehicles = new ArrayList<>();
        ArrayList<AirVehicle> airVehicles = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            landVehicles.add(LandVehicle.makeRandomVehicle());
            airVehicles.add(AirVehicle.makeRandomAirVehicle());
        }
        while(true){
            for (LandVehicle land: landVehicles) {
                System.out.println(land.speed + " KM " + land.position[0] + "=x" + " " + land.position[1] + "=y " + " Fuel Percent=" + land.gasPedal +
                        " brake percent=" + land.brakePedal + " Direction=" + land.direction + " Steering value=" + land.steeringDirection);
                runLand(land);
                System.out.println(land.speed + " KM " + land.position[0] + "=x" + " " + land.position[1] + "=y " + " Fuel Percent=" + land.gasPedal +
                        " brake percent=" + land.brakePedal + " Direction=" + land.direction + " Steering value=" + land.steeringDirection);
                System.out.println(" ");

                if(cnt == 10) {
                    System.out.println("\n\n");
                    for (LandVehicle nudgeLand : landVehicles) {
                        LandVehicle.nudge(nudgeLand);
                    }
                    cnt = 0;
                }
            }

            for (AirVehicle air: airVehicles) {
                System.out.println(air.speed + " KM " + air.propSpeed + "=PropSpeed "   +  air.position[0] + "=x" + " " + air.position[1] +
                        "=y " + air.position[2] + "=z" +  " Direction=" + air.direction + " VerticalDirection=" + air.verticalDirection +  " " + air.tiltDirection + "=TiltDirection " + " Steering value=" + air.steeringDirection);
                runAir(air);
                System.out.println(air.speed + " KM " + air.propSpeed + "=PropSpeed "   +  air.position[0] + "=x" + " " + air.position[1] +
                        "=y " + air.position[2] + "=z" +  " Direction=" + air.direction + " VerticalDirection=" + air.verticalDirection +  " " + air.tiltDirection + "=TiltDirection " + " Steering value=" + air.steeringDirection);
                System.out.println(" ");

                if(cnt == 10) {
                    System.out.println("\n\n");
                    for (AirVehicle nudgeLand : airVehicles) {
                        AirVehicle.nudge(nudgeLand);
                    }
                    cnt = 0;
                }
            }
            mySleep();
            cnt++;
        }
    }

    private static void runAir(AirVehicle air) {
        air.speedControl();
        air.changeDirection();
        air.changeVerticalDirection();
        air.updatePosition();
        air.updateAirPosition();
    }

    private static void runLand(LandVehicle land) {
        land.speedControl();
        land.changeDirection();
        land.updatePosition();
    }



    private static void mySleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
