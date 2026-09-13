package com.questforge.builder;

import com.questforge.exception.InvalidQuestException;
import com.questforge.model.QuestType;

public class SideQuestBuilder extends AbstractQuestBuilder {

    private static final int MAX_SIDE_QUEST_LEVEL = 20;
    private static final int MAX_SIDE_QUEST_TIME_LIMIT = 60;

    @Override
    protected QuestType getQuestType() {
        return QuestType.SIDE;
    }

    @Override
    protected void validateSpecificState() {
        if (requiredLevel > MAX_SIDE_QUEST_LEVEL) {
            throw new InvalidQuestException(
                    "Side quest level requirement cannot exceed " + MAX_SIDE_QUEST_LEVEL);
        }
        if (timeLimitMinutes > MAX_SIDE_QUEST_TIME_LIMIT) {
            throw new InvalidQuestException(
                    "Side quest time limit cannot exceed " + MAX_SIDE_QUEST_TIME_LIMIT + " minutes");
        }
    }
}