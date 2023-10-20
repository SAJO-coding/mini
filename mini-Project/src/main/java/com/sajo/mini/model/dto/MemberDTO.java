package com.sajo.mini.model.dto;

public class MemberDTO {
    private String userId;
    private String userJob;
    int userLevel;
    int userGold;

    public MemberDTO() {
    }

    public MemberDTO(String userId, String userJob, int userLevel, int userGold) {
        this.userId = userId;
        this.userJob = userJob;
        this.userLevel = userLevel;
        this.userGold= userGold;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getUserGold() {
        return userGold;
    }

    public void setUserGold(int userGold) {
        this.userGold = userGold;
    }

    @Override
    public String toString() {
        return "Memberdto{" +
                "userId='" + userId + '\'' +
                ", userJob='" + userJob + '\'' +
                ", userLevel=" + userLevel +
                '}';
    }

}
