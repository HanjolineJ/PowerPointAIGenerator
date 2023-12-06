/*
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;

import java.awt.Rectangle;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class PowerPointGenerator {

    public void createPresentation(Map<String, String> data) throws IOException {
        XMLSlideShow ppt = new XMLSlideShow();
//use object mapper to get data from json file

        // Create a slide for the "Hello, World!" text box
        XSLFSlide Slide = ppt.createSlide();
        XSLFTextBox textBox = Slide.createTextBox();
        textBox.setText("Hello, World!");
        textBox.setAnchor(new Rectangle(50, 50, 200, 50));

        // Create additional slides for each data element
        createSlideWithText(ppt, data.get("topic"), textBox.setText(data.get("topic")));
        createSlideWithText(ppt, data.get("author"));
        createSlideWithText(ppt, data.get("date"));
        createSlideWithText(ppt, data.get("slides"));
        createSlideWithText(ppt, data.get("audience"));

        // Save the PowerPoint to a file
        FileOutputStream out = new FileOutputStream("presentation.pptx");
        ppt.write(out);
        out.close();
    }

    private void createSlideWithText(XMLSlideShow ppt, String text) {
        XSLFSlide slide = ppt.createSlide();
        XSLFTextBox textBox = slide.createTextBox();
        textBox.setText(text);
        textBox.setAnchor(new Rectangle(50, 50, 400, 50));
    }
}

*/