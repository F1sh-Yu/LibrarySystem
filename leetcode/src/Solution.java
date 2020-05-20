import java.util.*;

public class Solution {
    public int findTheLongestSubstring(String s) {
        int ans = 0,statu = 0;
        int[] pos = new int[1<<4];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            switch(ch){
                case 'a':
                    statu ^= 1;
                    break;
                case 'e':
                    statu ^= 1<<1;
                    break;
                case 'i':
                    statu ^= 1<<2;
                    break;
                case 'o':
                    statu ^= 1<<3;
                    break;
                case 'u':
                    statu ^= 1<<4;
                    break;
            }
            if(pos[statu]>0)ans = Math.max(ans,i+1-pos[statu]);
            else pos[statu]=i+1;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,3,-2,4};
        String str = "leetcodeisgreat";
        Solution s = new Solution();
//        int ans = s.maxProduct(nums);
        int ans = s.findTheLongestSubstring(str);
        System.out.println(ans);
        System.out.println(1<<1);
    }

}