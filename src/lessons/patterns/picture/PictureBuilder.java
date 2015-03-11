package lessons.patterns.picture;

import lessons.patterns.picture.figures.Figure;
import org.apache.log4j.Logger;

import java.util.List;

public interface PictureBuilder {
    //set figures

    /**
     * set material to PictureBuilder
     * @param figures -- list of all figures
     * @return the rest of figures
     */
    List<Figure> setFigures(List<Figure> figures);

    //draw figures
    void drawPoints();
    void drawSegments();
    void drawCircles();
    void drawOvals();
    void drawTriangles();
    void drawRectangles();
    void drawLines();
    void drawTrapezes();

}
