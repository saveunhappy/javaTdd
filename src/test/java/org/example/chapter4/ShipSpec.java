package org.example.chapter4;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

// 使用TestNG时，在类级指定注解 @Test 后，无需再指定应将哪些方法视为测试。
// 在这里，所有的公有方法都被视为TestNG测试。

@Test
public class ShipSpec {
    private Ship ship;
    private Location location;

    @BeforeMethod
    public void beforeTest(){
        location = new Location(
                new Point(21, 13), Direction.NORTH);
        ship = new Ship(location);
    }
    public void whenInstantiatedThenLocationIsSet() {
        assertEquals(ship.getLocation(), location);
    }
    /**
     * 然而，不应这样编写单元测试。大多数UT新手都会落入这样的陷阱，即指定方法的结果时，
     * 牵涉到它使用的方法、类和库的内部工作原理。这种做法在很多层面上都存在问题。
     * 当前规范的单元中包含外部代码时，应考虑这样一点(至少在这里应该如此)，
     * 即外部代码 已经过测试。我们知道外部代码没有问题，因为每次修改代码后，我们都运行了所有测试
     **/
//    public void givenNorthWhenMoveForwardThenYDecreases(){
//         ship.moveForward();
//         assertEquals(ship.getLocation().getPoint().getY(), 12);
//    }
//    public void givenEastWhenMoveForwardThenXIncreases() {
//         ship.getLocation().setDirection(Direction.EAST);
//         ship.moveForward();
//         assertEquals(ship.getLocation().getPoint().getX(), 22);
//    }

    public void whenMoveForwardThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.moveForward();
        assertEquals(ship.getLocation(), expected);
    }
    public void whenMoveBackwardThenBackward() {
        Location expected = location.copy();
        expected.backward();
        ship.moveBackward();
        assertEquals(ship.getLocation(), expected);
    }
    public void whenTurnLeftThenLeft() {
        Location expected = location.copy();
        expected.turnLeft();
        ship.turnLeft();
        assertEquals(ship.getLocation(), expected);
    }
    /**
     * 	右转功能
     */
    public void whenTurnRightThenRight() {
        Location expected = location.copy();
        expected.turnRight();
        ship.turnRight();
        assertEquals(ship.getLocation(), expected);
    }

    public void whenReceiveCommandsFThenForward() {
        Location expected = location.copy();
        expected.forward();
        ship.receiveCommands("f");
        assertEquals(ship.getLocation(), expected);
    }


}
