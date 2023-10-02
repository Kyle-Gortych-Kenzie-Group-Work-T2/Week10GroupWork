package com.kenzie.discussion;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.kenzie.discussion.dynamodb.Topic;
import com.kenzie.discussion.dynamodb.TopicMessage;
import com.kenzie.discussion.dynamodb.TopicMessageDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.CharMatcher.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class TopicMessageDaoTest {
    // PARTICIPANTS - add at least one relevant test (remember to mock DynamoDBMapper!)
    // You can use MemberDaoTest as a guide!
@Mock
    private DynamoDBMapper mapper;
    private TopicMessageDao topicMessageDao;
@BeforeEach
        public void setup(){
    initMocks(this);
    topicMessageDao = new TopicMessageDao(mapper);
}

    @Test
    void createTopic_withValidTopic_isSavedAndReturned() {
        // GIVEN
        // topic to be saved
        TopicMessage newTopic = new TopicMessage();
        // DynamoDB accepts it
        doNothing().when(mapper).save(newTopic);

        // WHEN
        TopicMessage result = topicMessageDao.saveTopicMessage(newTopic);

        // THEN
        assertEquals(newTopic, result);
    }



}
