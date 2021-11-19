/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author conne
 */
public class MoodList {
    private ArrayList<Mood> moodList;


    public MoodList(ArrayList<Mood> moodList){
        this.moodList = moodList;

    }
    public MoodList(){
        testMoodList();
    }

    public void addMood(int month, int day, int year, int inputColor){
        Mood m = new Mood(month, day, year, inputColor);
        moodList.add(m);
    }
    public void editMood(int currentIndex, int month, int day, int year, int inputColor){
        moodList.set(currentIndex, new Mood(month, day, year, inputColor));

    }
    public void deleteMood(int currentIndex){
        Mood m = getMoodList().get(currentIndex);
        moodList.remove(m);
    }
    public ArrayList testMoodList(){
        Mood m0 = new Mood(9, 1, 2021, 1);
        Mood m1 = new Mood(9, 2, 2021, 0);
        Mood m2 = new Mood(9, 3, 2021, 2);
        Mood m3 = new Mood(9, 4, 2021, 2);
        Mood m4 = new Mood(9, 5, 2021, 2);
        Mood m5 = new Mood(9, 6, 2021, 0);
        Mood m6 = new Mood(9, 7, 2021, 1);
        Mood m7 = new Mood(9, 8, 2021, 1);
        Mood m8 = new Mood(9, 9, 2021, 2);
        Mood m9 = new Mood(9, 10, 2021, 2);
        Mood m10 = new Mood(9, 11, 2021, 2);
        Mood m11 = new Mood(9, 12, 2021, 2);
        Mood m12 = new Mood(9, 13, 2021, 2);
        Mood m13 = new Mood(9, 14, 2021, 0);
        Mood m14 = new Mood(9, 15, 2021, 0);
        Mood m15 = new Mood(9, 16, 2021, 1);
        Mood m16 = new Mood(9, 17, 2021, 2);
        Mood m17 = new Mood(9, 18, 2021, 2);
        Mood m18 = new Mood(9, 19, 2021, 2);
        Mood m19= new Mood(9, 20, 2021, 2);
        Mood m20 = new Mood(9, 21, 2021, 2);
        moodList.add(m0);
        moodList.add(m1);
        moodList.add(m2);
        moodList.add(m3);
        moodList.add(m4);
        moodList.add(m5);
        moodList.add(m6);
        moodList.add(m7);
        moodList.add(m8);
        moodList.add(m9);
        moodList.add(m10);
        moodList.add(m11);
        moodList.add(m12);
        moodList.add(m13);
        moodList.add(m14);
        moodList.add(m15);
        moodList.add(m16);
        moodList.add(m17);
        moodList.add(m18);
        moodList.add(m19);
        moodList.add(m20);

        return moodList;
    }

    /**
     * @return the moodList
     */
    public ArrayList<Mood> getMoodList() {
        return moodList;
    }
}