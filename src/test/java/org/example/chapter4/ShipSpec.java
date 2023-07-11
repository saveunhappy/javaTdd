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
//        Location location = new Location(
//                new Point(21, 13), Direction.NORTH);
//        Ship ship = new Ship(location);
        assertEquals(ship.getLocation(), location);
    }
}
