package com.example.assingment4.Dto;

import lombok.*;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    @Generated
   private String id;
    private String title;
    private String name;
   private String publishDate;

    public String SgetId(){
        return (id);
    }
    public int getId(){
        return Integer.parseInt(id);
    }

    public String getTitle() {
        return title;
    }
    public String getName(){
        return name;

    }

    public String getPublishDate() {
        return publishDate;
    }


}
