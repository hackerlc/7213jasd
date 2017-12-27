package com.liangke.tcp.event;


import com.liangke.tcp.packet.QuoteRealPushBody;

import java.util.ArrayList;

/**
 * Created by yangcaihao on 16/6/6.
 */
public class QuoteRequestEvent {

    private ArrayList<QuoteRealPushBody> quoteList;
    public QuoteRequestEvent(ArrayList<QuoteRealPushBody> quoteList){
        this.quoteList = quoteList;
    }
    public ArrayList<QuoteRealPushBody> getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(ArrayList<QuoteRealPushBody> quoteList) {
        this.quoteList = quoteList;
    }
}
