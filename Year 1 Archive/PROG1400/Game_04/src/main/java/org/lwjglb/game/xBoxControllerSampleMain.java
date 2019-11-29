//package org.lwjglb.game;
//
//import com.exlumina.j360.J360;
//import com.exlumina.j360.XInputState;
//
///**
// * Home Page: https://coderanch.com/t/681150/Simple-XBox-Controller-Support-Java
// *
// * JavaDoc:  http://exlumina.com/J360Controller/Tutorials/javadoc/index.html
// *
// * Just put the J360Controller.jar into the project
// * File -> Project Structure -> Modules ...+add the Jar file
// *
// * (Similar steps for Eclipse...get the project to "see" this Jar)
// *
// */
//public class xBoxControllerSampleMain
//{
//    public static void main(String... args) throws InterruptedException
//    {
//        XInputState pState = new XInputState();
//
//        for (int i = 0; i < 10000; ++i)
//        {
//            for (int p = 0; p < J360.XUSER_MAX_COUNT; ++p)
//            {
//                if (J360.XInputGetState(p, pState) == J360.ERROR_SUCCESS)
//                {
//                    System.out.println("State1=" + pState.Gamepad.wButtons);
//                    // Java conditional operator ... ?
//                    // https://stackoverflow.com/questions/798545/what-is-the-java-operator-called-and-what-does-it-do
//                    System.out.println("State1=" +
//                            ((pState.Gamepad.wButtons & J360.XINPUT_GAMEPAD_X) != 0 ? "down" : "up"));
////                    System.out.println("State2=" + pState.Gamepad.bLeftTrigger);
////                    System.out.println("State3=" + pState.Gamepad.bRightTrigger);
////                    System.out.println("State4=" + pState.Gamepad.sThumbLX);
////                    System.out.println("State5=" + pState.Gamepad.sThumbRX);
////                    System.out.println("State6=" + pState.Gamepad.sThumbRY);
////                    System.out.println("State7=" + pState.Gamepad.sThumbRX);
//                }
//            }
//            //System.out.println();
//            //Thread.sleep(1000);
//        }
//    }
//}
