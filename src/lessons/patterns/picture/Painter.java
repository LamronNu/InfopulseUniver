package lessons.patterns.picture;

import lessons.patterns.picture.figures.Figure;
import org.apache.log4j.Logger;

import java.util.List;

public class Painter  {
    private PictureBuilder pictureBuilder;
    private List<Figure> figuresRest;

    Painter(PictureBuilder pictureBuilder, List<Figure> figures) {
        this.pictureBuilder = pictureBuilder;
        this.figuresRest = pictureBuilder.setFigures(figures);
    }

    public void paint(){
        pictureBuilder.drawRectangles();
        pictureBuilder.drawCircles();
        pictureBuilder.drawTrapezes();
    }
}
