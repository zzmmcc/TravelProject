package com.zz.bean;

public class RouteMsg {
    private Route route;
    private RouteImg routeImg;
    private Favorite favorite;
    private Seller seller;
    private User user;

    public RouteMsg() {
    }

    public RouteMsg(Route route, RouteImg routeImg, Favorite favorite, Seller seller, User user) {
        this.route = route;
        this.routeImg = routeImg;
        this.favorite = favorite;
        this.seller = seller;
        this.user = user;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public RouteImg getRouteImg() {
        return routeImg;
    }

    public void setRouteImg(RouteImg routeImg) {
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
}
