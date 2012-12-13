package AStar.Tests;
import AStar.Tests.SearchNode2D;
import AStar.*;
import AStar.Tests.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*; 

public class AStarTest {
    @Test
    public void SearchNodeTest2D() {
        GoalNode2D goalNode = new GoalNode2D(3, 3);
        SearchNode2D initialNode = new SearchNode2D(1, 1, null, goalNode);
        ISearchNode lastNode = AStar.search(initialNode, goalNode);
        ArrayList<ISearchNode> path = AStar.reconstructPath(lastNode);
        assertEquals(path.size(), 5);
    }
    @Test
    public void SearchNodeCityTest() {
        ISearchNode initialNode = new SearchNodeCity("Saarbrücken");
        ISearchNode lastNode = AStar.search(initialNode, new GoalNodeCity("Würzburg"));
        ArrayList<ISearchNode> path = AStar.reconstructPath(lastNode);
        double e = 0.00001;
        assertEquals(path.get(0).f(), 222.0, e);
        assertEquals(path.get(1).f(), 228, e);
        assertEquals(path.get(2).f(), 269, e);
        assertEquals(path.get(3).f(), 289, e);
        assertEquals(path.toString(), "[Saarbrücken,f:222.0, Kaiserslautern,f:228.0, Frankfurt,f:269.0, Würzburg,f:289.0]");
    }
}

