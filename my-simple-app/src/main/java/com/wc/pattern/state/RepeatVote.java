package com.wc.pattern.state;

/**
 * @author shovel
 * @date 2018/10/22 15:25
 * @since 1.0.0
 */
public class RepeatVote implements VoteState {
    @Override
    public void vote(String voter, String voteItem, VoteManager manager) {
        System.out.println("重复投票！");
    }
}
