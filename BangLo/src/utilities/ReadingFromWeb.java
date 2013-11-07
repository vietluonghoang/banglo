/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author Ad
 */
public class ReadingFromWeb {

    private String sourceUrl = "http://xskt.com.vn/ket-qua-xo-so-theo-ngay/mien-bac-xsmb/";
    private String date = "01-01-2013";

    public ReadingFromWeb(String date) {
        this.date = date;
    }

    public ReadingFromWeb() {
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String[] getResultOfDay() {
        return getResult();
    }

    public String[] getLoOfDay() {
        return getLo();
    }

    public ArrayList<Level> getLevelsOfDay() {
        return getLevels();
    }

    private String getSource() {
        try {
            URL url = new URL(this.sourceUrl + this.date + ".html");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = "";
            String result = "";
            while ((inputLine = in.readLine()) != null) {
                result += inputLine;
            }
            in.close();
            return result;
        } catch (MalformedURLException ex) {

        } catch (IOException ex) {

        }
        return null;
    }

    private String[] getResult() {
        String source = getSource();
        String rawData = "";
        String rawResult = "";
        String result="";
        Pattern pat = Pattern.compile("(?<=(class=\"center-content\"><table))(.*?)(?=</table>)");
        Matcher mat = pat.matcher(source);

        while (mat.find()) {
            rawData += mat.group();
        }
        if (!"".equals(rawData)) {
            Pattern pat1 = Pattern.compile("(?<=(<td class=\"result-prize\">))(.*?)(?=</td>)");
            Matcher mat1 = pat1.matcher(rawData);            
            int order = 0;
            while (mat1.find()) {
                try {
                    rawResult = mat1.group();
                    rawResult = rawResult.replaceAll("<br>", " ");
                    rawResult = rawResult.replace("<em>", "");
                    rawResult = rawResult.replace("</em>", "");
                    Pattern pat2 = Pattern.compile("(?<=(<script type=\"text/javascript\">document.write))(.*?)(?=</script>)");
                    Matcher mat2 = pat2.matcher(rawResult);
                    String value = "";
                    if (mat2.find()) {
                        ScriptEngineManager factory = new ScriptEngineManager();
                        ScriptEngine engine = factory.getEngineByName("JavaScript");
                        value = (String) engine.eval(mat2.group());
                    } else {
                        value = rawResult;
                    }
                    result+=value+" ";
                    order++;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return result.split(" ");
    }

    private ArrayList<Level> getLevels() {
        String source = getSource();
        ArrayList<Level> levels = null;
        Pattern pat = Pattern.compile("(?<=(class=\"center-content\"><table))(.*?)(?=</table>)");
        Matcher mat = pat.matcher(source);

        String rawData = "";
        while (mat.find()) {
            rawData += mat.group();
        }
        if (!"".equals(rawData)) {
            Pattern pat1 = Pattern.compile("(?<=(<td class=\"result-prize\">))(.*?)(?=</td>)");
            Matcher mat1 = pat1.matcher(rawData);
            String rawResult = "";
            levels = new ArrayList<Level>();
            String[] levelNames = {"Giải đặc biệt", "Giải nhất", "Giải nhì", "Giải ba", "Giải tư", "Giải năm", "Giải sáu", "Giải bảy"};
            int order = 0;
            while (mat1.find()) {
                try {
                    rawResult = mat1.group();
                    rawResult = rawResult.replaceAll("<br>", " ");
                    rawResult = rawResult.replace("<em>", "");
                    rawResult = rawResult.replace("</em>", "");
                    Pattern pat2 = Pattern.compile("(?<=(<script type=\"text/javascript\">document.write))(.*?)(?=</script>)");
                    Matcher mat2 = pat2.matcher(rawResult);
                    String value = "";
                    if (mat2.find()) {
                        ScriptEngineManager factory = new ScriptEngineManager();
                        ScriptEngine engine = factory.getEngineByName("JavaScript");
                        value = (String) engine.eval(mat2.group());
                    } else {
                        value = rawResult;
                    }
                    Level level = new Level(levelNames[order], value);
                    levels.add(level);
                    order++;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return levels;
    }

    private String[] getLo() {
        String[] result = getResult();
        String lo = "";
        for (String string : result) {
            lo += string.substring(string.length() - 2, string.length()) + "-";
        }
        return lo.split("-");
    }
}
