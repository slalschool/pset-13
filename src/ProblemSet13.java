public class ProblemSet13 {

    public static void main(String[] args){

    }

    public boolean groupSum(int start, int[] numbers, int target) {
        if (target == 0) {
            return true;
        }
        if (start == numbers.length) {
            return false;
        }

        if (groupSum(start+1, numbers, target - numbers[start]) == true) {
            return true;
        }

        return groupSum(start+1, numbers, target);
    }

    public boolean groupSum6(int start, int[] numbers, int target) {
        int int = 0;
        for(int i = start; i < numbers.length; i++){
            if(numbers[i] == 6){
                int+=6;
                numbers[i] = 0;
            }
        }
        if(target - int <= 0){
            return target % 6 == 0;
        }
        return groupSum(start, numbers, target - int);
    }

    public boolean groupNoAdj(int start, int[] numbers, int target) {
        if (target == 0) {
            return true;
        }

        if (numbers.length < start) {
            return false;
        }

        if (groupNoAdj(start + 2, numbers, target - numbers[start])) {
            return true;
        }

        return groupNoAdj(start + 1, numbers, target);
    }

    public boolean groupSum5(int start, int[] numbers, int target) {
        if (numbers.length < start) {
            if (target == 0) {
                return true;
            }
            return false;
        }
        if (numbers[start] % 5 == 0) {
            if (start < numbers.length -1 && numbers[start+1] == 1) {
                return groupSum5(start + 2, numbers, target - numbers[start]);
            }
            return groupSum5(start + 1, numbers, target = numbers[start]);
        }
        if (groupSum5(start + 1, numbers, target - numbers[start])) {
            return true;
        }

        return groupSum5(start + 1, numbers, target);
    }

    public boolean groupSumClump(int start, int[] numbers, int target) {
        if (numbers.length < start) {
            if (target == 0) {
                return true;
            }

            return false;
        }

        int j = start + 1;

        for (int k = start + 1; k < numbers.length; k++) {
            if (numbers[start] == numbers[k]) {
                j++;
            }
        }

        if (groupSumClump(j, numbers, target - ((j - start) * numbers[start]))) {
            return true;
        }

        return groupSumClump(j, numbers, target);
    }

    public boolean splitArray(int[] numbers) {
        int sum = 0;
        for(int i : numbers){
            sum += i;
        }
        if(sum%2==1){
            return false;
        }
        else{
            return groupSum(0 , numbers, sum/2);
        }
    }

    public boolean splitOdd(int[] numbers) {
        if(numbers.length == 1){
            return numbers[0] % 2 == 1;
        }
        int sum = 0;

        for(int i : numbers) {
            sum += i;
        }
        int sumTenMultiples = 0;

        for(int i = 10; i <= sum; i+=10){
            if(groupSum(0, numbers, i)){
                sumTenMultiples = i;
                break;
            }
        }

        return (sum - sumTenMultiples) % 2 == 1;
    }
}