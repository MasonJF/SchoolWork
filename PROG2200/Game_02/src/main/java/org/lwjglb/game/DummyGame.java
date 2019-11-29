package org.lwjglb.game;

import Server.Server;
import org.joml.*;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjglb.Database.ObjDbConverter;
import org.lwjglb.Database.SqliteDb;
import org.lwjglb.engine.IGameLogic;
import org.lwjglb.engine.MouseInput;
import org.lwjglb.engine.Scene;
import org.lwjglb.engine.SceneLight;
import org.lwjglb.engine.Window;
import org.lwjglb.engine.graph.Camera;
import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.engine.graph.Renderer;
import org.lwjglb.engine.graph.lights.DirectionalLight;
import org.lwjglb.engine.graph.lights.PointLight;
import org.lwjglb.engine.graph.weather.Fog;
import org.lwjglb.engine.items.*;
import org.lwjglb.engine.loaders.assimp.StaticMeshesLoader;

import javax.persistence.*;
import java.lang.Math;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Russ <RS> changed this game code to put a bunch
 * of moving GameItems on the screen.
 * <p>
 * To understand what's going on, do these steps:
 * - look at IGameLogic ... the game has several key entry points...understand those.
 * <p>
 * - Follow the use of "camera"  the camera is how you see the scene.  Easiest way to
 * to understand it is put the camera away a bit and pointing back towards the scene, and leave it alone.
 * <p>
 * - Follow the creation of a mesh, being added to the scene.  You can make your own mesh with Blender.
 * <p>
 * - Blender: save your mesh as an OBJ file with cube projection including Normals,
 * UVs, Materials, and Triangulate Faces.
 * <p>
 * - public void input(Window window, MouseInput mouseInput) => process keystrokes sent to the Graphics window.
 * <p>
 * - public void update(float interval, MouseInput mouseInput, Window window) called many times per second.  Use
 * this method for synched game logic. Processing within events is sloppy, and pron to threading
 * errors (and done a lot in this sample).
 */
public class DummyGame implements IGameLogic {

    private static final float MOUSE_SENSITIVITY = 0.2f;

    private final Vector3f cameraInc;

    private final Renderer renderer;

    private final Camera camera;

    private Scene scene;

    private static final float CAMERA_POS_STEP = 0.40f;

    private float angleInc;

    private float lightAngle;

    private boolean firstTime;

    private boolean sceneChanged;

    private Vector3f pointLightPos;

    private Vehicle recentItem;

    private Server server;

    private List<GameItem> gameItems;

    TypedQuery<ObjDbConverter> query;

//    SqliteDb db;
    EntityManagerFactory emf;
    EntityManager em;

//    {
//        try {
//            db = new SqliteDb("file_db");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public DummyGame() {
        renderer = new Renderer();
        camera = new Camera();
        cameraInc = new Vector3f(0.0f, 0.0f, 0.0f);
        angleInc = 0;
        lightAngle = 90;
        firstTime = true;
    }

    @Override
    public void init(Window window) throws Exception {
        renderer.init(window);
        server = new Server(Server.serverport);
        server.start();
        scene = new Scene();
//
//        Vehicle house = LandVehicle.makeRandomVehicle();
//        house.setVelocity(0.002f, 0.000f, 0.003f);
//        house.setRotationVel(new Quaternionf(0.06f, 0.01f, 0.03f, 0.0f));
//        house.setScale(0.150f);
//        recentItem = house;

        Mesh[] terrainMesh = StaticMeshesLoader.load("src/main/resources/models/terrain/terrain.obj", "src/main/resources/models/terrain");
        GameItem terrain = new GameItem(terrainMesh);
        terrain.setPosition(0.00f, -15.000f, 0.000f);
        terrain.setScale(100.0f);
        emf = Persistence.createEntityManagerFactory("$objectdb/db/file_db.odb");
        em = emf.createEntityManager();
//        em.getTransaction().begin();

        scene.setGameItems(new GameItem[]{terrain});

        TypedQuery<ObjDbConverter> q2 = em.createQuery("SELECT obj FROM ObjDbConverter obj", ObjDbConverter.class);
        List<ObjDbConverter> results = q2.getResultList();

        for (ObjDbConverter obj: results) {
            if(obj.getVeh_type() != null){
                if(obj.getVeh_type().equals("LandVehicle")) {
                    Vector3f vector = new Vector3f(obj.getX(), obj.getY(), obj.getZ());
                    Vehicle house = new LandVehicle(vector, 0, 0, 100);
                    house.setVelocity(0.002f, 0.000f, 0.003f);
                    house.setRotationVel(new Quaternionf(0.06f, 0.01f, 0.03f, 0.0f));
                    house.setScale(0.150f);
                    scene.setGameItems(new GameItem[] {house});
                }
                if(obj.getVeh_type().equals("AirVehicle")) {
                    Vector3f vector = new Vector3f(obj.getX(), obj.getY(), obj.getZ());
                    Vehicle house = new AirVehicle(vector, 0, 100);
                    house.setVelocity(0.002f, 0.000f, 0.003f);
                    house.setRotationVel(new Quaternionf(0.06f, 0.01f, 0.03f, 0.0f));
//                    house.setScale(0.150f);
                    scene.setGameItems(new GameItem[] {house});
                }

            }
        }
/*

        Statement st = DriverManager.getConnection("jdbc:sqlite:file_db", "sa", "").createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM VEHICLES");
        scene.setGameItems(new GameItem[]{terrain});
        for (; rs.next();) {
            Vector3f vector = new Vector3f(rs.getFloat(3), rs.getFloat(4), rs.getFloat(5));
            if (rs.getString(2).equals("LandVehicle")) {
                Vehicle house = new LandVehicle(vector, 0, 0, 100);
                house.setVelocity(0.002f, 0.000f, 0.003f);
                house.setRotationVel(new Quaternionf(0.06f, 0.01f, 0.03f, 0.0f));
                house.setScale(0.150f);
                scene.setGameItems(new GameItem[] {house});
            }
            if (rs.getString(2).equals("AirVehicle")) {
                Vehicle house = new AirVehicle(vector, 0, 100);
                house.setVelocity(0.01f, 0.01f, 0.01f);
                house.setRotationVel(new Quaternionf(0.06f, 0.01f, 0.03f, 0.0f));
                scene.setGameItems(new GameItem[] {house});
            }

//            recentItem = house;

        }
*/


//        db.query("SELECT * FROM vehicles");


        // Shadows
        scene.setRenderShadows(true);

        // Fog
        Vector3f fogColour = new Vector3f(0.5f, 0.5f, 0.5f);
        scene.setFog(new Fog(true, fogColour, 0.02f));

        // Setup  SkyBox
        float skyBoxScale = 100.0f;
        SkyBox skyBox = new SkyBox("src/main/resources/models/skybox.obj", new Vector4f(0.65f, 0.65f, 0.65f, 1.0f));
        skyBox.setScale(skyBoxScale);
        scene.setSkyBox(skyBox);

        // Setup Lights
        setupLights();

        // Set camera position and rotation to look back at our scene
        camera.setPosition(-17.0f, 17.0f, -30.0f);
        camera.setRotation(20.0f, 140.0f, 0.0f);

    }

    private void setupLights() {
        SceneLight sceneLight = new SceneLight();
        scene.setSceneLight(sceneLight);

        // Ambient Light
        sceneLight.setAmbientLight(new Vector3f(0.3f, 0.3f, 0.3f));
        sceneLight.setSkyBoxLight(new Vector3f(1.0f, 1.0f, 1.0f));

        // Directional Light
        float lightIntensity = 1.0f;
        Vector3f lightDirection = new Vector3f(0, 1, 1);
        DirectionalLight directionalLight = new DirectionalLight(new Vector3f(1, 1, 1), lightDirection, lightIntensity);
        sceneLight.setDirectionalLight(directionalLight);

        pointLightPos = new Vector3f(0.0f, 25.0f, 0.0f);
        Vector3f pointLightColour = new Vector3f(0.0f, 1.0f, 0.0f);
        PointLight.Attenuation attenuation = new PointLight.Attenuation(1, 0.0f, 0);
        PointLight pointLight = new PointLight(pointLightColour, pointLightPos, lightIntensity, attenuation);
        sceneLight.setPointLightList(new PointLight[]{pointLight});
    }

    @Override
    public void input(Window window, MouseInput mouseInput) {
        gameItems = scene.getgameItems();
        sceneChanged = false;
        cameraInc.set(0, 0, 0);
        if (window.isKeyPressed(GLFW_KEY_W)) {
            sceneChanged = true;
            cameraInc.z = -1;
        } else if (window.isKeyPressed(GLFW_KEY_S)) {
            sceneChanged = true;
            cameraInc.z = 1;
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            sceneChanged = true;
            cameraInc.x = -1;
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            sceneChanged = true;
            cameraInc.x = 1;
        }
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            sceneChanged = true;
            cameraInc.y = -1;
        } else if (window.isKeyPressed(GLFW_KEY_X)) {
            sceneChanged = true;
            cameraInc.y = 1;
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            sceneChanged = true;
            angleInc -= 0.05f;
        } else if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            sceneChanged = true;
            angleInc += 0.05f;
        } else {
            angleInc = 0;
        }
        if (window.isKeyPressed(GLFW_KEY_UP)) {
            sceneChanged = true;
            pointLightPos.y += 0.5f;
        } else if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            sceneChanged = true;
            pointLightPos.y -= 0.5f;
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            sceneChanged = true;
            this.removeAll = true;
        }

        if (window.isKeyPressed(GLFW_KEY_KP_1)){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sceneChanged = true;
            this.addMeshOnScreen();
        }
        if (window.isKeyPressed(GLFW_KEY_KP_2)){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sceneChanged = true;
            this.addAirOnScreen();

        }
        if (window.isKeyPressed(GLFW_KEY_KP_0)){
            sceneChanged = true;
//            for(GameItem i: gameItems) {
//                i.setIdentity(0);
//            }
//            GameItem.setIncIndentity(1);
            this.removeAll = true;
        }
        if (window.isKeyPressed(GLFW_KEY_SPACE)) {
            sceneChanged = true;
            this.addFiredWeapon(recentItem);
        }
        if (window.isKeyPressed(GLFW_KEY_M)) {
            sceneChanged = true;
            this.addMotoOnScreen();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (window.isKeyPressed(GLFW_KEY_KP_3)) {
            sceneChanged = true;
            this.addSamOnScreen();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (window.isKeyPressed(GLFW_KEY_KP_7)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saveGame(gameItems);
//            try {
//                db.update("DROP TABLE IF EXISTS vehicles");
//                db.update("CREATE TABLE vehicles (id INTEGER IDENTITY, veh_type VARCHAR(256), posX FLOAT, posY FLOAT, posZ FLOAT)");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            for (GameItem items: gameItems) {
//
//                double posX = items.getPosition().x;
//                double posY = items.getPosition().y;
//                double posZ = items.getPosition().z;
//
//                try {
//                    Thread.sleep(100);
//                    if (items instanceof LandVehicle) {
//                        db.update(String.format("INSERT INTO vehicles(veh_type, posX, posY, posZ) VALUES('LandVehicle', %f, %f, %f)", posX, posY, posZ));
//                    }
//                    if (items instanceof Motorcycle) {
//                        db.update(String.format("INSERT INTO vehicles(veh_type, posX, posY, posZ) VALUES('Motorcycle', %f, %f, %f)", posX, posY, posZ));
//
//                    }
//                    if (items instanceof AirVehicle) {
//                        db.update(String.format("INSERT INTO vehicles(veh_type, posX, posY, posZ) VALUES('AirVehicle', %f, %f, %f)", posX, posY, posZ));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        if (window.isKeyPressed(GLFW_KEY_KP_8)) {
            System.out.println("\n\n");




//            try {
//                Thread.sleep(100);
//                db.query("SELECT * FROM VEHICLES");
////                db.
//            } catch (SQLException | InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }

    public synchronized void saveGame(List<GameItem> gameItems) {
        em.getTransaction().begin();

        Query q2 = em.createQuery("delete FROM ObjDbConverter obj", ObjDbConverter.class);
        q2.executeUpdate();

        for (GameItem items: gameItems) {
            if (items.getThisIs() != null) {
                ObjDbConverter obj = new ObjDbConverter(items.getPosition().x, items.getPosition().y, items.getPosition().z, items.getThisIs(), items.getIdentity());
                em.persist(obj);
            }
        }
        em.getTransaction().commit();

        query = em.createQuery("SELECT obj FROM ObjDbConverter obj", ObjDbConverter.class);
//        List<ObjDbConverter> results = query.getResultList();
//        for (ObjDbConverter p : results) {
//            System.out.println(p);
//        }
    }

    java.util.Random r = new java.util.Random();

    @Override
    public void update(float interval, MouseInput mouseInput, Window window) {
        saveGame(gameItems);
        List<ObjDbConverter> load = query.getResultList();
        // Since we move gameItems in the background (with their own
        // thread, all the time, so cause the lighting/shadows to be recomputed
        sceneChanged = true;
        server.sendToClient(load);
        // Clear screen?
        if (GameGUI.getClearCommand()) {
            removeAll = true;
        }

        // If reset, set this gameItem back to a location.
        if (GameGUI.getResetCommand()) {
            recentItem.setPosition(11.00f, 11.000f, 15 * r.nextFloat());
            recentItem.setVelocity(0.002f, 0.001f, 0.003f);
            recentItem.setRotation(new Quaternionf(2.6f, 4.7f, 3.9f, 0.0f));
            recentItem.setRotationVel(new Quaternionf(0.006f, 0.007f, 0.0009f, 0.0f));
        }

        // If adding, add a gameItem
        if (GameGUI.getAddCommand()) {
            addMeshOnScreen();
        }

        if (GameGUI.addLand()){
            addMeshOnScreen();
        }

        // Get location of each GameItem
        List<GameItem> gameItems = scene.getgameItems();

        for (GameItem gameItem1 : gameItems) {
//            System.out.println();
            ProjectileWeapon game = null;
            Vehicle veh;
            for (GameItem gameItem2 : gameItems) {
                if (gameItem1 != gameItem2) {
                    if(gameItem1.doesItCollide(gameItem2)){
                        if(gameItem2 instanceof ProjectileWeapon) {
                            game = (ProjectileWeapon) gameItem2;
                        }
                        if(gameItem1 instanceof Vehicle) {
                            veh = (Vehicle) gameItem1;
                            if(game != null) {
                                veh.onHit(game.getDamage());
                            }
                            System.out.println(veh.health);
                        }
                        if(gameItem1 instanceof Motorcycle) {
                            gameItem1.setVelocity(0, 0, 0); // motorcycle crashed and has stopped
                        }
                        else if (gameItem2 instanceof Motorcycle) {
                            gameItem2.setVelocity(0, 0, 0); // same is true if game item 2 is moto.
                        }
                    }
//                    System.out.print("  GameItem1.x=" + gameItem1.getPosition().x);
//                    System.out.print("     GameItem2.x=" + gameItem2.getPosition().x);
                }
            }
        }

        if (mouseInput.isRightButtonPressed()) {
            // Update camera based on mouse
            Vector2f rotVec = mouseInput.getDisplVec();
            camera.moveRotation(rotVec.x * MOUSE_SENSITIVITY, rotVec.y * MOUSE_SENSITIVITY, 0);
            sceneChanged = true;
        }

        // Update camera position
        camera.movePosition(cameraInc.x * CAMERA_POS_STEP, cameraInc.y * CAMERA_POS_STEP, cameraInc.z * CAMERA_POS_STEP);

        lightAngle += angleInc;
        if (lightAngle < 0) {
            lightAngle = 0;
        } else if (lightAngle > 180) {
            lightAngle = 180;
        }
        float zValue = (float) Math.cos(Math.toRadians(lightAngle));
        float yValue = (float) Math.sin(Math.toRadians(lightAngle));
        Vector3f lightDirection = this.scene.getSceneLight().getDirectionalLight().getDirection();
        lightDirection.x = 0;
        lightDirection.y = yValue;
        lightDirection.z = zValue;
        lightDirection.normalize();

        // Update view matrix
        camera.updateViewMatrix();
    }

    public void addMeshOnScreen() {
        LandVehicle shape = LandVehicle.makeRandomVehicle();
        shape.setVelocity(0.002f, 0.000f, 0.003f);
        shape.setPosition(0, -10, 0);
        shape.setScale(0.10f);  //house needs to be shrunk
        scene.addGameItem(shape);
        recentItem = shape;
    }

    public void addMotoOnScreen() {
        Motorcycle shape = Motorcycle.makeRandomMoto();
        Random rand = new java.util.Random();
        float random = rand.nextFloat() * (1-15);
        shape.setVelocity(0.05f, 0.000f, 0.01f);
        shape.setPosition(random, random, random);
        shape.setScale(0.10f);  //house needs to be shrunk
        scene.addGameItem(shape);
        recentItem = shape;
    }

    public void addSamOnScreen() {
        SamMissle shape = SamMissle.makeRandomSam();
        Random rand = new java.util.Random();
        float random = rand.nextFloat() * (15);
        shape.setVelocity(0, 0.05f, 0);
        shape.setPosition(random, random, random);
//        shape.setScale(0.10f);  //house needs to be shrunk
        scene.addGameItem(shape);
    }

    public void addFiredWeapon(Vehicle veh) {
        try {
            float test = veh.velocity.x;
            System.out.println(test);
            ProjectileWeapon attack = veh.fireWeapon();
            attack.setVelocity( 0, (float)0.1, 0);
            scene.addGameItem(attack);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAirOnScreen() {
        try {
//            Mesh[] addMesh = StaticMeshesLoader.load("src/main/resources/models/house/house.obj", "src/main/resources/models/house");
//            Mesh[] addMesh = StaticMeshesLoader.load("src/main/resources/models/russ/russ9.obj", "src/main/resources/models/russ");
//            GameItem shape = new GameItem(addMesh);
            AirVehicle shape = AirVehicle.makeRandomAirVehicle();
//            shape.setScale(0.10f);  //house needs to be shrunk
            shape.setPosition(5.00f * r.nextFloat(), 5.000f * r.nextFloat(), 15 * r.nextFloat());
            shape.setVelocity(0.05f * r.nextFloat(), 0.04f * r.nextFloat(), 0.03f * r.nextFloat());
            shape.setRotationVel(new Quaternionf(0.06f * r.nextFloat(), 0.08f * r.nextFloat(), 0.09f * r.nextFloat(), 0.0f));
            scene.addGameItem(shape);
            recentItem = shape;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void clearScreen() {
        try {
            // Remove everything, then put back the basics
            scene.removeAll();

            Mesh[] terrainMesh = StaticMeshesLoader.load("src/main/resources/models/terrain/terrain.obj", "src/main/resources/models/terrain");
            GameItem terrain = new GameItem(terrainMesh);
            terrain.setPosition(0.00f, -15.000f, 0.000f);
            terrain.setScale(100.0f);

            scene.setGameItems(new GameItem[]{terrain});

            // Setup  SkyBox
            float skyBoxScale = 100.0f;
            SkyBox skyBox = new SkyBox("src/main/resources/models/skybox.obj", new Vector4f(0.65f, 0.65f, 0.65f, 1.0f));
            skyBox.setScale(skyBoxScale);
            scene.setSkyBox(skyBox);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // set flag to indicate to remove all meshes.
    boolean removeAll = false;

    @Override
    public void render(Window window) {
        if (this.removeAll) {
            this.clearScreen();
            this.removeAll = false;  //toggle
        }
        if (firstTime) {
            sceneChanged = true;
            firstTime = false;
        }
        renderer.render(window, camera, scene, sceneChanged);
    }

    @Override
    public void cleanup() {
        renderer.cleanup();
        scene.cleanup();
    }
}
