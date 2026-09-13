package com.questforge.builder;

import com.questforge.exception.InvalidQuestException;
import com.questforge.model.Quest;
import  com.questforge.model.QuestType;
import com.questforge.model.Reward;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractQuestBuilder implements QuestBuilder {
    protected String title;
    protected String description;
    protected String location;
    protected int requiredLevel;
    protected int timeLimitMinutes;
    protected boolean repeatable;
    protected final List<String> objectives = new ArrayList<>();
    protected final List<Reward> rewards = new ArrayList<>();

    @Override
    public QuestBuilder setTitle(String title){
        this.title = title;
        return this;
    }
    @Override
    public QuestBuilder setDescription(String description){
        this.description = description;
        return this;
    }
    @Override
    public QuestBuilder setLocation(String location){
        this.location = location;
        return this;
    }

    @Override
    public QuestBuilder setTimeLimitMinutes(int minutes){
        if(minutes < 0){
            throw new IllegalArgumentException("Time limit can not be negative");
        }
        this.timeLimitMinutes = minutes;
        return this;
    }

    @Override
    public QuestBuilder addObjective(String objective){
        if (objective == null || objective.isBlank()){
            throw new IllegalArgumentException("Obsective must not be blank");
        }
        this.objectives.add(objective);
        return this;
    }

    @Override
    public QuestBuilder addReward(Reward reward){
        if (reward == null){
            throw new IllegalArgumentException("Reward must not be null");
        }
        this.rewards.add(reward);
        return this;
    }

    @Override
    public QuestBuilder setRepeatable(boolean repeatable){
        this.repeatable = repeatable;
        return this;
    }

    @Override
    public final Quest build(){
        validateCommonState();
        validateSpecificState();
        return new Quest(title, description, getQuestType(), objectives, rewards, requiredLevel,
                location, timeLimitMinutes,repeatable);
    }

    private void validateCommonState(){
        if(title == null || title.isBlank()){
            throw new InvalidQuestException("Quest title is required");
        }
        if (description == null || description.isBlank()){
            throw new InvalidQuestException("Quest description is required");
        }
        if(location == null || location.isBlank()){
            throw new InvalidQuestException("Quest location is required");
        }
        if(objectives.isEmpty()){
            throw new InvalidQuestException("Quest must have at least one objective");
        }
        if (rewards.isEmpty()){
            throw new InvalidQuestException("Quest must have at leats one reward");
        }
    }
    protected abstract QuestType getQuestType();
    protected abstract void validateSpecificState();
}
