import java.util.Stack;
// refactored a lot. DRY
class EvaluateReversePolishNotation2 {
    Stack theStack = new Stack();
    public int evalRPN(String[] tokens) {
        int answer;
        int counter = 0;
        while(counter != tokens.length){
            String currentToken = tokens[counter];
            if(operandDicider(currentToken)){
                if(currentToken.equals("/")){
                    operate(currentToken);
                } else if(currentToken.equals("+")){
                    operate(currentToken);
                } else if(currentToken.equals("*")){
                    operate(currentToken);
                } else if(currentToken.equals("-")){
                    operate(currentToken);
                }
            }else{
                theStack.push(currentToken);
            }
            counter++;
        }
        return (int) Integer.valueOf((String) theStack.peek());
    }

    public void operate(String operand){
        // if operand is "/" and previous 2 are numbers
        String one = (String) theStack.pop();  // 前一个
        String two = (String) theStack.pop();  // 前两个
        int suan=0;
        if(operandDicider(one) == false && operandDicider(two) == false){
            int firstN = (int) Integer.valueOf(two);
            int secN = (int) Integer.valueOf(one);
            switch(operand) {
                case "+":
                    suan = firstN + secN;
                    break;
                case "-":
                    suan = firstN - secN;
                    break;
                case "*":
                    suan = firstN * secN;
                    break;
                case "/":
                    suan = firstN / secN;
                    break;
            }
            theStack.push(String.valueOf(suan));
        }else{
            theStack.push(two);
            theStack.push(one);
            theStack.push(operand);
        }
    }

    public boolean operandDicider(String token){
        if(token.equals("/") || token.equals("*") || token.equals("+") || token.equals("-")){
            return true;
        }else{
            return false;
        }
    }
}
