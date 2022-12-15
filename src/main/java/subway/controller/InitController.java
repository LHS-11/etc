package subway.controller;

import subway.domain.*;

import java.util.Arrays;

import static subway.domain.RouteRepository.*;

public class InitController {
    public static void init() {

        initStation();
        initLine();
        initSection();


        initRoute();


    }

    private static void initSection() {
        SectionRepository.addSection(new Line("2호선"),new Station("교대역"));
        SectionRepository.addSection(new Line("2호선"),new Station("강남역"));
        SectionRepository.addSection(new Line("2호선"),new Station("역삼역"));
        SectionRepository.addSection(new Line("3호선"),new Station("교대역"));
        SectionRepository.addSection(new Line("3호선"),new Station("남부터미널역"));
        SectionRepository.addSection(new Line("3호선"),new Station("양재역"));
        SectionRepository.addSection(new Line("3호선"),new Station("매봉역"));
        SectionRepository.addSection(new Line("신분당선"),new Station("강남역"));
        SectionRepository.addSection(new Line("신분당선"),new Station("양재역"));
        SectionRepository.addSection(new Line("신분당선"),new Station("양재시민의숲역"));
    }

    private static void initLine() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private static void initStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
    }

    private static void initRoute() {
        addRoute(
                new Route(Arrays.asList(new Station("교대역"),new Station("강남역")),2,3)
                );
        addRoute(
                new Route(Arrays.asList(new Station("강남역"),new Station("역삼역")),2,3)
        );
        addRoute(
                new Route(Arrays.asList(new Station("교대역"),new Station("남부터미널역")),3,2)
        );
        addRoute(
                new Route(Arrays.asList(new Station("남부터미널역"),new Station("양재역")),6,5)
        );
        addRoute(
                new Route(Arrays.asList(new Station("양재역"),new Station("매봉역")),1,1)
        );
        addRoute(
                new Route(Arrays.asList(new Station("강남역"),new Station("양재역")),2,8)
        );
        addRoute(
                new Route(Arrays.asList(new Station("양재역"),new Station("양재시민의숲역")),10,3)
        );
    }
}
