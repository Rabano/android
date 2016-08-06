package org.ronaldomartinez.v_waiter.lib;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by Ronaldo on 05/07/2016.
 */
public class GladeImageLoader implements ImageLoader {

    private RequestManager requestManager;

    public GladeImageLoader(Context context) {
        this.requestManager = Glide.with(context);
    }

    @Override
    public void load(ImageView imgAvatar, String url) {
        requestManager.load(url).into(imgAvatar);
    }
}
