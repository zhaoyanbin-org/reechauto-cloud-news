package com.reechauto.cloud.news.entity;

import java.io.Serializable;

/**
* 绿驰汽车
* tableName: news_share
* @author zhaoyb
*/
public class NewsShareWithBLOBs extends NewsShare implements Serializable {

    /**
     * 简介
     */
    private String intro;
    /**
     * 内容
     */
    private String context;
    private String contextTxt;
    /**
     * 逗号分割
     */
    private String imagesUrl;
    private static final long serialVersionUID = 1L;

    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public String getContextTxt() {
        return contextTxt;
    }
    public void setContextTxt(String contextTxt) {
        this.contextTxt = contextTxt;
    }
    public String getImagesUrl() {
        return imagesUrl;
    }
    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }
}