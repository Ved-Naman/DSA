class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        // Split the first number
        String[] parts1 = num1.split("\\+");
        int a = Integer.parseInt(parts1[0]);
        int b = Integer.parseInt(parts1[1].replace("i", ""));

        // Split the second number
        String[] parts2 = num2.split("\\+");
        int c = Integer.parseInt(parts2[0]);
        int d = Integer.parseInt(parts2[1].replace("i", ""));

        // Apply the math formula
        int realPart = (a * c) - (b * d);
        int imaginaryPart = (a * d) + (b * c);

        // Build the final formatted string
        return realPart + "+" + imaginaryPart + "i";
    }
}