package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouteRepository {

    private static final List<Route> routeGroup = new ArrayList<>();

    public static List<Route> routeGroup(){
        return Collections.unmodifiableList(routeGroup);
    }

    public static List<Station> getDijkstraShortestPath(Station startStation,Station endStation) {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (Route route : routeGroup) {
            List<Station> stations = route.getStations();
            int distance = route.getDistance();
            Station s1 = stations.get(0);
            Station s2 = stations.get(1);
            graph.addVertex(s1);
            graph.addVertex(s2);
            graph.setEdgeWeight(graph.addEdge(s1,s2),distance);
        }

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<Station> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        return shortestPath;
    }
}
