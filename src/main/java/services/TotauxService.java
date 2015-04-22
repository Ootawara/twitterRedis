package services;

/**
 * Created by tamiand on 21/04/2015.
 */
public interface TotauxService{

    public int totalFollowers(String userName);
    public int totalFollowings(String userName);
    public int totalTweet(String userName);
}
