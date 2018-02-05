package com.mk.imgur.uploder.unsplash;

/**
 * Created by mk on 02.02.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User
{
    @SerializedName("id") @Expose private String id;
    @SerializedName("updated_at") @Expose private String updatedAt;
    @SerializedName("username") @Expose private String username;
    @SerializedName("name") @Expose private String name;
    @SerializedName("first_name") @Expose private String firstName;
    @SerializedName("last_name") @Expose private String lastName;
    @SerializedName("twitter_username") @Expose private Object twitterUsername;
    @SerializedName("portfolio_url") @Expose private Object portfolioUrl;
    @SerializedName("bio") @Expose private Object bio;
    @SerializedName("location") @Expose private String location;
    @SerializedName("total_collections") @Expose private Integer totalCollections;
    @SerializedName("total_likes") @Expose private Integer totalLikes;
    @SerializedName("total_photos") @Expose private Integer totalPhotos;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Object getTwitterUsername()
    {
        return twitterUsername;
    }

    public void setTwitterUsername(Object twitterUsername)
    {
        this.twitterUsername = twitterUsername;
    }

    public Object getPortfolioUrl()
    {
        return portfolioUrl;
    }

    public void setPortfolioUrl(Object portfolioUrl)
    {
        this.portfolioUrl = portfolioUrl;
    }

    public Object getBio()
    {
        return bio;
    }

    public void setBio(Object bio)
    {
        this.bio = bio;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Integer getTotalCollections()
    {
        return totalCollections;
    }

    public void setTotalCollections(Integer totalCollections)
    {
        this.totalCollections = totalCollections;
    }

    public Integer getTotalLikes()
    {
        return totalLikes;
    }

    public void setTotalLikes(Integer totalLikes)
    {
        this.totalLikes = totalLikes;
    }

    public Integer getTotalPhotos()
    {
        return totalPhotos;
    }

    public void setTotalPhotos(Integer totalPhotos)
    {
        this.totalPhotos = totalPhotos;
    }

}
