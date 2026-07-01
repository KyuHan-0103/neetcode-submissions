class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        Integer[] res = new Integer[num1.length() + num2.length()];

        for(int i = 0; i < num1.length(); i++){
            int carry = 0;
            int n1 = num1.charAt(num1.length() - i - 1) - '0';
            for(int j = 0; j < num2.length(); j++){
                if(res[i + j] != null) carry += res[i + j];
                int n = (n1 * (num2.charAt(num2.length() - j - 1) - '0')) + carry;
                res[i + j] = n % 10;
                carry = n/10;
            }
            int t = 0;
            while(carry > 0){
                res[i + num2.length() + t] = carry % 10;
                carry /= 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = res.length - 1; i >= 0; i--){
            if(res[i] == null) continue;
            result.append(res[i]);
        }
        return new String(result);
    }
}
