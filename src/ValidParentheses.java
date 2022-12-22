import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack theStack = new Stack();

        for(int i = 0;i<charArray.length;i++){
            if(theStack.isEmpty() == true){    // this handles the senario when stack is empty. we just skip the judgement
                theStack.push(charArray[i]);
                continue;
            }

            char topOne = (char) theStack.peek();
            if(canCancel(charArray[i],topOne)){  // decide if we should pop element from stack
                theStack.pop();
            }else{
                theStack.push(charArray[i]);
            }
        }
        return theStack.isEmpty();
    }

    public boolean canCancel(char fir,char sec){
        if((fir == ')' && sec =='(') || (fir == ']' && sec =='[') || (fir == '}' && sec =='{') ){
            return true;
        }
        return false;
    }
}