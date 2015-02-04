package com.hongkailiu.test.app.aaa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Path {


	static int[][] m = { 
			{ 0,    1,    1,    0,    1,    1,    1,    1,    0,    1},
			{ 0,    1,    0,    0,    0,    0,    1,    1,    1,    1},
			{ 0,    1,    0,    0,    1,    0,    1,    1,    1,    1},
			{ 0,    0,    0,    1,    1,    0,    1,    1,    1,    1},
			{ 0,    1,    1,    1,    0,    0,    1,    0,    0,    1},
			{ 1,    1,    1,    1,    0,    1,    1,    0,    0,    1},
			{ 1,    1,    0,    1,    0,    0,    0,    0,    0,    1},
			{ 1,    1,    0,    0,    1,    1,    1,    1,    0,    1},
			{ 0,    1,    1,    0,    1,    1,    1,    1,    0,    1},
			{ 0,    1,    1,    1,    1,    1,    1,    1,    0,    0}
		};
	
	public static void main(String[] args) {
		constructMap();
		printMap();
		List<Point> path = findAPath();
		if (path!=null) {
			for (Point p : path) {
				System.out.println(p.x + " " + p.y);
			}
		} else {
			System.out.println("no paths");
		}
	}

	private static void printMap() {
		for (Point p : map.keySet()) {
			System.out.print("key=[" + p.x + "," + p.y + "] value=");
			if (map.get(p) != null) {
				for (Point myP : map.get(p)) {
					System.out.print("[" + myP.x + "," + myP.y + "]");
				}

			} else {
				System.out.print("null");
			}
			System.out.println();
		}
		
	}

	private static List<Point> findAPath() {
		List<Point> path = null;
		Point p = null;
		if (contains(new Point(9,9))) {
			path = new ArrayList<Point>();
			path.add(new Point(9,9));
			p = findLastStep(new Point(9,9));
			path.add(p);
			while (p.x!=0 || p.y!=0) {
				p = findLastStep(p);
				path.add(0,p);
			}
		}
		return path;
	}
	
	private static Point findLastStep(Point tp) {
		for (Point p : map.keySet()) {
			ArrayList<Point> steps = map.get(p);
			for (Point sp : steps) {
				if (sp.x==tp.x && sp.y==tp.y) {
					System.out.println("last p =["+ p.x + "," + p.y + "]");
					return p;
				}
			}
		}
		System.out.println("something is wrong");
		return null;
	}

	static boolean done = false;

	private static void constructMap() {
		map.put(new Point(0,0), null);
		Point p = null;
		
		while ((p=getPoint())!=null && !done){
			complete(p);
		}
		
	}

	private static void complete(Point p) {
		ArrayList<Point> steps = getSteps(p);
		ArrayList<Point> temp = new ArrayList<Point>();
		map.put(p, steps);
		for (Point myP : steps) {
			if (!contains(myP)) {
				if (myP.x==9 && myP.y==9) {
					done=true;
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
			if (p.x==myP.x && p.y==myP.y){
				return true;
			}
		}
		return false;
	}

	private static Point getPoint() {
		for (Point p : map.keySet()) {
			if (map.get(p)==null){
				return p;
			}
		}
		return null;
	}

	private static ArrayList<Point> getSteps(Point p) {
		ArrayList<Point> steps = new ArrayList<Point>();
		if (p.x<9 && m[p.x+1][p.y]==0) {
			steps.add(new Point(p.x+1,p.y));
		}
		if (p.x>0 && m[p.x-1][p.y]==0) {
			steps.add(new Point(p.x-1,p.y));
		}
		if (p.y<9 && m[p.x][p.y+1]==0) {
			steps.add(new Point(p.x,p.y+1));
		}
		if (p.y>0 && m[p.x][p.y-1]==0) {
			steps.add(new Point(p.x,p.y-1));
		}
		return steps;
	}

	static public class Point{
		public int x,y;
		public Point(int a, int b){
			this.x = a;
			this.y = b;
		}
	}
	
	static Map<Point, ArrayList<Point>> map = new LinkedHashMap<Point, ArrayList<Point>>();
}
