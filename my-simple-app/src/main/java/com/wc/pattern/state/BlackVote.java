package com.wc.pattern.state;

/**
 * 黑名单
 * @author shovel
 * @date 2018/10/22 15:29
 * @since 1.0.0
 */
public class BlackVote implements VoteState {
    @Override
    public void vote(String voter, String voteItem, VoteManager manager) {
        System.out.println("无限刷票，进入黑名单");
    }
}
