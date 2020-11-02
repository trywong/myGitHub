package com.wc.pattern.state;

/**
 * @author shovel
 * @date 2018/10/22 15:21
 * @since 1.0.0
 */
public class NormalVote implements VoteState {
    @Override
    public void vote(String voter, String voteItem, VoteManager manager) {
        System.out.println("恭喜投票成功");
    }
}
