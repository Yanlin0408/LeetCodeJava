import java.util.Stack;

class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack theStack = new Stack();
        int answer;
        int counter = 0;
        while(counter != tokens.length){
            String currentToken = tokens[counter];
            if(operandDicider(currentToken)){
                if(currentToken.equals("/")){
                    // if operand is "/" and previous 2 are numbers
                    String one = (String) theStack.pop();  // 前一个
                    String two = (String) theStack.pop();  // 前两个
                    if(operandDicider(one) == false && operandDicider(two) == false){
                        System.out.println("/ caobi");
                        int firstN = (int) Integer.valueOf(two);
                        int secN = (int) Integer.valueOf(one);
                        int suan = firstN/secN;
                        theStack.push(String.valueOf(suan));
                        System.out.println("xingde -- :"+suan);
                    }else{
                        theStack.push(two);
                        theStack.push(one);
                        theStack.push(currentToken);
                    }
                } else if(currentToken.equals("+")){
                    // if operand is "+" and previous 2 are numbers
                    String one = (String) theStack.pop();  // 前一个
                    String two = (String) theStack.pop();  // 前两个
                    if(operandDicider(one) == false && operandDicider(two) == false){
                        System.out.println("+ caobi");
                        int firstN = (int) Integer.valueOf(two);
                        int secN = (int) Integer.valueOf(one);
                        int suan = firstN + secN;
                        theStack.push(String.valueOf(suan));
                        System.out.println("xingde -- :"+suan);
                    }else{
                        theStack.push(two);
                        theStack.push(one);
                        theStack.push(currentToken);
                    }
                } else if(currentToken.equals("*")){
                    // if operand is "*" and previous 2 are numbers
                    String one = (String) theStack.pop();  // 前一个
                    String two = (String) theStack.pop();  // 前两个
                    if(operandDicider(one) == false && operandDicider(two) == false){
                        System.out.println("+ caobi");
                        int firstN = (int) Integer.valueOf(two);
                        int secN = (int) Integer.valueOf(one);
                        int suan = firstN * secN;
                        theStack.push(String.valueOf(suan));
                        System.out.println("xingde -- :"+suan);
                    }else{
                        theStack.push(two);
                        theStack.push(one);
                        theStack.push(currentToken);
                    }
                } else if(currentToken.equals("-")){
                    // if operand is "-" and previous 2 are numbers
                    String one = (String) theStack.pop();  // 前一个
                    String two = (String) theStack.pop();  // 前两个
                    if(operandDicider(one) == false && operandDicider(two) == false){
                        System.out.println("+ caobi");
                        int firstN = (int) Integer.valueOf(two);
                        int secN = (int) Integer.valueOf(one);
                        int suan = firstN - secN;
                        theStack.push(String.valueOf(suan));
                        System.out.println("xingde -- :"+suan);
                    }else{
                        theStack.push(two);
                        theStack.push(one);
                        theStack.push(currentToken);
                    }
                }

            }else{
                theStack.push(currentToken);
            }

            counter++;
        }

        return (int) Integer.valueOf((String) theStack.peek());
    }

    public boolean operandDicider(String token){
        if(token.equals("/") || token.equals("*") || token.equals("+") || token.equals("-")){
            return true;
        }else{
            return false;
        }
    }
}