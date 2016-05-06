/**
 * 
 */
package com.github.alexsash.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.github.alexsash.model.CommentUser;

/**
 * @author Alex
 * 
 */
public class Parser {

    private String url;
    private Properties prop;
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Parser() {

    }
    
    public Parser(String url, Properties prop) {
        this.url = url;
        this.prop = prop;
    }
    
    public List<CommentUser> htmlParse() throws IOException {
        Document doc = Jsoup.connect(url).validateTLSCertificates(false).get();
        Elements commentPart = doc.select(prop.getProperty("div-comments"));
        Elements content = commentPart.select(prop.getProperty("content"));
        List<CommentUser> commentUsers = new ArrayList<CommentUser>();
        for (Element element : content) {
                CommentUser user = new CommentUser();
                user.setDate(element.select(prop.getProperty("date")).text());
                Elements summary = element.select(prop.getProperty("summary"));
                for (Element elem : summary) {
                    user.setUserName(elem.select(prop.getProperty("user")).text());
                    user.setRating(Double.valueOf(elem.select(prop.getProperty("raiting")).text()));
                }
                user.setComment(element.select(prop.getProperty("text")).text());
                commentUsers.add(user);                
        }
        return commentUsers;
    }

}
