/**
 * 
 */
package com.github.alexsash.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.github.alexsash.helper.Parser;
import com.github.alexsash.model.CommentUser;

/**
 * @author Alex
 *
 */
public class Application {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream inputStream = Application.class.getClassLoader().getResourceAsStream("parser.properties");
        try {
            properties.load(inputStream);
            Parser parser = new Parser("https://funtime.kiev.ua/escape-quests/elementarno/sherlok-holms", properties);
            List<CommentUser> commentUsers = parser.htmlParse();
            for (CommentUser commentUser : commentUsers) {
                System.out.println(commentUser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
