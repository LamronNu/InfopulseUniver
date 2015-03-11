package lessons.patterns.picture;

import lessons.patterns.picture.figures.*;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class FigureFactory{

    public static final String NO_SUCH_FIGURE = "No such figure!";

    public Figure getFigure(String figureName, HashMap<String, Point[]> parameters){
        return getFigure(Figures.valueOf(figureName), parameters);
    }

    public Figure getFigure(Figures figureName, HashMap<String, Point[]> parameters){
        Figure figure = null;
        switch (figureName){
            case POINT:
                figure = new Point();
                break;
            case SEGMENT:
                figure = new Segment();
                break;
            case CIRCLE:
                figure = new Circle();
                break;
            case TRIANGLE:
                figure = new Triangle();
                break;
            case TRAPEZE:
                figure = new Trapeze();
                break;
            case RECTANGLE:
                figure = new Rectangle();
                break;
            case OVAL:
                figure = new Oval();
                break;
            case LINE:
                figure = new Line();
                break;
            default:
                throw new IllegalArgumentException(NO_SUCH_FIGURE);
        }
        return createFigure(figure, parameters);
    }

    public Figure createFigure(Figure figure, HashMap<String, Point[]> parameters) {
        for (String key : parameters.keySet()){
            figure.setProperty(key, parameters.get(key));
        }
        return figure;
    }
}
