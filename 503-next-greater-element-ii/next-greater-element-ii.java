import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] arr) {

        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        // 1️⃣ Pre-fill stack (simulate circular)
        for (int i = n - 1; i >= 0; i--) {
            st.push(arr[i]);
        }

        // 2️⃣ Actual computation
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        return nge;
    }
}
