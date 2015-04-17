package testTasks.AgileEngine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;


public class ImageComparatorTest {
    private static final double DIFFERENCE = 1./10;//255*255*255 / 10; //10%
    private static final String IMAGE_1_TEST_1 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\input\\image_1.png";
    private static final String IMAGE_2_TEST_1 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\input\\image_2.png";
    private static final String RESULT_TEST_1 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\output\\test_1";
    private static final String RESULT_TEST_2 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\output\\test_2";
    private static final String IMAGE_1_TEST_2 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\input\\Screenshot_1.png";
    private static final String IMAGE_2_TEST_2 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\input\\Screenshot_2.png";
    private static final String RESULT_TEST_3 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\output\\test_3";
    private static final String RESULT_TEST_4 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\output\\test_4";
    private static final String RESULT_TEST_5 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\output\\test_5";

    class Rectangle {
        int x0;
        int y0;
        int x;
        int y;

        public Rectangle(int x0, int y0, int x, int y) {
            this.x0 = x0;
            this.y0 = y0;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x0 +
                    ", " + y0 +
                    ")--(" + x +
                    ", " + y +
                    ')';
        }

        public int getWidth() {
            return x - x0;
        }
        public int getHeight() {
            return y - y0;
        }
    }
    public static void main(String[] args) {
        try {
            ImageComparatorTest test = new ImageComparatorTest();
            //test 1 -- must be egual
            System.out.println("test 1");
            test.compareImages(IMAGE_1_TEST_1, IMAGE_1_TEST_1, RESULT_TEST_1);
            //test 2 -- must be not egual -- two "lines"
            System.out.println("test 2");
            test.compareImages(IMAGE_1_TEST_1, IMAGE_2_TEST_1, RESULT_TEST_2);
            //test 3 -- must be egual
            System.out.println("test 3");
            test.compareImages(IMAGE_1_TEST_2, IMAGE_1_TEST_2, RESULT_TEST_3);
            //test 4 -- must be not egual
            System.out.println("test 4");
            test.compareImages(IMAGE_1_TEST_2, IMAGE_2_TEST_2, RESULT_TEST_4);
            //test 5 -- must be not egual
            System.out.println("test 5");
            test.compareImages(IMAGE_2_TEST_2, IMAGE_1_TEST_2, RESULT_TEST_5);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void compareImages(String Image_1, String Image_2, String Image_result) throws IOException {


        BufferedImage image1 = ImageIO.read(new File(Image_1));
        BufferedImage image2 = ImageIO.read(new File(Image_2));

        boolean isSame = true;
        Raster r1 = image1.getData();
        DataBuffer db1 = r1.getDataBuffer();
        int size1 = db1.getSize();
        Raster r2 = image2.getData();
        DataBuffer db2 = r2.getDataBuffer();
        int size2 = db2.getSize();
        int w = image1.getWidth();
        int h = image1.getHeight();
        //result -- basics on image1
        BufferedImage resultImageOnlyChanges = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);//ImageIO.read(new File(Image_1));
        Graphics resultGraphics = resultImageOnlyChanges.getGraphics();
        resultGraphics.setColor(Color.WHITE);
        resultGraphics.fillRect(0,0,w,h);

        BufferedImage resultImage = ImageIO.read(new File(Image_1));
        Graphics g = resultImage.getGraphics();

        byte[][] resultArr = new byte[w][h];
        int size = getMin(size1, size2);
        System.out.println("compare two images");
        System.out.println("image1. size=" + size1 + ", w=" + w + ",h=" + h);
        System.out.println("image2. size=" + size2 + ", w=" + image2.getWidth() + ",h=" + image2.getHeight());
        //compare two images
        for (int i = 0; i < getMin(w, image2.getWidth()); i++ ) {
            for (int j = 0; j < getMin(h, image2.getHeight()); j++) {
                if (ExistsDifference(image1.getRGB(i, j), image2.getRGB(i,j))) {
                        isSame = false;
                    resultImageOnlyChanges.setRGB(i, j, 0);
                    resultImage.setRGB(i, j, 0);
                    resultArr[i][j] = 1;
                }
            }
        }
        if (size1 != size2) {
            isSame = false;
            if (size < size1){
                //fill rest of image by black
                for  (int i = getMin(w, image2.getWidth()); i < w; i++ ) {
                    for  (int j = getMin(h, image2.getHeight()); i < h; i++ ) {
                        resultImageOnlyChanges.setRGB(i, j, 0 );
                        resultArr[i][j] = 1;
                    }
                }
            }
        }
        System.out.println("analize changes");
        //calc "red" rectangles
        HashSet<Rectangle> rectangles = new HashSet<>();
        Rectangle curRectangle;
        for (int i = 0; i < w; i++){
            for (int j = 0; j < h; j++){
                if (resultArr[i][j] == 1) {
                    resultArr[i][j] = 3;
                    System.out.println("difference point: (" + i + ", " + j + ")");
                    //initial rectangle
                    curRectangle = new Rectangle(getMinCoordinate(i),getMinCoordinate(j),
                            getMaxCoordinate(w, i), getMaxCoordinate(h, j));
                    //check borders
                    System.out.println("check borders");
                    checkBorders(curRectangle, resultArr, w);
                    System.out.println("total border: " + curRectangle);
                    rectangles.add(curRectangle);
                }
            }
        }
        System.out.println("create result");
        //create result
        if (rectangles.size() != 0) {
            System.out.println("count of rectangles: " + rectangles.size());
            for (Rectangle rectangle :rectangles){
                g.setColor(Color.red);
                g.drawRect(rectangle.x0, rectangle.y0,
                        rectangle.getWidth(), rectangle.getHeight());
            }

        }
        //total output
        System.out.println(isSame ? "Both Images are the same" : "Images have differences");
        ImageIO.write(resultImageOnlyChanges, "png", new File(Image_result + "_only_changes.png"));
        ImageIO.write(resultImage, "png", new File(Image_result + "_with_marked_zones.png"));
    }

    /**
     * calc is exists % of difference between pixels a
     * and b (according to DIFFERENCE d, 0 < d < 1
     * @param a -- first pixel
     * @param b -- second pixel
     * @return true if exists difference more than DIFFERENCE
     * and false if there is no difference (or difference is small)
     */
    private boolean ExistsDifference(int a, int b) {
        double q1 = (double) Math.abs((a-b)/a); //compare a to b
        double q2 = (double) Math.abs((a-b)/b); //compare b to a
        return q1 > DIFFERENCE || q2 > DIFFERENCE;
    }

    private void checkBorders(Rectangle curRectangle, byte[][] resultArr, int w) {
        boolean IsFullRectangle = false;
        boolean IsBreaked = false;
        while (!IsFullRectangle) {
            for (int ii = curRectangle.x0; ii <= curRectangle.x; ii++) {
                for (int jj = curRectangle.y0; jj <= curRectangle.y; jj++) {
                    if (resultArr[ii][jj] == 1) {
                        resultArr[ii][jj] = 3;
                        System.out.println("difference point: (" + ii + ", " + jj + ")");
                        if (ii == curRectangle.x0
                                || jj == curRectangle.y0
                                || ii == curRectangle.x
                                || jj == curRectangle.y) {
                            curRectangle.x0 = ii == curRectangle.x0 ? getMinCoordinate(ii) : curRectangle.x0;
                            curRectangle.y0 = jj == curRectangle.y0 ? getMinCoordinate(jj) : curRectangle.y0;
                            curRectangle.x = ii == curRectangle.x ? getMaxCoordinate(w, ii) : curRectangle.x;
                            curRectangle.y = jj == curRectangle.y ? getMaxCoordinate(w, jj) : curRectangle.y;
                            IsBreaked = true;
                            break; //to begin
                        }
                    }
                }
                if (IsBreaked){
                    break;
                }
            }
            if (IsBreaked){
                IsBreaked = false;
            } else {
                IsFullRectangle = true;
            }
        }
    }

    private static int getMaxCoordinate(int w, int i) {
        return i + 1 > w ? i : i + 1;
    }

    private static int getMinCoordinate(int i) {
        return i - 1 < 0 ? i : i - 1;
    }

    private static int getMin(int size1, int size2) {
        return size1 < size2 ? size1 : size2;
    }
}
