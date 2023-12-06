import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.*;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class PPTG {

    public void createPresentation(Map<String,String> data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        XMLSlideShow ppt = new XMLSlideShow();

        // Create slides for each data element
        //data.forEach((key, value) -> createSlideWithText(ppt, value));

        String title = AIPrompter.chatGPT("Make a presentation title for this topic: " + data.get("topic"));
        String header = AIPrompter.chatGPT("Make a presentation title for this topic: " + data.get("audience"));
        String down = AIPrompter.chatGPT("Make a presentation title for this topic: " + data.get("slides"));
        String up = AIPrompter.chatGPT("Make a presentation title for this topic: " + data.get("author"));
        String left = AIPrompter.chatGPT("Make a presentation title for this topic: " + data.get("date"));

        String titlebullets = AIPrompter.chatGPT("Make 2 bullet points for this topic: " + data.get("topic"));
        String headerbullets = AIPrompter.chatGPT("Make 2 bullet points for this topic: " + data.get("audience"));
        String downbullets = AIPrompter.chatGPT("Make 2 bullet points for this topic: " + data.get("slides"));
        String upbullets = AIPrompter.chatGPT("Make 2 bullet points for this topic: " + data.get("author"));
        String leftbullets = AIPrompter.chatGPT("Make 2 bullet points for this topic: " + data.get("date"));

        createSlideWithText(ppt, title, titlebullets);
        createSlideWithText(ppt, header, headerbullets);
        createSlideWithText(ppt, down, downbullets);
        createSlideWithText(ppt, up, upbullets);
        createSlideWithText(ppt, left, leftbullets);
        createSlideWithPicture( ppt, "C:\\Users\\Acer Customer\\Downloads\\Computer.jpeg");

        try (FileOutputStream out = new FileOutputStream("presentation.pptx")) {
            ppt.write(out);
        }
    }

    private void createSlideWithPicture(XMLSlideShow ppt, String picture) throws IOException {
        XSLFSlide slide = ppt.createSlide();
        XSLFPictureData pd = ppt.addPicture(new File(picture), PictureData.PictureType.JPEG);

        XSLFPictureShape pic = slide.createPicture(pd);
        pic.setAnchor(new Rectangle(150, 250, 400, 500));
    }
    private void createSlideWithText(XMLSlideShow ppt, String text, String bullets) {
        XSLFSlide slide = ppt.createSlide();
        XSLFTextBox textBox1 = slide.createTextBox();
        XSLFTextBox textBox2 = slide.createTextBox();
        textBox1.setText(text);
        textBox2.setText(bullets);
        textBox1.setAnchor(new Rectangle(50, 50, 400, 50));
        textBox2.setAnchor(new Rectangle(50, 125, 400, 50));

    }

    //private void createSlideWithText(XMLSlideShow ppt, String text) {
      //  XSLFSlide slide = ppt.createSlide();
       // XSLFTextBox textBox = slide.createTextBox();
       // textBox.setText(text);
       // textBox.setAnchor(new Rectangle(50, 50, 400, 50));
        //textBox.setAnchor(new Rectangle(50, 80, 400, 50));
    //}

}
