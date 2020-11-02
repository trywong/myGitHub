package com.wc.pattern.state;

/**
 * 恶意刷票
 * @author shovel
 * @date 2018/10/22 15:28
 * @since 1.0.0
 */
public class AttackVote implements VoteState {
    @Override
    public void vote(String voter, String voteItem, VoteManager manager) {
        System.out.println("恶意刷票，取消资格");
        manager.removeVote(voter);
    }
}
