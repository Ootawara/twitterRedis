package services;

import bean.Tweet;

import java.util.List;

/**
 * Created by tamiand on 21/04/2015.
 */
public interface TimelineService {

    public List<Tweet> getTimeLine(String userName);
}
