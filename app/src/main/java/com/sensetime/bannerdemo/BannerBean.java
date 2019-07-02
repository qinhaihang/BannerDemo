package com.sensetime.bannerdemo;

/**
 * @author qinhaihang_vendor
 * @version $Rev$
 * @time 2019/7/2 19:25
 * @des
 * @packgename com.sensetime.bannerdemo
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes
 */
public class BannerBean {

    private long showTime;

    private int image;

    public BannerBean(long showTime, int image) {
        this.showTime = showTime;
        this.image = image;
    }

    public long getShowTime() {
        return showTime;
    }

    public void setShowTime(long showTime) {
        this.showTime = showTime;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
