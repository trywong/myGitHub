package com.wc.pattern.state;

import java.util.HashMap;
import java.util.Map;

/**
 * 投票管理器
 *
 * @author shovel
 * @date 2018/10/22 15:22
 * @since 1.0.0
 */
public class VoteManager {
    private Map<String, String> voteMap = new HashMap<>();
    private Map<String, Integer> voteCountMap = new HashMap<>();
    private VoteState state;

    public void vote(String voter, String voteItem) {
        voteMap.put(voter, voteItem);
        Integer count = voteCountMap.get(voter);
        if (count == null) {
            count = 0;
        }
        count++;

        voteCountMap.put(voter, count);

        if (count <= 1) {
            state = new NormalVote();
        } else if (count > 1 && count <= 5) {
            state = new RepeatVote();
        } else if (count > 5 && count <= 8) {
            state = new AttackVote();
        } else if (count > 8) {
            state = new BlackVote();
        }

        state.vote(voter, voteItem, this);
    }

    public void removeVote(String voter) {
        voteMap.remove(voter);
    }

    public Map<String, String> getVoteMap() {
        return voteMap;
    }

    public void setVoteMap(Map<String, String> voteMap) {
        this.voteMap = voteMap;
    }
}
