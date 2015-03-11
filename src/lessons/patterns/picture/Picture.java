package lessons.patterns.picture;

import lessons.patterns.picture.figures.Figure;
import lessons.patterns.picture.figures.Figures;
import lessons.patterns.picture.figures.Point;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Picture {
    public static void main(String[] args) {
        List<Figure> figures = new LinkedList<>();
        FigureFactory factory = new FigureFactory();
        HashMap<String, Point[]> parameters = new HashMap<>();

        //generate figures
        parameters.put("center", new Point[]{new Point(1,2)});
        parameters.put("point", new Point[]{new Point(2,2)});
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        figures.add(factory.getFigure(Figures.CIRCLE, parameters));
        parameters.clear();

        parameters.put("abc", new Point[]{new Point(1, 2), new Point(2, 2), new Point(3, 5)});
        figures.add(factory.getFigure(Figures.TRIANGLE, parameters));
        figures.add(factory.getFigure(Figures.TRIANGLE, parameters));
        parameters.clear();

        parameters.put("ac", new Point[]{new Point(0, 0), new Point(7, 2)});
        figures.add(factory.getFigure(Figures.RECTANGLE, parameters));
        figures.add(factory.getFigure(Figures.RECTANGLE, parameters));
        parameters.clear();

        parameters.put("abcd", new Point[]{new Point(0, 0), new Point(7, 2), new Point(-1, -1), new Point(2, 2)});
        figures.add(factory.getFigure(Figures.TRAPEZE, parameters));
        figures.add(factory.getFigure(Figures.TRAPEZE, parameters));
        parameters.clear();

        PictureBuilder builder = new Picture_3_Builder();
        Painter painter = new Painter(builder, figures);
        painter.paint();
    }
}
