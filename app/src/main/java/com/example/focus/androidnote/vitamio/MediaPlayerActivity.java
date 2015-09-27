package com.example.focus.androidnote.vitamio;

import android.os.Bundle;

import com.example.focus.androidnote.BaseActivity;
import com.example.focus.androidnote.R;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by focus on 15/9/27.
 */
public class MediaPlayerActivity extends BaseActivity{

    private String mPath = "http://k.youku.com/player/getFlvPath/sid/344335417643812f54e30_00/st/mp4/fileid/030020010053AAFFCF0D4013CD3639ABB14EC1-538D-CEBD-A15B-C75BD1BED187?K=2eeb86669d399211282ad2fa&hd=1&myp=0&ts=49&ypp=0&ep=cSaQGUqIUs8H4yfcgD8bMSnmIXQPXP4J9h%2BHgdJjALshS5nO70iisZ3ESv9DFYptcSQFGZqD2dHjHzMVYfVAoRwQrDvaTfqR%2F%2FWR5d5UweJ0Z2tDBszfs1SZRTH4&ctype=12&ev=1&token=7619&oip=1942446199";
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_media_player);

        mVideoView = (VideoView) findViewById(R.id.surface);

        mVideoView.setVideoPath(mPath);
        mVideoView.start();

        MediaController mMediaController = new MediaController(mContext);
        mVideoView.setMediaController(mMediaController);
    }
}
