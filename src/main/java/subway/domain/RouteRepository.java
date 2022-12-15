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

    public static List<String> getDijkstraShortestPath(Station startStation,Station endStation,Criteria criteria) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        makeGraph(criteria, graph);
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation.getName(), endStation.getName()).getVertexList();
        return shortestPath;
    }

    private static void makeGraph(Criteria criteria, WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        for (Route route : routeGroup) {
            List<Station> stations = route.getStations();
            int weight=getWeight(criteria,route);
            getWeight(criteria, route);
            Station s1 = stations.get(0);
            Station s2 = stations.get(1);
            graph.addVertex(s1.getName());
            graph.addVertex(s2.getName());
            graph.setEdgeWeight(graph.addEdge(s1.getName(),s2.getName()),weight);
        }
    }

    private static int getWeight(Criteria criteria, Route route) {
        int weight=0;
        if(criteria ==Criteria.DISTANCE){
            weight = route.getDistance();
        }
        if(criteria ==Criteria.TIME){
            weight = route.getTime();
        }
        return weight;
    }
}
