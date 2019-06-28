package fr.epita.android.mealdbapp;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

    private String id;
    private String categoryName;
    private String categoryThumb;
    private String categoryDesc;

    public static List<Categorie> listCat = new ArrayList<Categorie>();
    public Categorie()
    {


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String category) {
        this.categoryName = category;
    }

    public String getCategoryThumb() {
        return categoryThumb;
    }

    public void setCategoryThumb(String categoryThumb) {
        this.categoryThumb = categoryThumb;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }
}
