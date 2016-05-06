/**
 * 
 */
package com.github.alexsash.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

/**
 * @author Alex
 *
 */
@AutoProperty
public class CommentUser {

    @JsonProperty
    private String date;
    
    @JsonProperty
    private Double rating;
    
    @JsonProperty
    private String userName;
    
    @JsonProperty
    private String comment;
    
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override public boolean equals(Object o) {
      return Pojomatic.equals(this, o);
    }

    @Override public int hashCode() {
      return Pojomatic.hashCode(this);
    }

    @Override public String toString() {
      return Pojomatic.toString(this);
    }
    
}
