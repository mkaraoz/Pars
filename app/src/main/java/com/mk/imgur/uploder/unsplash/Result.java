package com.mk.imgur.uploder.unsplash;

/**
 * Created by mk on 02.02.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result
{
    @SerializedName("id") @Expose private String id;
    @SerializedName("created_at") @Expose private String createdAt;
    @SerializedName("updated_at") @Expose private String updatedAt;
    @SerializedName("width") @Expose private Integer width;
    @SerializedName("height") @Expose private Integer height;
    @SerializedName("color") @Expose private String color;
    @SerializedName("description") @Expose private Object description;
    @SerializedName("categories") @Expose private List<Object> categories = null;
    @SerializedName("urls") @Expose private Urls urls;
    @SerializedName("links") @Expose private Links links;
    @SerializedName("liked_by_user") @Expose private Boolean likedByUser;
    @SerializedName("sponsored") @Expose private Boolean sponsored;
    @SerializedName("likes") @Expose private Integer likes;
    @SerializedName("user") @Expose private User user;
    @SerializedName("current_user_collections") @Expose private List<Object> currentUserCollections = null;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(String createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public Object getDescription()
    {
        return description;
    }

    public void setDescription(Object description)
    {
        this.description = description;
    }

    public List<Object> getCategories()
    {
        return categories;
    }

    public void setCategories(List<Object> categories)
    {
        this.categories = categories;
    }

    public Urls getUrls()
    {
        return urls;
    }

    public void setUrls(Urls urls)
    {
        this.urls = urls;
    }

    public Links getLinks()
    {
        return links;
    }

    public void setLinks(Links links)
    {
        this.links = links;
    }

    public Boolean getLikedByUser()
    {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser)
    {
        this.likedByUser = likedByUser;
    }

    public Boolean getSponsored()
    {
        return sponsored;
    }

    public void setSponsored(Boolean sponsored)
    {
        this.sponsored = sponsored;
    }

    public Integer getLikes()
    {
        return likes;
    }

    public void setLikes(Integer likes)
    {
        this.likes = likes;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public List<Object> getCurrentUserCollections()
    {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<Object> currentUserCollections)
    {
        this.currentUserCollections = currentUserCollections;
    }
}

