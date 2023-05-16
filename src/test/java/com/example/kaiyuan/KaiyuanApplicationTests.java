package com.example.kaiyuan;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class KaiyuanApplicationTests {

    @Test
    void contextLoads() {
        File imageFile = new File("D:\\uuuuu.png");
        System.out.println(imageFile.isFile());
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        instance.setDatapath("D:\\tessdata"); // path to tessdata directory

        instance.setLanguage("chi_sim");

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }

}
