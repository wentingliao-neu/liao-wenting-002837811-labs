/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics;

/**
 *
 * @author harshalneelkamal
 */

import data.DataStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.*;


public class AnalysisHelper {
    //Find Average number of likes per comment.
    //TODO
    public void getAverageLikesPerComments() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likeNumber = 0;
        int commentNumber = comments.size();
        for (Comment c : comments.values()) {
            likeNumber += c.getLikes();
        }
        
        System.out.println("Average number of likes per comments: " + likeNumber / commentNumber);
        System.out.println();
            
    }
   public void getMaxLikeCommentPost(){
       DataStore data=DataStore.getInstance();
       Comment commentWithMaxLikes=null;
       for(Comment c:data.getComments().values()){
           if(commentWithMaxLikes==null)
               commentWithMaxLikes=c;
           if(c.getLikes()>commentWithMaxLikes.getLikes())
               commentWithMaxLikes=c;
       }
       
       int postId=commentWithMaxLikes.getPostId();
       System.out.println("post with most likes per comments: " + data.getPosts().get(postId).getPostId()); 
       System.out.println();
   }
   
   public void getMostCommentPost(){
        DataStore data=DataStore.getInstance();
       Post postMostComments=null;
       for(Post p:data.getPosts().values()){
           if(postMostComments==null)
               postMostComments=p;
           if(p.getComments().size()>postMostComments.getComments().size())
               postMostComments=p;
       }
       System.out.println("post with most comments: " + postMostComments.getPostId());
       System.out.println();
   }
   
   public void getTop5UserPosts(){
        DataStore data=DataStore.getInstance();
        HashMap<Integer,Integer>PostNum=new HashMap<Integer,Integer>();
        ArrayList<User> users=new ArrayList(data.getUsers().values());
        for(User u:users)
              PostNum.put(u.getId(),0);
        for(Post p:data.getPosts().values()){
          int userId=p.getUserId();  
          PostNum.put(userId, PostNum.get(userId)+1);
       } 
        
        Collections.sort(users,Comparator.comparingInt((User user) ->PostNum.get(user.getId())));
        System.out.println("5 inactive users based on posts: ");
        for (int i=0;i<5;i++)
            System.out.println(users.get(i).getId()+" Posts:"+PostNum.get(users.get(i).getId()));
        System.out.println();
//        Collections.sort(users,new UserMapComparator(PostNum));
//        System.out.println("5 inactive users based on posts: ");
//        for (int i=0;i<5;i++)
//            System.out.println(users.get(i).getId()+" Posts:"+PostNum.get(users.get(i).getId()));
   }
    
   public void getTop5UsersComments(){
       DataStore data=DataStore.getInstance();
       ArrayList<User> users=new ArrayList(data.getUsers().values());
       Collections.sort((List) users,Comparator.comparingInt((User user) ->user.getComments().size()));
       System.out.println("5 inactive users based on comments: ");
       for (int i=0;i<5;i++) 
           System.out.println(users.get(i).getId()+" Comment Number:"+users.get(i).getComments().size());
       System.out.println();
   }
   
   public void getTop5User(){
       DataStore data=DataStore.getInstance();
       ArrayList<User> users=new ArrayList(data.getUsers().values());
       HashMap<Integer,Integer>overallNum=new HashMap<Integer,Integer>();
       
       for(User u:users) 
           overallNum.put(u.getId(), u.getComments().size());        
       for(Post p:data.getPosts().values())    
           overallNum.put(p.getUserId(), overallNum.get(p.getUserId())+1);
          
       for(Comment c:data.getComments().values()) 
           overallNum.put(c.getUserId(), overallNum.get(c.getUserId())+c.getLikes());
       
        Collections.sort(users,Comparator.comparingInt((User user) ->overallNum.get(user.getId())));
        System.out.println("5 inactive users based on comments, posts and liked comments: ");
        for (int i=0;i<5;i++) 
            System.out.println(users.get(i).getId()+" overall indication:"+overallNum.get(users.get(i).getId()));
        System.out.println(); 
        System.out.println("5 proactive users based on comments, posts and liked comments: ");
        for (int i=0;i<5;i++) 
            System.out.println(users.get(users.size()-i-1).getId()+" overall indication:"+overallNum.get(users.get(users.size()-i-1).getId()));
   }
}
