package com.zz.bean;

import java.util.ArrayList;

public class RouteMsg {
    private Route route;
    private ArrayList<RouteImg> routeImg;
    private Favorite favorite;
    private Seller seller;
    private User user;
    private Category category;

    public RouteMsg() {
    }

    public RouteMsg(Route route, ArrayList<RouteImg> routeImg, Favorite favorite, Seller seller, User user, Category category) {
        this.route = route;
        this.routeImg = routeImg;
        this.favorite = favorite;
        this.seller = seller;
        this.user = user;
        this.category = category;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public ArrayList<RouteImg> getRouteImg() {
        return routeImg;
    }

    public void setRouteImg(ArrayList<RouteImg> routeImg) {
        this.routeImg = routeImg;
    }

    public Favorite getFavorite() {
        return favorite;
    }

    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
