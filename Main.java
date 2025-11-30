import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());
        sc.nextLine();
        List<String> shuffled = new ArrayList<>();
        for (int i = 0; i < N; i++) shuffled.add(sc.nextLine());
        sc.nextLine();
        List<String> original = new ArrayList<>();
        for (int i = 0; i < N; i++) original.add(sc.nextLine());

        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < N; i++) idx.put(original.get(i), i);

        int[] start = new int[N];
        for (int i = 0; i < N; i++) start[i] = idx.get(shuffled.get(i));

        int[] target = new int[N];
        for (int i = 0; i < N; i++) target[i] = i;

        if (Arrays.equals(start, target)) {
            System.out.println(0);
            return;
        }

        int ans = bidirectionalBlockBFS(start, target);
        System.out.println(ans);
    }

    static int bidirectionalBlockBFS(int[] start, int[] target) {
        String sEnc = encode(start), tEnc = encode(target);

        Map<String, Integer> distS = new HashMap<>();
        Map<String, Integer> distT = new HashMap<>();
        Queue<String> qS = new ArrayDeque<>();
        Queue<String> qT = new ArrayDeque<>();

        distS.put(sEnc, 0); qS.add(sEnc);
        distT.put(tEnc, 0); qT.add(tEnc);

        while (!qS.isEmpty() && !qT.isEmpty()) {
            int res;
            if (qS.size() <= qT.size()) {
                res = expandLayer(qS, distS, distT);
            } else {
                res = expandLayer(qT, distT, distS);
            }
            if (res != -1) return res;
        }
        return -1;
    }

    static int expandLayer(Queue<String> q, Map<String,Integer> distThis, Map<String,Integer> distOther) {
        int layerSize = q.size();
        while (layerSize-- > 0) {
            String curEnc = q.poll();
            int curDist = distThis.get(curEnc);
            int[] arr = decode(curEnc);

            int n = arr.length;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int cutLen = j - i + 1;
                    int[] cut = new int[cutLen];
                    int p = 0;
                    for (int x = i; x <= j; x++) cut[p++] = arr[x];

                    int[] remain = new int[n - cutLen];
                    p = 0;
                    for (int x = 0; x < i; x++) remain[p++] = arr[x];
                    for (int x = j+1; x < n; x++) remain[p++] = arr[x];

                    for (int k = 0; k <= remain.length; k++) {
                        if (k == i) continue;

                        int[] next = new int[n];
                        p = 0;
                        for (int x = 0; x < k; x++) next[p++] = remain[x];
                        for (int x = 0; x < cutLen; x++) next[p++] = cut[x];
                        for (int x = k; x < remain.length; x++) next[p++] = remain[x];

                        String nextEnc = encode(next);
                        if (distThis.containsKey(nextEnc)) continue;

                        if (distOther.containsKey(nextEnc)) {
                            return distThis.get(curEnc) + 1 + distOther.get(nextEnc);
                        }

                        distThis.put(nextEnc, curDist + 1);
                        q.add(nextEnc);
                    }
                }
            }
        }
        return -1;
    }

    static String encode(int[] arr) {
        StringBuilder sb = new StringBuilder(arr.length);
        for (int i = 0; i < arr.length; i++) {
            sb.append((char)('A' + arr[i]));
        }
        return sb.toString();
    }

    static int[] decode(String s) {
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.charAt(i) - 'A';
        return a;
    }
}
