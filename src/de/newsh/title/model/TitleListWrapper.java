package de.newsh.title.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of titles. This is used for saving the
 * list of persons to JSON.
 */
@XmlRootElement
public class TitleListWrapper {

    private List<Title> titles;

    //@XmlElement(name = "title")
    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }
}