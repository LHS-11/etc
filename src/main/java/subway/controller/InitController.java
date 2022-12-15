package subway.controller;

import subway.domain.Route;
import subway.domain.RouteRepository;
import subway.domain.Station;

import java.util.Arrays;

public class InitController {
    public static void init() {


        initRoute();


    }

    private static void initRoute() {
        RouteRepository.routeGroup().add(
                new Route(Arrays.asList(new Station("교대역"),new Station("강남역")),2,3)
                );
        RouteRepository.routeGroup().add(
                new Route(Arrays.asList(new Station("강남역"),new Station("역삼역")),2,3)
        );
        RouteRepository.routeGroup().add(
                new Route(Arrays.asList(new Station("교대역"),new Station("남부터미널역")),3,2)
        );
        RouteRepository.routeGroup().add(
                new Route(Arrays.asList(new Station("남부터미널역"),new Station("양재역")),6,5)
        );
        RouteRepository.routeGroup().add(
                new Route(Arrays.asList(new Station("양재역"),new Station("매봉역")),1,1)
        );
        RouteRepository.routeGroup().add(
                new Route(Arrays.asList(new Station("강남역"),new Station("양재역")),2,8)
        );
        RouteRepository.routeGroup().add(
                new Route(Arrays.asList(new Station("양재역"),new Station("양재시민의숲역")),10,3)
        );
    }
}
