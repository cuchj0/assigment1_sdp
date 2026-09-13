package com.questforge.builder;

import com.questforge.exception.InvalidQuestException;
import com.questforge.model.QuestType;

public class DailyQuestBuilder extends AbstractQuestBuilder {

    private static final int DAILY_TIME_LIMIT_MINUTES = 24 * 60;

    public DailyQuestBuilder() {
        this.repeatable = true;
        this.timeLimitMinutes = DAILY_TIME_LIMIT_MINUTES;
    }

    @Override
    protected QuestType getQuestType() {
        return QuestType.DAILY;
    }

    @Override
    protected void validateSpecificState() {
        if (!repeatable) {
            throw new InvalidQuestException("Daily quest must be repeatable");
        }
        if (timeLimitMinutes != DAILY_TIME_LIMIT_MINUTES) {
            throw new InvalidQuestException(
                    "Daily quest must have a " + DAILY_TIME_LIMIT_MINUTES + "-minute limit");
        }
    }
}