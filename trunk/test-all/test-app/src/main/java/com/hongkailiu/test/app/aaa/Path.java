package com.hongkailiu.test.app.aaa;

import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Log4j public class Path {

    private Path() {
        super();
    }

    static int[][] m = {{0, 1, 1, 0, 1, 1, 1, 1, 0, 1}, {0, 1, 0, 0, 0, 0, 1, 1, 1, 1},
        {0, 1, 0, 0, 1, 0, 1, 1, 1, 1}, {0, 0, 0, 1, 1, 0, 1, 1, 1, 1},
        {0, 1, 1, 1, 0, 0, 1, 0, 0, 1}, {1, 1, 1, 1, 0, 1, 1, 0, 0, 1},
        {1, 1, 0, 1, 0, 0, 0, 0, 0, 1}, {1, 1, 0, 0, 1, 1, 1, 1, 0, 1},
        {0, 1, 1, 0, 1, 1, 1, 1, 0, 1}, {0, 1, 1, 1, 1, 1, 1, 1, 0, 0}};
    static boolean done = false;
    static Map<Point, List<Point>> map = new LinkedHashMap<Point, List<Point>>();

    public static void main(String[] args) {
        constructMap();
        printMap();
        List<Point> path = findAPath();
        if (path != null) {
            for (Point p : path) {
                log.info(p.x + " " + p.y);
            }
        } else {
            log.info("no paths");
        }
    }

    private static void printMap() {
        for (Point p : map.keySet()) {
            log.info("key=[" + p.x + "," + p.y + "] value=");
            if (map.get(p) != null) {
                for (Point myP : map.get(p)) {
                    log.info("[" + myP.x + "," + myP.y + "]");
                }

            } else {
                log.info("null");
            }
            log.info("");
        }

    }

    private static List<Point> findAPath() {
        List<Point> path = null;
        Point p = null;
        if (contains(new Point(9, 9))) {
            path = new ArrayList<Point>();
            path.add(new Point(9, 9));
            p = findLastStep(new Point(9, 9));
            path.add(p);
            while (p.x != 0 || p.y != 0) {
                p = findLastStep(p);
                path.add(0, p);
            }
        }
        return path;
    }

    private static Point findLastStep(Point tp) {
        for (Point p : map.keySet()) {
            List<Point> steps = map.get(p);
            for (Point sp : steps) {
                if (sp.x == tp.x && sp.y == tp.y) {
                    log.info("last p =[" + p.x + "," + p.y + "]");
                    return p;
                }
            }
        }
        log.error("something is wrong");
        return null;
    }

    private static void constructMap() {
        map.put(new Point(0, 0), null);
        Point p = null;

        while ((p = getPoint()) != null && !done) {
            complete(p);
        }

    }

    private static void complete(Point p) {
        List<Point> steps = getSteps(p);
        List<Point> temp = new ArrayList<Point>();
        map.put(p, steps);
        for (Point myP : steps) {
            if (!contains(myP)) {
                if (myP.x == 9 && myP.y == 9) {
                    done = true;
                }
                map.put(myP, null);
            } else {
                temp.add(myP);
            }
        }
        steps.removeAll(temp);
    }

    private static boolean contains(Point myP) {
        for (Point p : map.keySet()) {
            if (p.x == myP.x && p.y == myP.y) {
                return true;
            }
        }
        return false;
    }

    private static Point getPoint() {
        for (Point p : map.keySet()) {
            if (map.get(p) == null) {
                return p;
            }
        }
        return null;
    }

    private static List<Point> getSteps(Point p) {
        List<Point> steps = new ArrayList<Point>();
        if (p.x < 9 && m[p.x + 1][p.y] == 0) {
            steps.add(new Point(p.x + 1, p.y));
        }
        if (p.x > 0 && m[p.x - 1][p.y] == 0) {
            steps.add(new Point(p.x - 1, p.y));
        }
        if (p.y < 9 && m[p.x][p.y + 1] == 0) {
            steps.add(new Point(p.x, p.y + 1));
        }
        if (p.y > 0 && m[p.x][p.y - 1] == 0) {
            steps.add(new Point(p.x, p.y - 1));
        }
        return steps;
    }


    static public class Point {
        private final int x, y;

        public Point(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }
}
