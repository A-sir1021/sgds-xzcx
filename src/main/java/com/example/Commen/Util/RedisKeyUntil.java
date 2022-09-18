package com.example.Commen.Util;

/**
 * Created by tuzhenyu on 17-7-25.
 * @author tuzhenyu
 */
public class RedisKeyUntil {
    private static final String SPLITE = ":";
    private static final String BIZ_LIKE = "LIKE";
    private static final String BIZ_DISLIKE = "DISLIKE";
    private static final String BIZ_ARTICLE = "ARTICLE";
    private static final String BIZ_CATEGORY = "CATEGORY";
    private static final String BIZ_CLICK = "CLICK";
    private static final String BIZ_ARTICLE_CLICK = "ARTICLE_CLICK";
    private static final String BIZ_EVENTQUEUE = "EVENTQUEUE";

    public static String getCategoryKey(String category){
        return BIZ_CATEGORY+SPLITE+category+SPLITE+"COUNT";
    }

    public static String getClickCountKey(String url){
        return BIZ_CLICK+SPLITE+url+SPLITE+"COUNT";
    }

    public static String getArticleClickCountKey(String url){
        return BIZ_ARTICLE_CLICK+SPLITE+url+SPLITE+"COUNT";
    }

    public static String getLikeKey(int articleId){
        return BIZ_LIKE+SPLITE+BIZ_ARTICLE+SPLITE+ articleId;
    }

    public static String getDisLikeKey(int articleId){
        return BIZ_DISLIKE+SPLITE+BIZ_ARTICLE+SPLITE+ articleId;
    }

    public static String getEventQueue(){
        return BIZ_EVENTQUEUE;
    }
}
