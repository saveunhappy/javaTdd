//package org.example.chapter4;
//
//import org.testng.annotations.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.testng.Assert.*;
//
//// 使用TestNG时，在类级指定注解 @Test 后，无需再指定应将哪些方法视为测试。
//// 在这里，所有的公有方法都被视为TestNG测试。
//
//@Test
//public class ShipSpec {
//    private Ship ship;
//    private Location location;
//    private Planet planet;
//
//    @BeforeMethod
//    public void beforeTest() {
//        location = new Location(new Point(21, 13), Direction.NORTH);
//        Point max = new Point(50, 50);
//        List<Point> obstacles = new ArrayList<Point>();
//        obstacles.add(new Point(44, 44));
//        obstacles.add(new Point(45, 46));
//        planet = new Planet(max,obstacles);
//        ship = new Ship(location,planet);
//    }
//    public void whenInstantiatedThenLocationIsSet() {
//        assertEquals(ship.getLocation(), location);
//    }
//    /**
//     * 然而，不应这样编写单元测试。大多数UT新手都会落入这样的陷阱，即指定方法的结果时，
//     * 牵涉到它使用的方法、类和库的内部工作原理。这种做法在很多层面上都存在问题。
//     * 当前规范的单元中包含外部代码时，应考虑这样一点(至少在这里应该如此)，
//     * 即外部代码 已经过测试。我们知道外部代码没有问题，因为每次修改代码后，我们都运行了所有测试
//     **/
////    public void givenNorthWhenMoveForwardThenYDecreases(){
////         ship.moveForward();
////         assertEquals(ship.getLocation().getPoint().getY(), 12);
////    }
////    public void givenEastWhenMoveForwardThenXIncreases() {
////         ship.getLocation().setDirection(Direction.EAST);
////         ship.moveForward();
////         assertEquals(ship.getLocation().getPoint().getX(), 22);
////    }
//
//    public void whenMoveForwardThenForward() {
//        Location expected = location.copy();
//        expected.forward();
//        ship.moveForward();
//        assertEquals(ship.getLocation(), expected);
//    }
//    public void whenMoveBackwardThenBackward() {
//        Location expected = location.copy();
//        expected.backward();
//        ship.moveBackward();
//        assertEquals(ship.getLocation(), expected);
//    }
//    public void whenTurnLeftThenLeft() {
//        Location expected = location.copy();
//        expected.turnLeft();
//        ship.turnLeft();
//        assertEquals(ship.getLocation(), expected);
//    }
//    /**
//     * 	右转功能
//     */
//    public void whenTurnRightThenRight() {
//        Location expected = location.copy();
//        expected.turnRight();
//        ship.turnRight();
//        assertEquals(ship.getLocation(), expected);
//    }
//
//
//
//    public void whenReceiveCommandsFThenForward() {
//        Location expected = location.copy();
//        expected.forward();
//        ship.receiveCommands("f");
//        assertEquals(ship.getLocation(), expected);
//    }
//    public void whenReceiveCommandsBThenBackward() {
//        Location expected = location.copy();
//        expected.backward();
//        ship.receiveCommands("b");
//        assertEquals(ship.getLocation(), expected);
//    }
//    public void whenReceiveCommandsBThenLeft() {
//        Location expected = location.copy();
//        expected.turnLeft();
//        ship.receiveCommands("l");
//        assertEquals(ship.getLocation(), expected);
//    }
//    public void whenReceiveCommandsBThenRight() {
//        Location expected = location.copy();
//        expected.turnRight();
//        ship.receiveCommands("r");
//        assertEquals(ship.getLocation(), expected);
//    }
//
//    public void whenReceiveCommandsThenAllAreExecuted() {
//        Location expected = location.copy();
//        expected.turnRight();
//        expected.forward();
//        expected.turnLeft();
//        expected.backward();
//        ship.receiveCommands("rflb");
//        assertEquals(ship.getLocation(), expected);
//    }
//
//    public void whenInstantiatedThenPlanetIsStored() {
//        assertEquals(ship.getPlanet(), planet);
//    }
//
//    public void overpassEastBoundary() {
//        location.setDirection(Direction.EAST);
//        location.getPoint().setX(planet.getMax().getX());
//        ship.receiveCommands("f");
//        assertEquals(location.getX(), 1);
//    }
//
//    public void whenReceiveCommandsThenOForOkAndXForObstacle() {
//        List<Point> obstacles = new ArrayList<Point>();
//        obstacles.add(new Point(location.getX() + 1, location.getY()));
//        ship.getPlanet().setObstacles(obstacles);
//        String status = ship.receiveCommands("rflb");
//        assertEquals(status, "OXOO");
//    }
//}
