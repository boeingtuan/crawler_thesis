package com.bk.thesis.reviewcrawler.handler;

import com.bk.thesis.data.thrift.TRawReview;

/**
 *
 * @author boeingtuan
 */
public interface IReviewHandler {

    public void handlerReview(TRawReview rawReview);
}
