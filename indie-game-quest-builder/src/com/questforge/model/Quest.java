package com.questforge.model;

import java.util.Collections;
import java.util.List;

public final class Quest {
    private final String title;
    private final String description;
    private final QuestType type;
    private final List<String> objectives;
    private final List<Reward> rewards;
    private final int requiredLevel;
    private final String location;
    private final int timeLimitMinutes;
    private final boolean repeatable;

    public Quest(String title,
                 String description,
                 QuestType type,
                 List<String> objectives,
                 List<Reward> rewards,
                 int requiredLevel,
                 String location,
                 int timeLimitMinutes,
                 boolean repeatable){
        this.title = title;
        this.description = description;
        this.type = type;
        this.objectives = List.copyOf(objectives);
        this.rewards = List.copyOf(rewards);
        this.requiredLevel = requiredLevel;
        this.location = location;
        this.timeLimitMinutes = timeLimitMinutes;
        this.repeatable = repeatable;
    }

    public String getTitle(){ return title;}
    public String  getDescription(){return description;}
    public QuestType getType(){return type;}
    public List<String> getObjectives(){return Collections.unmodifiableList(objectives);}
    public List<Reward> getRewards() {return Collections.unmodifiableList(rewards);}
    public int getRequiredLevel(){return requiredLevel;}
    public String getLocation(){return location;}
    public int getTimeLimitMinutes(){ return timeLimitMinutes;}
    public boolean isRepeatable(){return repeatable;}

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(type).append(": ").append(title).append(" ===\n");
        sb.append("Description : ").append(description).append("\n");
        sb.append("Location    : ").append(location).append("\n");
        sb.append("Min. level  : ").append(requiredLevel).append("\n");
        sb.append("Time limit  : ").append(timeLimitMinutes == 0 ? "none" : timeLimitMinutes + " min").append("\n");
        sb.append("Repeatable  : ").append(repeatable).append("\n");
        sb.append("Objectives  :\n");
        for (String obj : objectives){
            sb.append("  - ").append(obj).append("\n");
        }
        return sb.toString();
    }
}
