package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RouteRepository {

    private static final List<Route> routeGroup = new ArrayList<>();

    public static List<Route> routeGroup(){
        return Collections.unmodifiableList(routeGroup);
    }

    public static void addRoute(Route route){
        routeGroup.add(route);
    }

    public static int getDistanceAmount(List<String> names){
        int amount=0;
        for(int i=0;i<names.size()-1;i++){
            System.out.println(names.get(i)+" "+names.get(i+1));
            int distance = RouteRepository.getDistance(Arrays.asList(names.get(i), names.get(i + 1)));
            amount += distance;
        }
        return amount;
    }
    public static int getDistance(List<String> names){
        Route route = routeGroup.stream().filter(r -> r.isSameRoute(names))
                .findAny()
                .get();
        return route.getDistance();
    }

    public static int getTimeAmount(List<String> names){
        int amount=0;
        for(int i=0;i<names.size()-1;i++){
            System.out.println(names.get(i)+" "+names.get(i+1));
            int distance = RouteRepository.getTime(Arrays.asList(names.get(i), names.get(i + 1)));
            amount += distance;
        }
        return amount;
    }
    public static int getTime(List<String> names){
        Route route = routeGroup.stream().filter(r -> r.isSameRoute(names))
                .findAny()
                .get();
        return route.getTime();
    }

    public static List<String> getDijkstraShortestPath(Station startStation,Station endStation) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (Route route : routeGroup) {
            List<Station> stations = route.getStations();
            int distance = route.getDistance();
            Station s1 = stations.get(0);
            Station s2 = stations.get(1);
            graph.addVertex(s1.getName());
            graph.addVertex(s2.getName());
            graph.setEdgeWeight(graph.addEdge(s1.getName(),s2.getName()),distance);
        }

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation.getName(), endStation.getName()).getVertexList();
        return shortestPath;
    }
}
