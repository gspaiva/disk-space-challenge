package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<List<Integer>> getGroups(int x, List<Integer> space){

        List<List<Integer>> groups = new ArrayList<>();
        int n = space.size();

        for(int i = 0 ; i < n ; i++){
            List<Integer> group = new ArrayList<>();
            int k = i; int count = 0;
            while(count < x && k < n){
                group.add(space.get(k));
                k++;
                count++;
            }
            groups.add(group);
        }

        return groups.stream().filter(group -> group.size() == x).collect(Collectors.toList());
    }

    public static List<Integer> getMinimumGroup(List<List<Integer>> groups){
        List<Integer> minimumGroup = new ArrayList<>();
        for(List<Integer> group : groups){
            minimumGroup.add(getMinimiumValueOfAGroup(group));
        }
        return minimumGroup;
    }

    public static Integer getMinimiumValueOfAGroup(List<Integer> group){
        int min = group.get(0);
        for(int i = 0; i < group.size(); i++){
            if(min > group.get(i)){
                min = group.get(i);
            }
        }
        return min;
    }

    public static int getMax(List<Integer> minimumGroup){
        int max = minimumGroup.get(0);
        for(int i = 0; i < minimumGroup.size(); i++){
            if(max < minimumGroup.get(i)){
                max = minimumGroup.get(i);
            }
        }
        return max;
    }

    public static int segment(int x, List<Integer> space){
        return getMax(getMinimumGroup(getGroups(x, space)));
    }

    public static void main(String[] args) {
        System.out.println(segment(2, Arrays.asList(1,1,1)));
    }
}
