package labs.task5_Multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

class Container{
    private static int counter = 0;
    private int id;

    Container() {
        this.id = counter++;
    }

    @Override
    public String toString() {
        return "" + id;
    }
}

class Ship extends Thread{
    private Queue<Container> shipContainers = new LinkedList<>();
    private int shipMaxSize;
    private ShipType type;
    private SeaPort seaPort;
    enum ShipType{
        UNLOAD_TO_SHIP,
        LOAD_TO_PORT,
        BOTH
    }
    public void setSeaPort(SeaPort seaPort) {
        this.seaPort = seaPort;
    }

    Ship() {
        this(0, null);
    }
    Ship(ShipType type) {
        this(0, type);
    }
    Ship(int maxSize) {
        this(maxSize, null);
    }
    Ship(int maxSize, ShipType type) {
        if ( type != null){
            this.type = type;
        } else{
            int random = new Random().nextInt(99);
            this.type = (random >= 66)  ? ShipType.UNLOAD_TO_SHIP
                    : (random < 33) ? ShipType.LOAD_TO_PORT
                    : ShipType.LOAD_TO_PORT;//BOTH;
        }
        while (shipMaxSize == 0) {
            this.shipMaxSize = maxSize != 0 ? maxSize : new Random().nextInt(40);
        }
        if (this.type != ShipType.UNLOAD_TO_SHIP) {
            for (int i = 0; i < (this.type == ShipType.BOTH ? shipMaxSize/2 : shipMaxSize); i++) {
                shipContainers.add(new Container());
            }
        }

    }

    public synchronized void addContainer(Container container) {
        //synchronized (this) {
            shipContainers.add(container);
            notify();
        //}
    }
    public synchronized Container removeContainer() {
        //synchronized (this) {
            Container container = shipContainers.poll();
            //notify();
            return container;
       // }
    }

    public String getFullInfo() {
        return "Ship" + super.getName().substring(6)
                + "[" + shipMaxSize +", "
                + type + "]. Containers: " + shipContainers;
    }
    @Override
    public String toString() {
        return "Ship" + super.getName().substring(6);
    }
    @Override
    public void run() {
        while(!interrupted()){
            try {
                synchronized (this) {
                    while (shipContainers.size() == 0) {
                        if (type == ShipType.UNLOAD_TO_SHIP) break;
                        System.out.println(this + " is empty!");
                        //notify();
                        wait();
                    }
                }
                switch (type){
                    case LOAD_TO_PORT:
                        seaPort.loadToPort();
                        //sleep(200);
                        break;
                    case UNLOAD_TO_SHIP:
                        seaPort.unloadToShip();
                        //sleep(500);
                        break;
                    default:

                            seaPort.loadToPort();

                        //sleep(200);
                        seaPort.unloadToShip();
                }
                sleep(200);
                synchronized (this) {
                    while (shipContainers.size() >= shipMaxSize) {
                        if (type == ShipType.LOAD_TO_PORT) break;
                        System.out.println(this + " is full!");
                        //notify();
                        wait();
                    }
                }


            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }

    public Queue<Container> getContainers() {
        return shipContainers;
    }
}

public class SeaPort {
    private static final int DEFAULT_MAX_SIZE = 100;
    private Queue<Container> portContainers = new LinkedList<>();
    private int portMaxSize;


    public SeaPort() {
        this(DEFAULT_MAX_SIZE);
    }

    public SeaPort(int maxSize) {
        this.portMaxSize = maxSize;
        for (int i = 0; i < (portMaxSize / 2); i++){
            portContainers.add(new Container());
        }
    }

    public void loadToPort() throws InterruptedException {
        //Thread currentThread = Thread.currentThread();
        Ship ship = (Ship) Thread.currentThread();
        Container container = ship.removeContainer();
        synchronized (ship) {
            while (portContainers.size() == portMaxSize) {
                System.out.println(ship + " is wait");
                ship.wait();
            }
            synchronized (portContainers) {
                portContainers.add(container);
            }
            ship.notifyAll();
        }

        System.out.println("Container " + container + " from " + ship + " is load to port!");

//        synchronized (ship){
//            ship.notify();
//        }
    }

    public void unloadToShip() throws InterruptedException {
        //Thread currentThread
        Ship ship = (Ship) Thread.currentThread();//ship!!!
        synchronized (ship) {
            while (portContainers.size() == 0) {
                ship.wait();
            }
        }
        Container container = portContainers.poll();
        //synchronized (portContainers) {
            ship.addContainer(container);
       // }
        System.out.println("Container " + container + " is unload to " + ship);


//        synchronized (ship) {
//            ship.notify();
//        }
    }

    public static void main(String[] args) {
        System.out.println("-----------------");
        SeaPort seaPort = new SeaPort();
        System.out.println("SeaPort: " + seaPort.portContainers);
        System.out.println("-----------------");
        int shipsCount = 5;
        List<Ship> ships = new LinkedList<>();
        for (int i = 0; i < shipsCount; i++) {
            Ship ship = new Ship();
            ship.setSeaPort(seaPort);
            System.out.println(ship.getFullInfo());
            ship.start();
            ships.add(ship);

        }
        System.out.println("----------------");
        System.out.println("----------------");
        try {
            Thread.currentThread().sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Ship ship : ships) {
            ship.interrupt();
            System.out.println(ship + " is interrupted");
            System.out.println(ship + " has containers: " + ship.getFullInfo());
        }
        System.out.println("----------------");
        System.out.println("SeaPort: " + seaPort.portContainers);
        System.out.println("----------------");
    }

}
