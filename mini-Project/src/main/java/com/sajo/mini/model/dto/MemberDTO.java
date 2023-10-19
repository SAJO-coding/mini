package com.sajo.mini.model.dto;

public class MemberDTO {
    String userId;
    int level;
    int gold;
    String job;

    public MemberDTO() {
    }

    public MemberDTO(String userId, int level, int gold, String job) {
        this.userId = userId;
        this.level = level;
        this.gold = gold;
        this.job = job;
    }
}
