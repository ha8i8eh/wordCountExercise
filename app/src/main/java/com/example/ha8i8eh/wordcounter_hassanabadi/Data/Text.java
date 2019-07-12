
package com.example.ha8i8eh.wordcounter_hassanabadi.Data;

import com.google.gson.annotations.SerializedName;


public class Text {

    @SerializedName("text")
    private String mText;

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

}
