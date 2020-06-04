package com.crc.baitsplusdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author crc
 * @since 2020-06-03
 */
@TableName("movie")
public class Movie extends Model<Movie> {

    private static final long serialVersionUID=1L;

    private String id;

    private String directors;

    private String title;

    private String cover;

    private String rate;

    private String casts;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCasts() {
        return casts;
    }

    public void setCasts(String casts) {
        this.casts = casts;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Movie{" +
        "id=" + id +
        ", directors=" + directors +
        ", title=" + title +
        ", cover=" + cover +
        ", rate=" + rate +
        ", casts=" + casts +
        "}";
    }
}
