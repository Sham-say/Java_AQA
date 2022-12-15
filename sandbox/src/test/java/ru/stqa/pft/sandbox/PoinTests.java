package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PoinTests {
  @Test
  public void testDistance() {
    Point p1 = new Point(10,17);
    Point p2 = new Point(16,20);
    Assert.assertEquals(p1.distance(p2), 6.708203932499369);
  }
  
}
