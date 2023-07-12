//package org.example.chapter5;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.isEmptyString;
//public class Connect4TDDSpec {
//
//
//    private Course4TheTDD tested;
//    @Rule
//    public ExpectedException exception = ExpectedException.none();
//
//    @Before
//    public void beforeEachTest() {
//        tested = new Course4TheTDD();
//    }
//    @Test
//    public void whenTheGameIsStartedTheBoardIsEmpty() {
//        assertThat(tested.getNumberOfDiscs(), is(0));
//    }
//    @Test
//    public void whenDiscOutsideBoardThenRuntimeException() {
//        int column = -1;
//        exception.expect(RuntimeException.class);
//        exception.expectMessage("Invalid column " + column);
//        tested.putDiscInColumn(column);
//    }
//    // 如果碟片位于棋盘边界外，将引发运行阶段异常；
//    @Test
//    public void whenDiscOutsideBoardThenRuntimeException2() {
//        int column = 7;
//        exception.expect(RuntimeException.class);
//        exception.expectMessage("Invalid column " + column);
//        tested.putDiscInColumn(column);
//    }
//
//    //   碟片被加入空列时，其位置为0；
//    @Test
//    public void whenFirstDiscInsertedInColumnThenPositionIsZero() {
//        int column = 1;
//        Assert.assertThat(tested.putDiscInColumn(column), is(0));
//    }
//
//    // 碟片被加入已经有一个碟片的列时，其位置为1；
//    @Test
//    public void whenSecondDiscInsertedInColumnThenPositionIsOne() {
//        int column = 1;
//        tested.putDiscInColumn(column);
//        Assert.assertThat(tested.putDiscInColumn(column), is(1));
//    }
//
//    // 每加入一个碟片，总碟片数都加1
//    @Test
//    public void whenDiscInsertedThenNumberOfDiscsIncreases() {
//        int column = 1;
//        tested.putDiscInColumn(column);
//        Assert.assertThat(tested.getNumberOfDiscs(), is(1));
//    }
//
//    //  向已满的列中加入碟片时，将引发运行阶段异常。
//    @Test
//    public void whenNoMoreRoomInColumnThenRuntimeException() {
//        int column = 1;
//        int maxDiscsInColumn = 6; // the number of rows
//        for(int times = 0; times< maxDiscsInColumn; ++ times) {
//            tested.putDiscInColumn(column);
//        }
//        exception.expect(RuntimeException.class);
//        exception.expectMessage("No more room in column " + column);
//        tested.putDiscInColumn(column);
//    }
//}
