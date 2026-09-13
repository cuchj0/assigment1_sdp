package com.questforge.builder;

import com.questforge.model.Quest;
import com.questforge.model.Reward;

public interface QuestBuilder {
    QuestBuilder setTitle(String title);
    QuestBuilder setDescription(String description);
    QuestBuilder setLocation(String location);
    QuestBuilder setRequiredLevel(int level);
    QuestBuilder setTimeLimitMinutes(int minutes);
    QuestBuilder addObjective(String objective);
    QuestBuilder addReward(Reward reward);
    QuestBuilder setRepeatable (boolean repeatable);

    Quest build();
}
