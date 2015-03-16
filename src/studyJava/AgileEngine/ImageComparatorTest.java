package studyJava.AgileEngine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class ImageComparatorTest {
    private static final int DIFFERENCE = 255 / 10; //10%
    private static final String IMAGE_1_TEST_1 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\input\\image_1.png";
    private static final String IMAGE_2_TEST_1 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\input\\image_2.png";
    private static final String RESULT_TEST_1 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\output\\test_1.png";
    private static final String RESULT_TEST_2 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\output\\test_2.png";
    private static final String IMAGE_1_TEST_2 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\input\\Screenshot_1.png";
    private static final String IMAGE_2_TEST_2 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\input\\Screenshot_2.png";
    private static final String RESULT_TEST_3 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\output\\test_3.png";
    private static final String RESULT_TEST_4 = "C:\\Users\\Olga\\IdeaProjects\\InfopulseUniver\\src\\studyJava\\AgileEngine\\output\\test_4.png";

    public static void main(String[] args) {
        try {
            //test 1 -- must be egual
            compareImages(IMAGE_1_TEST_1, IMAGE_1_TEST_1, RESULT_TEST_1);
            //test 2 -- must be not egual -- two "lines"
            compareImages(IMAGE_1_TEST_1, IMAGE_2_TEST_1, RESULT_TEST_2);
            //test 1 -- must be egual
            compareImages(IMAGE_1_TEST_2, IMAGE_1_TEST_2, RESULT_TEST_3);
            //test 2 -- must be not egual
            compareImages(IMAGE_1_TEST_2, IMAGE_2_TEST_2, RESULT_TEST_4);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void compareImages(String Image_1, String Image_2, String Image_result) throws IOException {
        BufferedImage image1 = ImageIO.read(new File(Image_1));
        BufferedImage image2 = ImageIO.read(new File(Image_2));

        boolean isSame = true;
        Raster r1 = image1.getData();
        DataBuffer db1 = r1.getDataBuffer();
        int size1 = db1.getSize();
        Raster r2 = image2.getData();
        DataBuffer db2 = r2.getDataBuffer();
        int size2 = db2.getSize();

        //result -- basics on image1
        BufferedImage resultImage = ImageIO.read(new File(Image_1));
        Raster resultRaster = resultImage.getRaster();
        DataBuffer resultDataBuffer = resultRaster.getDataBuffer();

        if (size1 == size2) {
            for (int i = 0; i < size1; i++ ) {
                if (Math.abs(db1.getElem(i) - db2.getElem(i)) >= DIFFERENCE) {
                    isSame = false;
                    resultDataBuffer.setElem(i, 0x00);//black
                } else{
                    resultDataBuffer.setElem(i, 0xff);//white -- by default
                }
            }
        }  else {
            isSame = false;
        }
        System.out.println(isSame ? "Both Images are the same" : "Images have differences");
        ImageIO.write(resultImage, "png", new File(Image_result));
    }
}
