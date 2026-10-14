package JavaPractice;
public class twoSum{
    static void main(String[] args) {
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int front=0;
        int rear=numbers.length -1;

        for (int i = 0; i<numbers.length;i++){
            if ((numbers[front]+numbers[rear])== target){
                return new int[]{front + 1,rear + 1};
            }
            else if ((numbers[front]+numbers[rear])< target){

                front++;
            }else{
                rear--;
            }
        }
        return new int[]{};
    }

}
    int[] num ={2,7,8,9,10};
    int target = 9;
        Solution solution = new Solution();
        int[] test = solution.twoSum(num, target);
    }
}