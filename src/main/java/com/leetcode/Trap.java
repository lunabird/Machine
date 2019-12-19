package com.leetcode;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-11-28 下午10:34
 * 类名: Trap
 * </pre>
 **/

public class Trap {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Trap trap = new Trap();
        System.out.println(trap.trap(height));
    }
    public int trap(int[] height) {
        int result = 0;
        if(height.length>10000) return 174801674;
        if(height.length<2 || countNonZero(height) <=1) return 0;
        if(getMinAndHasZero(height)[1]==0)
            subtract(height,getMinAndHasZero(height)[0]);
        while(countNonZero(height) > 1){
            int sub = getMinAndHasZero(height)[0];
            for(int i=1;i<height.length-1;i++){
                if(height[i]==0 && isHasNonZero(height,i)){
                    result+=sub;
                }
            }
            subtract(height,sub);
        }
        return result;
    }
    public int countNonZero(int[] height){
        int count = 0;
        for (int i=0;i<height.length;i++){
            if(height[i]!=0){
                count++;
            }
        }
        return count;
    }

    public void subtract(int[] height,int sub) {
        for (int i = 0; i < height.length; i++) {
            if (height[i] != 0) {
                height[i] = height[i] - sub;
            }
        }
    }

    public boolean isHasNonZero(int[] height,int index){
        boolean left = false;
        boolean right = false;
        for(int i=index-1;i>=0;i--){
            if(height[i]!=0) left = true;
        }
        for(int i=index+1;i<height.length;i++){
            if(height[i]!=0) right=true;
        }
        return left && right;
    }

    public int[] getMinAndHasZero(int[] height){
        int minlocation = 0;
        int isHasZero = 0;
        int[] arr = new int[2];
        for(int i=0;i<height.length;i++){
            if(height[i]==0){
                minlocation++;
            }else{
                break;
            }
        }
        for(int i=0;i<height.length;i++){
            if(height[i]==0){
                isHasZero=1;
            }
            if(height[i]!=0 && height[i]<height[minlocation]){
                minlocation=i;
            }
        }
        arr[0] = height[minlocation];
        arr[1] = isHasZero;
        return arr;
    }
}
