package com.wc.pattern.state;

/**
 * 抽象状态
 * @author shovel
 * @date 2018/10/22 15:20
 * @since 1.0.0
 */
public interface VoteState {
    public void vote(String voter, String voteItem, VoteManager manager);
}
