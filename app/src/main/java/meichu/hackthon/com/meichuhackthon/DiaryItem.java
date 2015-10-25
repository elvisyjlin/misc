package meichu.hackthon.com.meichuhackthon;

/**
 * Created by User on 2015/10/24.
 */
public class DiaryItem {

    @com.google.gson.annotations.SerializedName("time")
    private String mTime;

    @com.google.gson.annotations.SerializedName("mood")
    private String mMood;

    @com.google.gson.annotations.SerializedName("location")
    private String mLocation;

    @com.google.gson.annotations.SerializedName("content")
    private String mContent;

    @com.google.gson.annotations.SerializedName("picture")
    private String mPicture;

    @com.google.gson.annotations.SerializedName("mood_description")
    private String mMoodDescription;

    @com.google.gson.annotations.SerializedName("src")
    private String mSrc;

    @com.google.gson.annotations.SerializedName("hashtag")
    private String mHashtag;

    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    @com.google.gson.annotations.SerializedName("useless")
    private String mUseless;

    @com.google.gson.annotations.SerializedName("story")
    private String mStory;

    public String getmTime() {
        return mTime;
    }

    public String getmMood() {
        return mMood;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmContent() {
        return mContent;
    }

    public String getmPicture() {
        return mPicture;
    }

    public String getmMoodDescription() {
        return mMoodDescription;
    }

    public String getmSrc() {
        return mSrc;
    }

    public String getmHashtag() {
        return mHashtag;
    }

    public String getmId() {
        return mId;
    }

    public String getmUseless() {
        return mUseless;
    }

    public String getmStory() {
        return mStory;
    }

    public DiaryItem()
    {

    }

    public DiaryItem(String time, String mood, String location, String content, String picture,
                     String moodDescription, String src, String hashtag, String id,
                     String useless, String story){
        mTime = time;
        mMood = mood;
        mLocation = location;
        mContent = content;
        mPicture = picture;
        mMoodDescription = moodDescription;
        mSrc = src;
        mHashtag = hashtag;
        mId = id;
        mUseless = useless;
        mStory = story;
    }

    @Override
    public String toString()
    {
        return mContent;
    }
}
